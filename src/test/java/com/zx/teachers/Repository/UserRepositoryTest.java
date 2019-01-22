package com.zx.teachers.Repository;

import com.zx.teachers.Entity.User;
import com.zx.teachers.Utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAsave(){
        User user = new User();
        user.setUserName("zx");
        user.setUserPwd("123321");
        user.setUserBirthday(DateUtils.stringToDate("1994-03-31"));
        user.setUserNickname("张曦");
        user.setUserImages("/");
//        user.setUserTitle();
        user.setUserType(1);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        User user1 = userRepository.save(user);
        System.out.println(user1);
    }

    @Test
    public void testBget() {
        User user = userRepository.findById(1);
        System.out.println(user);
    }

    @Test
    public void testCdelete() {
        User user = userRepository.deleteById(1);
        System.out.println(user);
    }

    @Test
    public void testDModify() {
        userRepository.updateById(1);
    }
}