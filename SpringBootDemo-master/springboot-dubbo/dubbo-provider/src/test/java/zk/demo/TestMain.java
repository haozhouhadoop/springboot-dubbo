package zk.demo;

import com.alibaba.fastjson.JSONObject;
import com.dubbo.provider.Entity.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by  ASUS on 2019/9/17.
 * description:
 */
public class TestMain {
    
    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        list.add(new B("周浩"));
        list.add(new B("zzh"));
        listen(list);
        
    }
    
    public static <T extends Student> T say(T t) {
        t.setAge(15);
        t.setName("周浩");
        return t;
    }
    
    public static void listen(List<? extends A> list){
        list.forEach(e-> e.say());
    }
}

interface A<T>{
   void say();
}

class B<T> implements A<T>{
    
    T name;
    public B(T name){
        this.name = name;
    }
    @Override
    public void say() {
        System.out.println(name);
    }
}
