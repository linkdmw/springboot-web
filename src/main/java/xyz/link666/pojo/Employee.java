package xyz.link666.pojo;

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
    //关联属性
    private Department department;

}
