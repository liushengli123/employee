package employee.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import employee.demo.Mapper.EmployeeMapper;
import employee.demo.pojo.Employee;
import employee.demo.pojo.Msg;
import employee.demo.service.EmployeeService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.Iterator;
import java.util.List;

@Controller
public class EmployeeController {
    @Resource
    EmployeeService employeeService;
    @Resource
    EmployeeMapper employeeMapper;

    @RequestMapping("/list")
    public String list(Model model,@RequestParam(defaultValue = "1",value = "pn") Integer pn){
        Page<Employee> page=new Page<>(pn,3);
        IPage<Employee> iPage = employeeMapper.selectPage(page, null);
        model.addAttribute("page",iPage);
        return "list";
    }

    @RequestMapping("/list/{empId}")
    public Msg getById(@PathVariable("empId") Long empId){
        Employee employee = employeeMapper.selectById(empId);
        return Msg.success().add("emp",employee);
    }

    @RequestMapping("/delete/{empId}")
    public String delete(@PathVariable("empId") Long empId){
        employeeMapper.deleteById(empId);
        return "redirect:/list";
    }

    @RequestMapping("/save")
    @ResponseBody
    public Msg save(Employee employee){
        System.out.println(employee);
        employeeMapper.insert(employee);
        return Msg.success();
    }

    @RequestMapping("/update")
    public Msg update(Employee employee){
        employeeMapper.updateById(employee);
        return Msg.success();
    }

}
