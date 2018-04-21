package com.BMSX.model.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class BaseDaoImpl implements BaseDao {
	private Connection conn;
	private PreparedStatement presta;
	private ResultSet rs;
	//连接数据库
	public Connection getConn() {
		try {
			Class.forName(driverClassName);
			conn=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	} 
	public void inituserxml() {
		try{
            String name[]={"张三"};
            String password[]={"123"};
            //创建XML文档中需要的数据
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document document=builder.newDocument();  //创建document节点对象
  
            document.setXmlVersion("1.0");//设置使用XML文件的版本
            Element root=document.createElement("用户列表");
            document.appendChild(root);//设置XML文件的根结点

            for(int k=1;k<=name.length;k++){
               root.appendChild(document.createElement("用户"));
            }  //在根节点下添加了三个节点

            NodeList nodeList=document.getElementsByTagName("用户");//获得图书的节点集合
            int size=nodeList.getLength();
            for(int k=0;k<size;k++){
               Node node=nodeList.item(k);
               if(node.getNodeType()==Node.ELEMENT_NODE)
                   {
                     Element elementNode=(Element)node;
                    // elementNode.setAttribute("ISBN",password[k]);//为图书设置属性其取值从数组type中取。
                     elementNode.appendChild(document.createElement("姓名"));//为图书添加一个名字标记
                     elementNode.appendChild(document.createElement("密码"));//为图书添加一个开车时间标记
                   }
                 }

              nodeList=document.getElementsByTagName("姓名");//获得名字的节点集合
              size=nodeList.getLength();
              for(int k=0;k<size;k++){
                 Node node=nodeList.item(k);
                 if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element elementNode=(Element)node;
                    elementNode.appendChild(document.createTextNode(name[k])); //为标记添加文本数据。
                 }
             }   

          nodeList=document.getElementsByTagName("密码");
          size=nodeList.getLength();
          for(int k=0;k<size;k++){
              Node node=nodeList.item(k);
              if(node.getNodeType()==Node.ELEMENT_NODE){
                 Element elementNode=(Element)node;
                 elementNode.appendChild(document.createTextNode(password[k]));  
               }
           }

      TransformerFactory transFactory=TransformerFactory.newInstance();//创建一个TransformerFactory（转换工厂对象）
       Transformer transformer=transFactory.newTransformer();//创建一个Transformer对像（文件转换对象）
       DOMSource domSource=new DOMSource(document); //把要转换的Document对象封装到一个DOMSource类中
       File file=new File("用户列表.xml");
       FileOutputStream out=new FileOutputStream(file);
       StreamResult xmlResult=new StreamResult(out);//将要变换得到XML文件将来保存在StreamResult
       transformer.transform(domSource,xmlResult);//把节点树转换为XML文件
       
         }
   catch(Exception e){
        System.out.println(e);
     }
	}
	
	public void initbookxml() {
		try{
		String name[]={"XML实践教程","JSP从入门到精通"};
        String type[]={"1","2"};
        String author[]={"王峰","刘海松"};
        String price[]={"20","30"};
        String account[]={"10","20"};
        String imagepath[]={"resource/images/user.png","resource/images/key.png"};
        String des[]={"XML实践教程","JSP从入门到精通"};
        //创建XML文档中需要的数据
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.newDocument();  //创建document节点对象

        document.setXmlVersion("1.0");//设置使用XML文件的版本
        Element root=document.createElement("图书列表");
        document.appendChild(root);//设置XML文件的根结点

        for(int k=1;k<=name.length;k++){
           root.appendChild(document.createElement("图书"));
        }  //在根节点下添加了三个节点

        NodeList nodeList=document.getElementsByTagName("图书");//获得图书的节点集合
        int size=nodeList.getLength();
        for(int k=0;k<size;k++){
           Node node=nodeList.item(k);
           if(node.getNodeType()==Node.ELEMENT_NODE)
               {
                 Element elementNode=(Element)node;
                 elementNode.setAttribute("id",type[k]);//为图书设置属性其取值从数组type中取。
                 elementNode.appendChild(document.createElement("名称"));//为图书添加一个名字标记
                 elementNode.appendChild(document.createElement("价格"));//为图书添加一个开车时间标记
                 elementNode.appendChild(document.createElement("库存"));//为图书添加一个开车时间标记
                 elementNode.appendChild(document.createElement("图片路径"));//为图书添加一个开车时间标记
                 elementNode.appendChild(document.createElement("作者"));//为图书添加一个开车时间标记
                 elementNode.appendChild(document.createElement("描述"));//为图书添加一个开车时间标记
               }
             }  

          nodeList=document.getElementsByTagName("名称");//获得名字的节点集合
          size=nodeList.getLength();
          for(int k=0;k<size;k++){
             Node node=nodeList.item(k);
             if(node.getNodeType()==Node.ELEMENT_NODE){
                Element elementNode=(Element)node;
                elementNode.appendChild(document.createTextNode(name[k])); //为标记添加文本数据。
             }
         }   

          nodeList=document.getElementsByTagName("作者");
          size=nodeList.getLength();
          for(int k=0;k<size;k++){
        	  Node node=nodeList.item(k);
        	  if(node.getNodeType()==Node.ELEMENT_NODE){
        		  Element elementNode=(Element)node;
        		  elementNode.appendChild(document.createTextNode(author[k]));  
        	  }
          }
          nodeList=document.getElementsByTagName("价格");
          size=nodeList.getLength();
          for(int k=0;k<size;k++){
        	  Node node=nodeList.item(k);
        	  if(node.getNodeType()==Node.ELEMENT_NODE){
        		  Element elementNode=(Element)node;
        		  elementNode.appendChild(document.createTextNode(price[k]));  
        	  }
          }
          nodeList=document.getElementsByTagName("库存");
          size=nodeList.getLength();
          for(int k=0;k<size;k++){
        	  Node node=nodeList.item(k);
        	  if(node.getNodeType()==Node.ELEMENT_NODE){
        		  Element elementNode=(Element)node;
        		  elementNode.appendChild(document.createTextNode(account[k]));  
        	  }
          }
          nodeList=document.getElementsByTagName("图片路径");
          size=nodeList.getLength();
          for(int k=0;k<size;k++){
        	  Node node=nodeList.item(k);
        	  if(node.getNodeType()==Node.ELEMENT_NODE){
        		  Element elementNode=(Element)node;
        		  elementNode.appendChild(document.createTextNode(imagepath[k]));  
        	  }
          }
      nodeList=document.getElementsByTagName("描述");
      size=nodeList.getLength();
      for(int k=0;k<size;k++){
          Node node=nodeList.item(k);
          if(node.getNodeType()==Node.ELEMENT_NODE){
             Element elementNode=(Element)node;
             elementNode.appendChild(document.createTextNode(des[k]));  
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
	}
	//释放连接
	public void release(Connection conn,PreparedStatement presta,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(presta!=null) {
			try {
				presta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
