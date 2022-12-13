package lab.egovframe.domain.employee;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    private String id;

    @Column(length = 2)
    private String dept;

    @Column(length = 10)
    private String name;

    private int age;

    @Column(length = 20)
    private String phone;

    @Column(length = 20)
    private String email;

    @Column(length = 100)
    private String addr;

    @Builder
    public Employee(String id, String dept, String name, int age, String phone, String email, String addr) {
        this.id = id;
        this.dept = dept;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.addr = addr;
    }

    public void update(String dept, String name, int age, String phone, String email, String addr) {
        this.dept = dept;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.addr = addr;
    }
}
