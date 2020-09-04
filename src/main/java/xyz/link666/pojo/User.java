package xyz.link666.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/28 9:38
 */
@ApiModel(value = "user对象",description = "用于登录的用户对象")
@Data
public class User implements Serializable {

    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "用户角色")
    private String role;
}
