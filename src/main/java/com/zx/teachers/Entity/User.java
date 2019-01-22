package com.zx.teachers.Entity;

import lombok.Cleanup;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String userName;
    private String userPwd;
    private String userNickname;
    private String userImages;
    private Date userBirthday;
    //Type: 1是教师、2是领导
    private Integer userType;
    private String userTitle;
    //用户状态标识，99为删除用户
    private Integer userFlag;
    private Date createTime;
    private Date updateTime;

}
