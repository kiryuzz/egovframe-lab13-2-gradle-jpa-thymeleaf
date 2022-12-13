package lab.egovframe.service.employee;

import lab.egovframe.domain.employee.Employee;
import lab.egovframe.domain.employee.EmployeeRepository;
import lab.egovframe.web.dto.employee.EmployeeListResponseDto;
import lab.egovframe.web.dto.employee.EmployeeResponseDto;
import lab.egovframe.web.dto.employee.EmployeeSaveRequestDto;
import lab.egovframe.web.dto.employee.EmployeeUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Transactional
    public String save(EmployeeSaveRequestDto requestDto) {
        return employeeRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<EmployeeListResponseDto> findAllAsc() {
        return employeeRepository.findAllAsc().stream()
                .map(EmployeeListResponseDto::new)
                .collect(Collectors.toList());
    }

    public EmployeeResponseDto findById(String id) {
        Employee entity = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사원은 존재하지 않습니다. id = " + id));
        return new EmployeeResponseDto(entity);
    }

    @Transactional
    public String update(String id, EmployeeUpdateRequestDto requestDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 사원은 존재하지 않습니다. id = " + id));
        employee.update(requestDto.getDept(), requestDto.getName(), requestDto.getAge(), requestDto.getPhone(), requestDto.getEmail(), requestDto.getAddr());
        return id;
    }

    @Transactional
    public void delete(String id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사원은 존재하지 않습니다. id = " + id));
        employeeRepository.delete(employee);
    }
}
