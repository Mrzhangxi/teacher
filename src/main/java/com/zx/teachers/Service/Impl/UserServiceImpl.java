package com.zx.teachers.Service.Impl;

import com.zx.teachers.Entity.User;
import com.zx.teachers.Repository.UserRepository;
import com.zx.teachers.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//        User oldUser = userRepository.findById(1);
//        oldUser.setUserTitle(user.getUserTitle());
//
//        return oldUser;
        return null;
    }

    @Override
    public User deleteUser(User user) {
        return null;
    }
}
