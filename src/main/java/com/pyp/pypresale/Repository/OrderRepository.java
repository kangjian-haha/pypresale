package com.pyp.pypresale.Repository;

import com.pyp.pypresale.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kangjian
 * @date 2019/4/3 23:52
 */
@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {


    Orders saveAndFlush(Orders orders);
}
