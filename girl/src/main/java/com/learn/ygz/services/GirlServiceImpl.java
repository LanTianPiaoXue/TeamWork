package com.learn.ygz.services;

import com.learn.ygz.entity.Girl;
import com.learn.ygz.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/7/1.
 */
@Service("girlService")
public class GirlServiceImpl implements  GirlService,Serializable{
    @Autowired
    private GirlRepository girlRepository;

    @Override
    public Integer deleteGirl(Girl girl) {
         girlRepository.delete(girl);
        return girl.getId();
    }

    @Override
    public Integer deleteGirlById(Integer id) {
        girlRepository.delete(id);
        return id;
    }

    @Override
    public Integer updateGirl(Girl girl) {
        girlRepository.save(girl);
        return girl.getId();

    }

    @Override
    public Integer insertGirl(Girl girl) {
        Girl girl1 = girlRepository.save(girl);
        return girl1.getId();
    }

    @Override
    public Girl insertGirl1(Girl girl) {
         return this.girlRepository.save(girl);
    }

    @Override
    public Girl getGirl(Integer id) {
        return girlRepository.findOne(id);
    }

    @Override
    public List<Girl> getGirls() {
        return girlRepository.findAll();
    }
}
