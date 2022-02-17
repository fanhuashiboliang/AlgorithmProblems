package com.atguigu.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的使用
 *
 * 1、File类的一个对象，代表一个文件或者一个文件目录（俗称：文件夹）
 * 2、File类声明的java.io包下
 * 3、File类中涉及到关于文件或者文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 *      并未涉及到写入或读取文件内容的操作，如果需要读取或写入文件内容，必须使用IO流来完成。
 * 4、后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的"终点"
 *
 * @author denghp
 * @create 2022-02-10 20:28
 */
public class FileTest {
    /*
    1、如何创建File类的实例
        new File(String filePath)
        new File(String parentPath, String childPath)
        new File(File parentFile, String childPath)

    2、相对路径：
       绝对路径：

    3、路径分隔符
        windows:\\
        unix:/

     */
    @Test
    public void test1(){
        //构造器1：
        File file1 = new File("hello.txt");//相对于当前module
        File file2 = new File("E:\\projects\\JavaEE\\he.txt");

        System.out.println(file1);
        System.out.println(file2);

        //构造器2：
        File file3 = new File("E:\\projects\\JavaEE\\", "JavaSenior");
        System.out.println(file3);

        //构造器3：
        File file4 = new File(file3, "hi.txt");
        System.out.println(file4);

    }

    @Test
    public void test2(){
        File file1 = new File("hello.txt");//相对于当前module
        File file2 = new File("E:\\projects\\JavaEE\\he.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());

    }

    @Test
    public void test3(){
        File file = new File("E:\\projects");

        String[] strings = file.list();

        for(String s : strings){
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for(File fil : files){
            System.out.println(fil.toString());
        }
    }

    /*
    public boolean renameTo(File dest):把文件重命名为指定的文件路径
    比如：file1.renameTo(file2)为例：
        要想保证返回true，需要file1在硬盘中是存在的，切file2不能在硬盘中存在
     */

    @Test
    public void test4(){
        File file1 = new File("hello.txt");
        File file2 = new File("1.txt");

        boolean renameTo = file2.renameTo(file1);
        System.out.println(renameTo);
    }

    @Test
    public void test5(){
        File file1 = new File("hello.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
        System.out.println(file1.exists());

        System.out.println();

        File file2 = new File("E:\\projects\\JavaEE");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
        System.out.println(file2.exists());
    }

    @Test
    public void test6() throws IOException {
        File file1 = new File("hi.txt");
        if(!file1.exists()){
            file1.createNewFile();//文件的创建
        }else {
            file1.delete();//文件的删除
        }
    }

    @Test
    public void test7(){
        //文件目录的创建
        File file1 = new File("E:\\projects\\JavaEE\\a\\io1");
        System.out.println(file1.mkdirs());//如果前面的目录不存在，则创建该目录

        File file2 = new File("E:\\projects\\JavaEE\\b\\io1");
        System.out.println(file2.mkdir());//如果前面的目录不存在，什么都不创建
    }

}
