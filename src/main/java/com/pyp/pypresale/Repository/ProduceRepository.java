package com.pyp.pypresale.Repository;

import com.pyp.pypresale.Entity.Produce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduceRepository extends JpaRepository<Produce,Integer> {
}
