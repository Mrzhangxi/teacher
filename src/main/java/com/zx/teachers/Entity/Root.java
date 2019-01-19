package com.zx.teachers.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "t_root")
public class Root {
    @Id
    private Integer id;
    private String adminName;
    private String adminPassword;
    private Date createTime;
    private Date updateTime;

}
