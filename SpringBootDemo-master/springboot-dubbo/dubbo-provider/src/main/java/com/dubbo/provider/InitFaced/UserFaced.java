package com.dubbo.provider.InitFaced;

import com.dubbo.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by  ASUS on 2019/9/18.
 * description:
 */
@Component
@RestController
public class UserFaced {
    
    @Autowired
    UserService userService;
    
    @RequestMapping(value="/updateu/{name}")
    public int updateUser(@PathVariable("name") String name){
        return userService.updateUser(name);
    }
}
