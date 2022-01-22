package com.atguigu.java;

/**
 * 注解的使用
 *
 * 1.理解Annotation:
 * ①jdk5.0新增功能
 *
 * ②Annotation 其实就是代码里的特殊标记，这些标记可以在编译、类加载、运行时被读取，并执行相应的处理，
 * 通过使用Annotation，程序员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息：代码分析工具、开发工具和部署工具
 * 可以通过这些补充信息进行验证或者进行部署。
 *
 * ③在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android中注解占据了更重要的角色，
 * 例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗代码和XML配置等。
 *
 *
 * 2.Annotation的使用示例
 * 示例一：生成文档相关的注解
 * 示例二：在编译时进行格式检查（JDK内置的三个基本注解）
     @Override:限定重写父类方法，该注解只能用于方法
     @Deprecated:用于表示所修饰的元素（类、方法等）已过时，通常是因为所修饰的结构危险或存在更好的选择
     @SuppressWarnings:抑制编译器警告
 * 示例三：跟踪代码依赖性，实现替代配制文件功能
 *
 * @author denghp
 * @create 2022-01-22 11:30
 *
 */
public class AnnotationTest {
}

class Person{
    private String name;
    private int age;
}
