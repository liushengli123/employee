package employee.demo.Mapper;

import employee.demo.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmployeeMapper {
//    void save(Employee employee);
    List<Employee> getEmps();
}
