package lab.egovframe.web.dto.employee;

import lab.egovframe.domain.employee.Employee;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EmployeeSaveRequestDto {
    private String id;
    private String name;
    private String dept;
    private int age;
    private String phone;
    private String email;
    private String addr;

    @Builder
    public EmployeeSaveRequestDto(String id, String dept, String name, int age, String phone, String email, String addr) {
        this.id = id;
        this.dept = dept;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.addr = addr;
    }

    public Employee toEntity() {
        return Employee.builder()
                .id(id)
                .dept(dept)
                .name(name)
                .age(age)
                .phone(phone)
                .email(email)
                .addr(addr)
                .build();
    }
}
