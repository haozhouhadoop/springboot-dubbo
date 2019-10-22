package com.dubbo.provider.dao;

import com.dubbo.provider.Entity.User;
import org.springframework.stereotype.Repository;

/**
 * Create by  ASUS on 2019/9/18.
 * description:
 */
@Repository
public interface TestDao {
    
    int updateUser(User user);
}
