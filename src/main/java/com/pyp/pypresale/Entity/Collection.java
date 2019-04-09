package com.pyp.pypresale.Entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author kangjian
 * @date 2019/4/3 21:17
 *
 * 收藏夹:用户收藏商品用的
 */

@EntityListeners(AuditingEntityListener.class)//自动更新时间需要
@Data
@Entity
@Table(name = "collection")
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CollectionID")
    private Integer collectionID;

    @Column(name = "UserID")
    private Integer userID;

    @Column(name = "GoodID")
    private Integer goodID;

    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;
}
