package employee.demo.service.Impl;

import employee.demo.Mapper.EmployeeMapper;
import employee.demo.pojo.Employee;
import employee.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public List<Employee> getEmps() {
        return employeeMapper.getEmps();
    }
}
