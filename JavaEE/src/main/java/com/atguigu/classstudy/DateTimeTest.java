package com.atguigu.classstudy;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * jdk 8 之前的日期时间的API测试
 * 1. System类中currentTimeMills();
 * 2. java.util.Date和子类java.sql.Date
 * 3. SimpleDateFormat
 * 4. Calendar
 *
 * @author denghp
 * @create 2022-01-17 22:07
 */
public class DateTimeTest {

    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作：
    1.1 格式化：日期--->字符串
    1.2 解析：格式化的逆过程，字符串--->日期

    2. SimpleDateFormat的实例化


     */

    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期--->字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串--->日期
        String str = "19-12-18 下午11:43";
        System.out.println(sdf.parse(str));

        //******************************按照指定的方式格式化和解析：调用带参的构造器************************************
        //SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MMMMM.dd GGG hh:mm:ss aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        System.out.println(sdf1.format(date));
        Date date1 = sdf1.parse("2022-01-17 10:21:09");
        System.out.println(date1);
    }


}
