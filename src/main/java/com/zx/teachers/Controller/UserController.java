package com.zx.teachers.Controller;

import com.zx.teachers.Entity.User;
import com.zx.teachers.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/all")
    @ResponseBody
    public List<User> getAllUser(){
        List<User> users = userService.getAllUserByUserType(1);
        return users;
    }

    @RequestMapping("/getuser")
    @ResponseBody
    public User getUserByID(@RequestParam(value = "id", required = true) Integer id) {
        return userService.getUserByID(id);
    }

    public
}
