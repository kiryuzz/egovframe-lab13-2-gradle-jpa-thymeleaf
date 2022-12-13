package lab.egovframe.web.dto.employee;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EmployeeUpdateRequestDto {
    private String name;
    private String dept;
    private int age;
    private String phone;
    private String email;
    private String addr;

    @Builder
    public EmployeeUpdateRequestDto(String dept, String name, int age, String phone, String email, String addr) {
        this.dept = dept;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.addr = addr;
    }
}
