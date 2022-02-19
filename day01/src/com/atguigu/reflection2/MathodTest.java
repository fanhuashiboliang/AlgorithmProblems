package com.atguigu.reflection2;

import com.atguigu.reflection1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
 *
 * @author denghp
 * @create 2022-02-19 20:55
 */
public class MathodTest {

    @Test
    public void test1(){

        Class<Person> clazz = Person.class;

        //getMethods()：获取当前运行时类及其
        Method[] methods = clazz.getMethods();
        for (Method m : methods){
            System.out.println(m);
        }

        System.out.println();

        //getDeclaredMethods()：获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods){
            System.out.println(m);
        }

    }

    /*
    @Xxxx
    权限修饰符  返回值类型  方法名(参数类型1 形参名1,...) throws XxxException{}
     */
    @Test
    public void test2(){

        //1.获取方法声明的注解
        Class<Person> clazz = Person.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods){
            //1.获取方法声明中的注解
            Annotation[] annos = m.getAnnotations();
            for (Annotation anno : annos){
                System.out.println(anno);
            }

            //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers())+"\t");

            //3.返回值类型
            System.out.print(m.getReturnType().getName()+"\t");

            //4.方法名
            System.out.print(m.getName());
            System.out.print("(");

            //5.形参列表
            Class<?>[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes == null && parameterTypes.length == 0)){
                for(int i = 0; i<parameterTypes.length;i++){
                    if(i == parameterTypes.length-1){
                        System.out.print(parameterTypes[i].getName() + "args_" + i);
                        break;
                    }

                    System.out.print(parameterTypes[i].getName() + "args_" + i);
                }
            }
            System.out.print(")");

            //6.抛出的异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if(exceptionTypes.length > 0){
                System.out.print("throws ");
                for (int i = 0; i<exceptionTypes.length; i++){
                    if(i == exceptionTypes.length-1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }

                    System.out.print(exceptionTypes[i].getName()+",");
                }
            }

            System.out.println();
        }


    }

}
