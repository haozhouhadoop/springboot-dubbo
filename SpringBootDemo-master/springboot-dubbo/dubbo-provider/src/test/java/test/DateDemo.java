package test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Create by  ASUS on 2019/9/17.
 * description:
 */
public class DateDemo {
    
   
    public static String say(){
        try{
            return "hello";
        } finally {
            System.out.println("执行到了");
        }
    }
    
    public static void main(String[] args) throws ParseException {
        System.out.println(say());
       
//        System.out.println(d.toString());
        
        /**
         * SimpleDateFormat用来格式化日期部分，可以将日期格式化为指定的格式
         * 可以将字符串按指定的格式变为日期
         *
         * format将日期格式化
         * parse将字符串解析为日期
         *
         * Calendar设置固定年月日，set（Calendar.Year） get(Calendar.Year)
         *
         * Calendar为抽象类，获取实例Calendar.getInstance返回一个继承实例
         *
         */
        
      
        
        /**
         *
         */
       
    }
}
