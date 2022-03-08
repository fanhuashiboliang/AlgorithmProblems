package com.icbc.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author denghp
 * @create 2022-03-08 7:39
 */
public class Dom4jTest {

    @Test
    public void test1(){
        //创建一个SaxReader输入流，去读取xml配置文件，生成Document对象
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read("src/books.xml");
            System.out.println(doc);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取books.xml文件生成book类
     */

    @Test
    public void test2() throws Exception{
        //1.读取books.xml文件
        SAXReader reader = new SAXReader();
        //2.通过Document对象获取根元素
        Document read =  reader.read("src/books.xml");
        Element rootElement = read.getRootElement();
        //System.out.println(rootElement);
        //3.通过根元素获取book标签对象
        List<Element> books = rootElement.elements();
        //4.遍历，处理每个book标签转换为Book类
        for (Element book: books) {
            Element name = book.element("name");
            //System.out.println(name.asXML());
            String nameText = name.getText();
            //System.out.println(nameText);
            String priceText = book.elementText("price");
            //System.out.println(priceText);
            String authorText = book.elementText("author");

            String snValue = book.attributeValue("sn");

            System.out.println(new Book(snValue,nameText,new BigDecimal(priceText),authorText));
        }

    }

}
