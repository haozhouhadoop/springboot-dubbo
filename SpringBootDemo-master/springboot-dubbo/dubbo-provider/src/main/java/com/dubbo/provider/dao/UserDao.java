package com.dubbo.provider.dao;

import com.dubbo.provider.Entity.Man;
import com.dubbo.provider.Entity.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Create by  ASUS on 2019/9/16.
 * description:
 */
@Repository
public interface UserDao {
    void insert(Student student);
    
    void deleteByName(String name);
    
    List<Student> getAllUsers();
    
    void deleteAllUsers();
    
    String selectUser();
    
    Student getUserById(String id);
    
    void UserDelete(Student student);
    
//    @Update("UPDATE student set sex=#{sex},classroom=#{classRoom} WHERE id=#{UUID}")
    void UserUpdate(Student student);
    
    List<Map<String,Object>> selectMan(int id);
}

