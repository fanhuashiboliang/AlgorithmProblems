package com.atguigu.java1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author denghp
 * @create 2022-02-05 19:28
 */
public class PropertiesTest {
    //Properties:常用来处理配置文件。key和value都是String类型
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();
            fis = new FileInputStream("JavaEE/jdbc.properties");
            pros.load(fis);
            String name = pros.getProperty("name");
            String password = pros.getProperty("password");
            System.out.println(name+"=========="+password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
