package lab.egovframe.web.dto.employee;

import lab.egovframe.domain.employee.Employee;
import lombok.Getter;

@Getter
public class EmployeeResponseDto {
    private String id;
    private String name;
    private String dept;
    private int age;
    private String phone;
    private String email;
    private String addr;

    public EmployeeResponseDto(Employee entity) {
        this.id = entity.getId();
        this.dept = entity.getDept();
        this.name = entity.getName();
        this.age = entity.getAge();
        this.phone = entity.getPhone();
        this.email = entity.getEmail();
        this.addr = entity.getAddr();
    }
}
