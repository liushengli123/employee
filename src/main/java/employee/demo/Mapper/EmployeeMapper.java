package employee.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import employee.demo.pojo.Employee;;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {
}
