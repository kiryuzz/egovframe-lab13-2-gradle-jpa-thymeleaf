package lab.egovframe.domain.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query(value = "select * from employee order by id", nativeQuery = true)
    List<Employee> findAllAsc();
}
