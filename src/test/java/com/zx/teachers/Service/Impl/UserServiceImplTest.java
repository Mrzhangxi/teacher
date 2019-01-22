package com.zx.teachers.Service.Impl;

import com.zx.teachers.Entity.User;
import com.zx.teachers.Service.UserService;
import com.zx.teachers.Utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void testACreateUser() {
        User user = new User();
        user.setUserName("zx1");
        user.setUserPwd("123321");
        user.setUserBirthday(DateUtils.stringToDate("1994-03-31"));
        user.setUserNickname("张曦");
        user.setUserImages("/");
//        user.setUserTitle();
        user.setUserType(2);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        System.out.println(userService.createNewUser(user));
    }

    @Test
    public void testBGetById() {
        User user = userService.getUserByID(2);
        System.out.println(user);
    }

    @Test
    public void testCGetByUsertype() {
        List<User> users = userService.getAllUserByUserType(1);
        System.out.println(users);
    }

    @Test
    public void testDModifyUser() {
        User user = new User();
        user.setId(1);
        user.setUserTitle("副教授");
        User user1 = userService.modifyUser(user);
        System.out.println(user1);
    }
}