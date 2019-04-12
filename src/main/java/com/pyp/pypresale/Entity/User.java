package com.pyp.pypresale.Entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户实体类
 */

@EntityListeners(AuditingEntityListener.class)//自动更新时间需要
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Integer userID;

    //@NotEmpty(message = "学号不能为空!")
    @Column(name = "studentid",unique = true)
    private String studentID;

   // @NotEmpty(message = "用户名不能为空!")
    @Column(name = "username",unique = true)
    private String username;

    //@NotEmpty(message = "密码不能为空!")
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "sex")
    private String sex;

    @Column(name = "telephone",unique = true)
    private String telephone;

    @Column(name = "photo")
    private String photo;

    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;

    @LastModifiedDate
    @Column(name = "updata_time")
    private Date updataTime;


    public User() {
    }

}
