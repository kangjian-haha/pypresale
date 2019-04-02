package com.pyp.pypresale.Entity;




import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "user")
public class User {


    @GeneratedValue
    @Column(name = "userID")
    private Integer userID;

    @NotEmpty(message = "学号不能为空!")
    @Id
    @Column(name = "studentID")
    private String studentID;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "photo")
    private String photo;


    public User() {
    }

}
