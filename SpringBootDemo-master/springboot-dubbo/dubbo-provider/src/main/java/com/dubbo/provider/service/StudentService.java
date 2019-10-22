package com.dubbo.provider.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.dubbo.provider.Entity.Man;
import com.dubbo.provider.Entity.Student;
import com.dubbo.provider.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Create by  ASUS on 2019/9/16.
 * description:
 */
@Component
public class StudentService {
    
    @Autowired
    private UserDao userDao;
//
    public String getAllUsers(){
       return userDao.selectUser();
    }
    
    public List<Map<String,Object>> getMan(int id){
        return userDao.selectMan(id);
    }
    
    public String getUserById(String id){
        Student student= userDao.getUserById(id);
        String[] filters = {"name","uUID","sex"};
        return parseobject(student,Student.class,filters);
    }
    
    public void insert(String name){
        userDao.insert(getStudent(name));
    }
    
    public void delete(String name){
        userDao.UserDelete(deleteStudent(name));
    }
    
    public void update(String id){
        userDao.UserUpdate(updateStudent(id));
    }
    
    private Student updateStudent(String id) {
        
        Student student= new Student();
        student.setAge(12);
        student.setSex("f");
        student.setClassRoom("土2014-6");
        student.setUUID(id);
        return student;
    }
    
    private Student getStudent(String name){
        return Student(name);
    }
    private Student deleteStudent(String name){
        return Student(name);
    }
    
    private Student Student(String name) {
        Student student = new Student();
        student.setName(name);
        student.setClassRoom("土1403-5");
        student.setSex("nv");
        student.setAge(15);
        student.setUUID(UUID.randomUUID().toString().substring(0,15));
        return student;
    }
    
    private String parseobject(Object object,Class clazz,String... properties){
        String[] var = properties;
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(clazz,properties);
        String jsonString = JSON.toJSONString(object, filter);
        return jsonString;
    }
    
    @Test
    public void parseObject(){
        Student student = new Student();
        student.setUUID("12132");
        student.setClassRoom("土1403-1");
        student.setName("周浩");
        student.setAge(14);
        String jsonString = JSONObject.toJSONString(student);
        System.out.println(jsonString);
        String param = "{\"result\":{\"code\":1,\"msg\":\"success\",\"url\":\"\",\"data\":\"0\",\"date\":\"1530007139\"},\"data\":{\"token\":\"iamtoken\",\"life\":1530005620,\"expires\":7200}}";
        
        String param2 = "{\"hzw\":123,\"java\":[\"a\",\"b\"]}";
        JSONObject jsonObject = JSON.parseObject(param2);
        System.out.println(JSONObject.parseObject(param2).getJSONArray("java").get(1));
//        System.out.println(JSONObject.parseObject(param).getJSONObject("data").get("token"));
        
        String[] filters = {"name","classRoom","age","uUID"};
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Student.class,filters);
        String jsonStr = JSON.toJSONString(student,filter);
        System.out.println(jsonStr);
    }
    
    
}
