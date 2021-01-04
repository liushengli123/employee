package employee.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import employee.demo.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;



@Mapper
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {
}

