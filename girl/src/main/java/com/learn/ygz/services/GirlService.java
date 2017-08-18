package com.learn.ygz.services;

import com.learn.ygz.entity.Girl;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2017/7/1.
 */
@Component
public interface GirlService{
    Integer deleteGirl(Girl girl);
    Integer deleteGirlById(Integer id);
    Integer updateGirl(Girl girl);
    Integer insertGirl(Girl girl);
    Girl insertGirl1(Girl girl);
    Girl getGirl(Integer id);
    List<Girl> getGirls();
}
