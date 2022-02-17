package com.atguigu.io;

import org.junit.Test;

import java.io.*;

/**
 * @author denghp
 * @create 2022-02-14 21:03
 */
public class StreamTest {

    @Test
    public void test1()  {
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = new BufferedReader(new FileReader("hello.txt"));
            out = new BufferedWriter(new FileWriter("hello1.txt"));
            //in = new BufferedInputStream(new FileInputStream("hello.txt"));
            //out = new BufferedOutputStream(new FileOutputStream("hello1.txt"));

            //byte[] ins = new byte[5];
            /*int len;

            while ((len=in.read(ins)) != -1){
                System.out.print(new String(ins, 0, len));
            }*/
            String str;
            while ((str = in.readLine()) != null){
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
