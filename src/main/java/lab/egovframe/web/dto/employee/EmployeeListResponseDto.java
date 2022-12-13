package lab.egovframe.web.dto.employee;

import lab.egovframe.domain.employee.Employee;
import lombok.Getter;

@Getter
public class EmployeeListResponseDto {
    private String id;
    private String name;

    public EmployeeListResponseDto(Employee entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
