package gsh.utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

@Component
public class TestDate {

    public static void main(String[] args) throws ParseException {
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        System.out.println(new Date().getTime());// new Date()为获取当前系统时间
        System.out.println(new Date().toString());
        System.out.println(new Date().toInstant());

    }
}
