package com.pyp.pypresale.Entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 商品实体类
 */

@EntityListeners(AuditingEntityListener.class)//自动更新时间需要
@Data
@Entity
@Table(name = "good")
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "goodid")
    private Integer goodID;


    @Column(name = "userid")
    private Integer userID;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    private String type;

    @Column(name = "text")
    private String text;

    @Column(name = "saleing")
    private Integer saleing;

    @Column(name = "price")
    private float price;

    @Column(name = "imageUrl")
    private String imageUrl;

    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;

    @LastModifiedDate
    @Column(name = "updata_time")
    private Date updataTime;

    public Good() {
    }

}
