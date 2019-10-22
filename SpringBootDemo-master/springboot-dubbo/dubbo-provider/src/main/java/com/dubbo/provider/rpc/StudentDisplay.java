package com.dubbo.provider.rpc;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.provider.Entity.Student;
import com.dubbo.provider.service.StudentService;
import com.dubbo.service.Display;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.DataInput;

/**
 * Create by  ASUS on 2019/9/17.
 * description: dubbo的@service不会主动注入
 */
@Service
@Component
public class StudentDisplay<T> implements com.dubbo.service.Student {
    
    @Autowired
    private StudentService studentService;
    
    public String getuser(){
       return studentService.getAllUsers();
    }
    
    @Override
    public String display() {
        return getuser();
    }
    
    @Override
    public String getStudent(String id){
        return null;
    }
    
}
