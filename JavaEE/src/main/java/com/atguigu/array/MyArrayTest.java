package com.atguigu.array;

import org.junit.Test;

/**
 * @author denghp
 * @create 2022-03-27 17:43
 */
public class MyArrayTest {

    @Test
    public void test1(){
        MyArray myArray = new MyArray();
        for (int i = 0; i < 10; i++) {
            if(i%2 == 0){
                myArray.addLast(i);
            }
        }
        System.out.println(myArray.toString());

        myArray.add(1,111);
        myArray.addFirst(999);
        myArray.addLast(888);
        System.out.println(myArray.toString());

        myArray.remove(1);
        System.out.println(myArray.toString());
        myArray.removeFirst();
        System.out.println(myArray.toString());
        myArray.removeLast();
        System.out.println(myArray.toString());
    }

}
