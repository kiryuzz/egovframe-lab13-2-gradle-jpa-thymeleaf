package lab.egovframe.web.controller;

import lab.egovframe.service.employee.EmployeeService;
import lab.egovframe.web.dto.employee.EmployeeResponseDto;
import lab.egovframe.web.dto.employee.EmployeeSaveRequestDto;
import lab.egovframe.web.dto.employee.EmployeeUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class empApiController {
    private final EmployeeService employeeService;

    //등록
    @PostMapping("/api/emp")
    public String save(@RequestBody EmployeeSaveRequestDto requestDto) {
        return employeeService.save(requestDto);
    }

    //조회
    @GetMapping("/api/emp/{id}")
    public EmployeeResponseDto findById(@PathVariable String id) {
        return employeeService.findById(id);
    }

    //수정
    @PutMapping("/api/emp/{id}")
    public String update(@PathVariable String id, @RequestBody EmployeeUpdateRequestDto requestDto) {
        return employeeService.update(id, requestDto);
    }

    @DeleteMapping("/api/emp/{id}")
    public String delete(@PathVariable String id) {
        employeeService.delete(id);
        return id;
    }



}
