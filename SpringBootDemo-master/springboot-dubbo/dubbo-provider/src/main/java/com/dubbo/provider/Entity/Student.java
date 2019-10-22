package com.dubbo.provider.Entity;

import java.io.Serializable;

/**
 * Create by  ASUS on 2019/9/16.
 * description:
 */
public class Student implements Serializable {
    
    private String UUID ;
    private String name;
    private int age;
    private String sex;
    private String classRoom;
    
    public Student(){}
    public Student(String name, int age, String sex, String classRoom) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.classRoom = classRoom;
    }
    
    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
    
    public String getUUID() {
        return UUID;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getSex() {
        return sex;
    }
    
    public String getClassRoom() {
        return classRoom;
    }
    
    
}
