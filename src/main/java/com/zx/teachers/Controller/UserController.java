package com.zx.teachers.Controller;

import com.zx.teachers.Convertor.UserConvertor;
import com.zx.teachers.Entity.User;
import com.zx.teachers.ResultVO.UserVO;
import com.zx.teachers.Service.UserService;
import com.zx.teachers.Utils.FileUtils;
import com.zx.teachers.enums.UserEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
@Slf4j
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
    public List<UserVO> getAllUser(){
        log.info("getAllUser执行");
        List<User> users = userService.getAllUserByUserType(UserEnum.TEACHER.getCode());
        List<UserVO> userVOS = new ArrayList<UserVO>();
        for(User user : users) {
            userVOS.add(UserConvertor.userToUserVO(user));
        }
        return userVOS;
    }

    /**
     * 根据用户ID查找用户
     * @param id
     * @return
     */
    @RequestMapping("/getuser")
    @ResponseBody
    public UserVO getUserByID(@RequestParam(value = "id", required = true) Integer id) {
        log.info("GetUserByID执行");
        return UserConvertor.userToUserVO(userService.getUserByID(id));
    }

    /**
     * 创建用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createUser(UserVO userVO, @RequestParam(value = "newuserimg", required = false) MultipartFile file) {

        //处理图片
        String userImgPath = FileUtils.saveUserImg(file);

        userVO.setUserImages(userImgPath);
        System.out.println(userVO);
        userVO.setUserType("教师");//设置默认值
        userVO.setUserFlag("正常");//设置默认值
        User user = UserConvertor.userVOToUser(userVO);
        userService.createNewUser(user);
        return "admin/success";
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
     * @param userVO
     * @return
     */
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public String modifyUser(UserVO userVO) {
        System.out.println(userVO);
        User user = UserConvertor.userVOToUser(userVO);
        user.setUpdateTime(new Date());
        userService.modifyUser(user);
        return "admin/success";
    }

    @RequestMapping("/delete")
//    @ResponseBody
    public String deleteUser(@RequestParam(value = "id", required = true) Integer userID) {
        User user = userService.getUserByID(userID);
        user.setUpdateTime(new Date());
        userService.deleteUser(user);
        return "admin/success";
    }


}
