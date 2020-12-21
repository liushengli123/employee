package employee.demo.controller;

import employee.demo.pojo.Employee;
import employee.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        List<Employee> employeeList = employeeService.getEmps();
        System.out.println(employeeList);
        return "success";
    }
}
