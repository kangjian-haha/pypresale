package com.pyp.pypresale.Repository;

import com.pyp.pypresale.Entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kangjian
 * @date 2019/4/3 23:52
 */
@Repository
public interface CollectionRepository extends JpaRepository<Collection,Integer> {
}
