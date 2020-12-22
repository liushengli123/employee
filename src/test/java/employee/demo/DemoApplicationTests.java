package employee.demo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import employee.demo.Mapper.EmployeeMapper;
import employee.demo.pojo.Employee;
import employee.demo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DataSource dataSource;
//    测试连接数据库
    @Test
    void contextLoads() throws SQLException {
        System.out.println(""+dataSource.getConnection());
    }
//    测试更新操作
    @Test
    void update(){
        Employee employee = new Employee();
        employee.setEmpId(50);
        employee.setEmpGender("女");
        int insert = employeeMapper.updateById(employee);
        System.out.println(insert);
    }
//    测试添加操作
    @Test
    public void add(){
        Employee employee = new Employee();
        employee.setEmpId(40);
        employee.setEmpName("rose1");
        employee.setEmpGender("女");
        employee.setEmpBirth(new Date());
        employeeMapper.insert(employee);
    }
//    测试乐观锁
    @Test
    public void testOptimisticLocker(){
//        单个查询
        Employee employee = employeeMapper.selectById(30);
//        多个查询
        List<Employee> employeeList = employeeMapper.selectBatchIds(Arrays.asList(50, 51, 52));
        System.out.println(employeeList);
        employee.setEmpGender("男");
        employeeMapper.updateById(employee);
    }
//    测试分页查询
    @Test
    public void tetsPage(){
        Page<Employee> page = new Page<>(1,3);
        employeeMapper.selectPage(page,null);
        System.out.println(page.getCurrent());
    }
//    测试逻辑删除
    @Test
    public void delete(){
        employeeMapper.deleteById(50);
    }
}
