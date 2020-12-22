package employee.demo.pojo;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

//    通过lombok实现实体类简化
@Data
public class Employee {
//    mp自动生成主键id的策略
//    此注解跟根据id做查询和修改息息相关，这些操作会将此id作为查询条件，不加此注解出现空指针异常
    @TableId(type = IdType.ID_WORKER)
    Integer empId;
    String empName;
    String empGender;
    Date empBirth;
//    设置自动生成创建时间
    @TableField(fill = FieldFill.INSERT)
    Date createTime;
//    设置自动更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    Date updateTime;
//    数据库的锁相关的概念
    /*
    * 由于事务隔离级别，产生读的问题（脏读  幻读  不可重读）
    * 1、排它锁 指对于多个不同的事务，对同一个资源只能有一把锁
    * 2、共享锁 共享锁指的就是对于多个不同的事务，对同一个资源共享同一个锁
    * 产生写的问题（丢失更新问题）
    * 1、乐观锁 乐观锁是指操作数据库时(更新操作)，想法很乐观，认为这次的操作不会导致冲突，在操作数据时，并不进行任何其他的特殊处理（也就是不加锁），
    *       而在进行更新后，再去判断是否有冲突了。通过添加一个version版本号来控制
    * 2、悲观锁 悲观锁就是在操作数据时，认为此操作会出现数据冲突，所以在进行每次操作时都要通过获取锁才能进行对相同数据的操作
    *
    * */
    @TableField(fill = FieldFill.INSERT)
    @Version
    Integer version;

    @TableLogic
    Integer deleted;
}
