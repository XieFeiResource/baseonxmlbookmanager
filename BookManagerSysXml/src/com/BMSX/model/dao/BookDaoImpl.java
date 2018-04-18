package com.BMSX.model.dao;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class BookDaoImpl implements BookDao {

	@Override
	public Boolean add(Object o) {
		try{
            String train[]={"XML实践教程","JSP从入门到精通","Java实践教程"};
            String type[]={"978-7-302-15488-4","7-302-12591-0","978-7-302-14337-6"};
            String startTime[]={"王峰","刘海松","李章帅"};
            //创建XML文档中需要的数据
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document document=builder.newDocument();  //创建document节点对象
  
            document.setXmlVersion("1.0");//设置使用XML文件的版本
            Element root=document.createElement("图书列表");
            document.appendChild(root);//设置XML文件的根结点

            for(int k=1;k<=train.length;k++){
               root.appendChild(document.createElement("图书"));
            }  //在根节点下添加了三个节点

            NodeList nodeList=document.getElementsByTagName("图书");//获得图书的节点集合
            int size=nodeList.getLength();
            for(int k=0;k<size;k++){
               Node node=nodeList.item(k);
               if(node.getNodeType()==Node.ELEMENT_NODE)
                   {
                     Element elementNode=(Element)node;
                     elementNode.setAttribute("ISBN",type[k]);//为图书设置属性其取值从数组type中取。
                     elementNode.appendChild(document.createElement("名称"));//为图书添加一个名字标记
                     elementNode.appendChild(document.createElement("作者"));//为图书添加一个开车时间标记
                   }
                 }  

              nodeList=document.getElementsByTagName("名称");//获得名字的节点集合
              size=nodeList.getLength();
              for(int k=0;k<size;k++){
                 Node node=nodeList.item(k);
                 if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element elementNode=(Element)node;
                    elementNode.appendChild(document.createTextNode(train[k])); //为标记添加文本数据。
                 }
             }   

          nodeList=document.getElementsByTagName("作者");
          size=nodeList.getLength();
          for(int k=0;k<size;k++){
              Node node=nodeList.item(k);
              if(node.getNodeType()==Node.ELEMENT_NODE){
                 Element elementNode=(Element)node;
                 elementNode.appendChild(document.createTextNode(startTime[k]));  
               }
           }

      TransformerFactory transFactory=TransformerFactory.newInstance();//创建一个TransformerFactory（转换工厂对象）
       Transformer transformer=transFactory.newTransformer();//创建一个Transformer对像（文件转换对象）
       DOMSource domSource=new DOMSource(document); //把要转换的Document对象封装到一个DOMSource类中
       File file=new File("图书列表.xml");
       FileOutputStream out=new FileOutputStream(file);
       StreamResult xmlResult=new StreamResult(out);//将要变换得到XML文件将来保存在StreamResult
       transformer.transform(domSource,xmlResult);//把节点树转换为XML文件
         }
   catch(Exception e){
        System.out.println(e);
     }
		return null;
	}

	@Override
	public Boolean delete(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

}
