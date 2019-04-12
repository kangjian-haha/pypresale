package com.pyp.pypresale.Repository;

import com.pyp.pypresale.Entity.Collection;
import com.pyp.pypresale.Entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kangjian
 * @date 2019/4/3 23:52
 */
@Repository
public interface CollectionRepository extends JpaRepository<Collection,Integer> {

    //取消收藏商品
    @Modifying
    @Query(value = "delete from Collection c where c.userID=?1 and c.goodID=?2 ")
    int cancelGoodOfCollection(Integer userID, Integer goodID);

    //联表查询,从Collection中间表连接到Good表查询商品信息
    //@Query(value = "select g.* from collection co inner join good g on co.goodid=g.goodid where co.userid=?1",nativeQuery = true)
    @Query(value = "select g from Collection c ,Good g where c.goodID = g.goodID and c.userID=?1")
    List<Good> findCollectionsByUserID(Integer userID);




}
