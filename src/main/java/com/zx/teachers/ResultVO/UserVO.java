package com.zx.teachers.ResultVO;

import lombok.Data;

@Data
public class UserVO {
    private Integer id;
    private String userName;
    private String userPwd;
    private String userNickname;
    private String userImages;
    private String userBirthday;
    private String userType;
    private String userTitle;
    private String userFlag;
    private String createTime;
    private String updateTime;
}
