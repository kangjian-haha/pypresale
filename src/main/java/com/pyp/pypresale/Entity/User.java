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
    @Column(name = "UserID")
    private Integer userID;

    //@NotEmpty(message = "学号不能为空!")
    @Column(name = "StudentID",unique = true)
    private String studentID;

   // @NotEmpty(message = "用户名不能为空!")
    @Column(name = "Username",unique = true)
    private String username;

    //@NotEmpty(message = "密码不能为空!")
    @Column(name = "Password")
    private String password;

    @Column(name = "Role")
    private String role;

    @Column(name = "Sex")
    private String sex;

    @Column(name = "Telephone",unique = true)
    private String telephone;

    @Column(name = "Photo")
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
