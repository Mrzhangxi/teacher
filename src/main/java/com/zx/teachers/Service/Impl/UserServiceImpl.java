package com.zx.teachers.Service.Impl;

import com.zx.teachers.Entity.User;
import com.zx.teachers.Repository.UserRepository;
import com.zx.teachers.Service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanIsAbstractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createNewUser(User user) {
        User user1 = userRepository.save(user);
        return user1;
    }

    @Override
    public User getUserByID(int id) {
        User user = userRepository.findById(id);
        return user;
    }

    @Override
    public List<User> getAllUserByUserType(int userTpye) {
        List<User> users = userRepository.findAllByUserType(userTpye);
        return users;
    }

    @Override
    public User modifyUser(User user) {
        int userId = user.getId();

        User oldUser = userRepository.findById(userId);
        Date temp = user.getCreateTime();
        BeanUtils.copyProperties(user, oldUser);
        oldUser.setId(userId);
        oldUser.setCreateTime(temp);
        userRepository.save(user);
        return userRepository.findById(userId);
    }

    @Override
    public User deleteUser(User user) {
        int userId = user.getId();
        User oldUser = userRepository.findById(userId);
        oldUser.setUserFlag(99);
        userRepository.save(oldUser);
        return userRepository.findById(userId);
    }
}
