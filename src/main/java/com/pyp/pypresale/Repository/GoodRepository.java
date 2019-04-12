package com.pyp.pypresale.Repository;

import com.pyp.pypresale.Entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kangjian
 * @date 2019/4/3 20:38
 */
@Repository
public interface GoodRepository extends JpaRepository<Good,Integer> {

    //查看在售商品详情
    @Query(value = "select g from Good g where g.goodID = ?1 and g.saleing= 1 ")
    Good findViewGoodDetails(Integer goodID);

    //查找全部在售的商品
    @Query(value = "select g from Good g where g.saleing=1 ")
    List<Good> findAllOfGoods();

    //查找分类在售的商品
    @Query(value = "select g from Good g where g.type= ?1 and g.saleing=1")
    List<Good> findTypeOfGoods(String type);


    //从标题和详情文本里 搜索在售的商品
    @Query(value = "select g from Good g where g.title like concat( '%',?1,'%') or g.text like concat( '%',?1,'%') and g.saleing = '1'")
    List<Good> findSearchForGoods(String keyword);


    //判断GoodID的商品是否在售
    boolean existsByGoodIDAndSaleingNot(Integer goodID,Integer saleing);

    //将goodID的商品更新为不在售
    @Modifying
    @Query(value = "update Good g set g.saleing=0 where g.goodID=?1")
    void updateGoodIDIsNotSaleing(Integer goodID);


    //删除自己发布的商品
    @Modifying
    @Query(value = "delete from Good g where g.goodID=?1 and g.userID=?2")
    int deleteGoodById(Integer goodID,Integer userID);

    //查找自己发布的商品
    List<Good> findAllByUserID(Integer userID);

    //根据商品ID查找商品
    Good findByGoodID(Integer goodID);

    //修改商品信息
    @Modifying
    @Query(value = "update Good g set g.title=?1,g.text=?2,g.price=?3,g.type=?4 where g.goodID=?5 ")
    void alterGoodInformation(String title,String text,float price,String type,Integer goodID);

    List<Good> findGoodsByGoodID(List<Integer> goodIDs);
}
