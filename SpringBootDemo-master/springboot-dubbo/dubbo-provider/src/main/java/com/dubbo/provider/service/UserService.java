package com.dubbo.provider.service;

import com.dubbo.provider.Entity.User;
import com.dubbo.provider.dao.TestDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Create by  ASUS on 2019/9/18.
 * description:
 */
@Component
public class UserService {
    
    @Autowired
    TestDao dao;
    
    public int updateUser(String name){
       int resp= dao.updateUser(getUser());
       return resp;
    }
    
    private User getUser() {
        User user = new User();
        user.setId("20140554");
        user.setAge(18);
        user.setName("周杰");
        return user;
    }
    
    
}
