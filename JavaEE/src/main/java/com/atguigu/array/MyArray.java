package com.atguigu.array;

import java.util.Arrays;

/**
 * @author denghp
 * @create 2022-03-27 17:21
 */
public class MyArray<E> {

    E[] data;
    int size;

    public MyArray() {
        this(10);
    }

    public MyArray(int getCapacity) {
        this.data = (E[])new Object[getCapacity];
    }

    public int getSize(){
        return size;
    }

    public int getCapacity()
    {
        return data.length;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    public void add(int index, E e){
        if(size == data.length){
            throw new RuntimeException("数组满了，无法插入");
        }
        if(0>index || index>size){
            throw new RuntimeException("不在数组的有效边界范围内");
        }
        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E remove(int index){
        if(0>index || index>=size){
            throw new RuntimeException("不在数组的有效边界范围内");
        }
        E result = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        return result;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public E set(int index, E e){
        if(0>index || index>=size){
            throw new RuntimeException("不在数组的有效边界范围内");
        }
        return data[index] = e;
    }

    public E getValueByIndex(int index){
        if(0>index || index>=size){
            throw new RuntimeException("不在数组的有效边界范围内");
        }
        return data[index];
    }

    public int getIndexByValue(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public E[] getData() {
        return data;
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}
