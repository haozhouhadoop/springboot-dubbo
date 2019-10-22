package com.dubbo.provider.InitFaced;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.provider.Entity.Man;
import com.dubbo.provider.Entity.Student;
import com.dubbo.provider.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Create by  ASUS on 2019/9/16.
 * description:
 */
@Controller
@RestController(value="/login/")
public class StundentFaced {
    
    
    @Autowired
    private StudentService studentService;
    
    @RequestMapping(value="student/")
    public String requestStudent(){
       return studentService.getAllUsers();
    }
    
    @RequestMapping(value="student/id/{id}")
    public String getuser(@PathVariable("id") String id){
        return studentService.getUserById(id);
    }
    
    @RequestMapping(value="inset/{name}")
    public void insert(@PathVariable("name") String name){
        studentService.insert(name);
        
    }
    @RequestMapping(value="delete/{name}")
    public void delete(@PathVariable("name") String name){
        studentService.delete(name);
    }
    
    @RequestMapping(value="update/{id}")
    public void update(@PathVariable("id") String id){
        studentService.update(id);
    }
    
    @RequestMapping(value="select/{id}")
    public List<Map<String,Object>> select(@PathVariable("id") int id){
        return studentService.getMan(id);
    }
    
}
