package lab.egovframe.web.controller;

import lab.egovframe.service.employee.EmployeeService;
import lab.egovframe.web.dto.employee.EmployeeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final EmployeeService employeeService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/employee/employeeList")
    public String empList(Model model) {
        model.addAttribute("employeeList", employeeService.findAllAsc());
        return "employeeList";
    }

    @GetMapping("/employee/Add")
    public String empAdd() {
        return "employeeAdd";
    }

    @GetMapping("/employee/{id}")
    public String empView(@PathVariable String id, Model model) {
        EmployeeResponseDto dto = employeeService.findById(id);
        model.addAttribute("employee", dto);
        return "employeeView";
    }

    @GetMapping("/employee/update/{id}")
    public String empUpdate(@PathVariable String id, Model model) {
        EmployeeResponseDto dto = employeeService.findById(id);
        model.addAttribute("employee", dto);
        return "employeeUpdate";
    }
}
