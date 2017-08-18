package com.learn.ygz.repository;

import com.learn.ygz.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/7/1.
 */
@Repository("girlRepository")
public interface GirlRepository extends JpaRepository<Girl,Integer> {

}
