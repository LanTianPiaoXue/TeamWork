package com.ygz.learn.spring.ioc.dao;
import com.ygz.learn.spring.ioc.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by admin on 2017/8/14.
 */
public class UserDaoImpl implements  UserDao {
    static List<UserEntity> db = new ArrayList<UserEntity>(10);
    static {
        for (int id = 0; id < db.size(); id++){
            String idNum = String.valueOf(id);
            UserEntity userEntity = new UserEntity(String.valueOf(id),"Juice"+id,"Yan"+id,id+10);
            db.add(userEntity);
        }
    }

    public void saveUser(UserEntity userEntity) {
        System.out.println("Dao save userEntity------------"+ userEntity);
        db.add(userEntity);
    }

    public List<UserEntity> getUser(String id) {
        List<UserEntity> userEntities = db.stream().filter(user -> user.getId().contains(id)).collect(Collectors.toList());
        return userEntities;
    }
}
