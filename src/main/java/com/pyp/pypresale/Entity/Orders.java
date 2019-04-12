package com.pyp.pypresale.Entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author kangjian
 * @date 2019/4/3 21:06
 * 订单类
 */

@EntityListeners(AuditingEntityListener.class)//自动更新时间需要
@Data
@Table(name = "orders")
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderid")
    private Integer orderID;

    @Column(name = "userid")
    private Integer userID;

    @Column(name = "goodid")
    private Integer goodID;

    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;

    public Orders() {
    }
}
