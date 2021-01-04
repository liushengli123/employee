package employee.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import employee.demo.Mapper.EmployeeMapper;
import employee.demo.pojo.Employee;
import employee.demo.pojo.Msg;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class EmployeeController {
    @Resource
    EmployeeMapper employeeMapper;

    @RequestMapping("/index")
    public Msg list(@RequestParam(defaultValue = "1",value = "pn") Integer pn){
        Page<Employee> page=new Page<>(pn,3);
        IPage<Employee> iPage = employeeMapper.selectPage(page, null);
        return Msg.success().add("pageInfo",iPage);
    }

    @RequestMapping("/list/{empId}")
    public Msg getById(@PathVariable("empId") Long empId){
        Employee employee = employeeMapper.selectById(empId);
        return Msg.success().add("emp",employee);
    }

    @RequestMapping("/delete/{empId}")
    public Msg delete(@PathVariable("empId") Long empId){
        employeeMapper.deleteById(empId);
        return Msg.success();
    }

    @RequestMapping("/save")
    public Msg save(Employee employee){
        employeeMapper.insert(employee);
        return Msg.success();
    }

    @RequestMapping("/update")
    public Msg update(Employee employee){
        employeeMapper.updateById(employee);
        return Msg.success();
    }

}
