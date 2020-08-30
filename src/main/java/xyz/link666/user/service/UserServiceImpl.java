package xyz.link666.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.link666.user.dao.UserDao;
import xyz.link666.pojo.User;
import xyz.link666.user.service.UserService;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/28 9:44
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User userLogin(User user) {
        return userDao.selectUserByLoginUser(user);
    }
}
