package employee.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import employee.demo.pojo.Employee;
import employee.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class EmployeeController {
    @Resource
    EmployeeService employeeService;

    @RequestMapping("/list")
    public String list(Model model){
//        Page<Employee> page=new Page<>(pn,3);
        List<Employee> employeeList = employeeService.getEmps();
        model.addAttribute("emps",employeeList);
//        model.addAttribute("page",page);
        return "list";
    }
}
