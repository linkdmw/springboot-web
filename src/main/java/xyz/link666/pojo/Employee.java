package xyz.link666.pojo;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by IDEA.
 * @Date: 2020/8/4 18:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private Integer id;
    private String email;
    private Integer gender;
    private Date birthday;
    private Integer department_id;
    //关联属性
    private Department department;

}
