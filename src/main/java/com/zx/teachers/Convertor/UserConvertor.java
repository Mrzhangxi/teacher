package com.zx.teachers.Convertor;

import com.zx.teachers.Entity.User;
import com.zx.teachers.ResultVO.UserVO;
import com.zx.teachers.Utils.DateUtils;
import com.zx.teachers.enums.UserEnum;

import java.util.Date;

public class UserConvertor {

    /**
     * 将User类型转换为UserVO类型，用来显示
     * @param user
     * @return
     */
    public static UserVO userToUserVO(User user) {
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setUserName(user.getUserName());
        userVO.setUserPwd(user.getUserPwd());
        userVO.setUserNickname(user.getUserNickname());
        userVO.setUserImages(user.getUserImages());
        userVO.setUserType(UserEnum.getUserType(user.getUserType()).getMsg());
        userVO.setUserTitle(user.getUserTitle());
        userVO.setUserBirthday(DateUtils.dateToString(user.getUserBirthday()));
        userVO.setCreateTime(DateUtils.dateToString(user.getCreateTime()));
        userVO.setUpdateTime(DateUtils.dateToString(user.getUpdateTime()));
        userVO.setUserFlag(UserEnum.getUserFlag(user.getUserFlag()).getMsg());
        return userVO;
    }

    /**
     * 将UserVO转换为User，用来存储
     * @param userVO
     * @return
     */
    public static User userVOToUser(UserVO userVO) {
        User user = new User();
        user.setId(userVO.getId());
        user.setUserName(userVO.getUserName());
        user.setUserPwd(userVO.getUserPwd());
        user.setUserNickname(userVO.getUserNickname());
        if (userVO.getUserImages() == null){
            user.setUserImages("/");
        } else {
            user.setUserImages(userVO.getUserImages());
        }
        user.setUserType(UserEnum.getUserCode(userVO.getUserType()).getCode());
        user.setUserTitle(userVO.getUserTitle());
        user.setUserBirthday(DateUtils.stringToDate(userVO.getUserBirthday()));
        if (userVO.getCreateTime() == null || "".equals(userVO.getCreateTime())){
            user.setCreateTime(new Date());
        } else {
            user.setCreateTime(DateUtils.stringToDate(userVO.getCreateTime()));
        }
        if (userVO.getUpdateTime() == null || "".equals(userVO.getUpdateTime())){
            user.setUpdateTime(new Date());
        } else {
            user.setUpdateTime(DateUtils.stringToDate(userVO.getUpdateTime()));
        }
        user.setUserFlag(UserEnum.getUserCode(userVO.getUserFlag()).getCode());
        System.out.println(user);
        return user;
    }
}
