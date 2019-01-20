package com.zx.teachers.Service;

import com.zx.teachers.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    /**
     * 创建一个新的用户（包括老师/领导）
     * @param user
     * @return
     */
    User createNewUser(User user);

    /**
     * 通过用户ID查找用户
     * @param id 用户ID
     * @return
     */
    User getUserByID(int id);

    /**
     * 通过用户类型查找对应的所有用户
     * @param userTpye 用户类型，1是教师，2是领导
     * @return
     */
    List<User> getAllUserByUserType(int userTpye);

    User modifyUser()
}
