package com.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.service.Display;
import com.dubbo.service.HelloService;
import com.dubbo.service.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
public class HelloController {

    
    
    @Reference  //发现服务
    private HelloService helloService;
    @Reference
    private Display display;
    @Reference
    private Student student;  //没有发现服务，只会实例化当前bean
    
    @RequestMapping(value = "/hello")
    public String hello() {
        String hello = helloService.sayHello("world");
        System.out.println(helloService.sayHello("BJQ"));
        return hello;
    }
    
    @RequestMapping("world")
    public String world(){
        return "zhouhao";
    }
    
    @RequestMapping("/student")
    public String studentInfo(){
        String display = this.display.display();
        return "学生信息为"+display;
    
    }
    
    @RequestMapping("/student/info{id}")
    public String getInfo(@PathVariable("id") String id){
        String info = student.getStudent(id);
        return info;
    }
    
    
    
    
}
