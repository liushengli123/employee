package employee.demo.service.Impl;

import employee.demo.Mapper.EmployeeMapper;
import employee.demo.pojo.Employee;
import employee.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    EmployeeMapper employeeMapper;

    @Override
    public void save(Employee employee) {
        employeeMapper.insert(employee);
    }
}
