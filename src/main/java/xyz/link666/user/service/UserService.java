package xyz.link666.user.service;

import xyz.link666.pojo.User;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/28 9:43
 */

public interface UserService {
    /** 三大
     * @param user 请问
     * @return ad
     */
    User userLogin(User user);

    /** 根据用户名查询用户是否存在
     * @param username 用户名
     * @return User
     */
    User selectUserByUsername(String username);
}
