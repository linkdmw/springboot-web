package xyz.link666.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.link666.pojo.User;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/28 9:43
 */
@Mapper
@Repository
public interface UserDao {

    User selectUserByLoginUser(User user);
}
