package com.zx.teachers.Controller;

import com.zx.teachers.Entity.User;
import com.zx.teachers.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 获取所有用户
     * @return
     */
    @RequestMapping("/all")
    @ResponseBody
    public List<User> getAllUser(){
        List<User> users = userService.getAllUserByUserType(1);
        return users;
    }

    /**
     * 根据用户ID查找用户
     * @param id
     * @return
     */
    @RequestMapping("/getuser")
    @ResponseBody
    public User getUserByID(@RequestParam(value = "id", required = true) Integer id) {
        return userService.getUserByID(id);
    }

    /**
     * 创建用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public User createUser(User user) {
        return userService.createNewUser(user);
    }

    /**
     * 根据用户类型查找用户
     * @param usertype
     * @return
     */
    @RequestMapping("/allbytype")
    @ResponseBody
    public List<User> getUserByType(@RequestParam(value = "usertype", required = false, defaultValue = "1") Integer usertype) {
        return userService.getAllUserByUserType(usertype);
    }

    /**
     * 修改User
     * @param user
     * @return
     */
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    @ResponseBody
    public User modifyUser(User user) {
        user.setUpdateTime(new Date());
        return userService.modifyUser(user);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public User deleteUser(Integer userID) {
        User user = userService.getUserByID(userID);
        user.setUpdateTime(new Date());
        return userService.deleteUser(user);
    }


}
