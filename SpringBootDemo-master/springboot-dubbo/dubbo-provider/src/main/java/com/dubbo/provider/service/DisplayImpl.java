package com.dubbo.provider.service;

import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.provider.Entity.Student;
import com.dubbo.service.Display;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Create by  ASUS on 2019/9/16.
 * description:
 */

@Service
@Component
public class DisplayImpl implements Display {
    
    private  Student  student = null;
    
    @Value("${kml.path}")
    private String kmlPath;
    
    @Override
    public String display() {
        student = new Student();
        student.setAge(18);
        student.setName("zhouhao");
        student.setSex("男");
        student.setClassRoom("土1403-1");
        ObjectMapper mapper = new ObjectMapper();
        String resultJson = null;
        try {
            resultJson = mapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        String txt=readTxt();
        return "student :"+resultJson+" txt:"+txt;
    }
    
    
    private String readTxt() {
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        String s;
        try {
            br =  new BufferedReader(new FileReader(kmlPath));
            while((s=br.readLine())!=null){
                sb.append(s);
            }
            return sb.toString();
    
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
    
}
