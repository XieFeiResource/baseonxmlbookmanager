package com.BMSX.model.dao;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

import com.BMSX.modelbean.User;

import javax.xml.parsers.*;
import java.io.*;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public Boolean add(Object o) {//添加用户
		User u=(User) o;
		try{ DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.parse(new File("用户列表.xml"));
        Element root=document.getDocumentElement();
        root.appendChild(document.createElement("用户"));//为根节点添加价格标记。

       NodeList nodeList=document.getElementsByTagName("用户");//获得用户节点集合
       int  size=nodeList.getLength();
                Node node=nodeList.item(size-1);
                if(node.getNodeType()==Node.ELEMENT_NODE){
                   Element elementNode=(Element)node;
                   Element name=document.createElement("姓名");
                   name.appendChild(document.createTextNode(u.getname()));
                   Element password=document.createElement("密码");
                   password.appendChild(document.createTextNode(u.getPassword()));
                   elementNode.appendChild(name); 
                   elementNode.appendChild(password); 
            }  
      TransformerFactory transFactory=TransformerFactory.newInstance();
      Transformer transformer=transFactory.newTransformer();
      DOMSource domSource=new DOMSource(document); 
      File file=new File("用户列表.xml");
      FileOutputStream out=new FileOutputStream(file);
      StreamResult xmlResult=new StreamResult(out);
      transformer.transform(domSource,xmlResult);
                }
 catch(Exception e){
      System.out.println(e);
      return false;
   }
		return true;
	}

	@Override
	public Boolean delete(Object o) {//删除用户
		User u=(User) o;
		try{ DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.parse(new File("用户列表.xml"));
        Element root=document.getDocumentElement();

        NodeList nodeList=document.getElementsByTagName("用户");//获得出厂日期节点集合
      int size=nodeList.getLength();
      for(int k=0;k<size;k++){
                Node node=nodeList.item(k);
                if(node.getNodeType()==Node.ELEMENT_NODE){
                	Element elementNode=(Element)node;
                    String str=elementNode.getTextContent();
                    System.out.println(str);
                    if(str.equals(u.getname()+u.getPassword())){
                    	root.removeChild(node);
                      }
                }
            }  //删除名称为出厂日期的节点

      TransformerFactory transFactory=TransformerFactory.newInstance();
      Transformer transformer=transFactory.newTransformer();
      DOMSource domSource=new DOMSource(document); 
      File file=new File("用户列表.xml");
      FileOutputStream out=new FileOutputStream(file);
      StreamResult xmlResult=new StreamResult(out);
      transformer.transform(domSource,xmlResult);
                }
 catch(Exception e){
      System.out.println(e);
   }
		return null;
	}

	@Override
	public Boolean update(Object o) {
		User u=(User) o;
		 try{
			 DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder=factory.newDocumentBuilder();
	            Document document=builder.parse(new File("用户列表.xml"));
	            Element root=document.getDocumentElement();

	            NodeList nodeList=root.getElementsByTagName("用户");//获得书名的节点集合
	            int size=nodeList.getLength();
             for(int k=0;k<size;k++){
            	 Node node=nodeList.item(k);
                 Node firstnode=node.getFirstChild();
                 Node lastnode=node.getLastChild();
                 String str=firstnode.getTextContent();
                 System.out.println(str);
                 if(str.equals("张三")){
                	 firstnode.setTextContent(u.getname());
                	 lastnode.setTextContent(u.getPassword());
                    }
                 }   

           TransformerFactory transFactory=TransformerFactory.newInstance();
           Transformer transformer=transFactory.newTransformer();
           DOMSource domSource=new DOMSource(document); 
           File file=new File("用户列表.xml");
           FileOutputStream out=new FileOutputStream(file);
           StreamResult xmlResult=new StreamResult(out);
           transformer.transform(domSource,xmlResult);
                     }
      catch(Exception e){
           System.out.println(e);
        }
		return null;
	}
	
	public User searchone(String name) {
		User u=new User();
		 try{
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document document=builder.parse(new File("用户列表.xml"));
            Element root=document.getDocumentElement();

            NodeList nodeList=root.getElementsByTagName("用户");//获得书名的节点集合
            int size=nodeList.getLength();
            for(int k=0;k<size;k++){
                    Node node=nodeList.item(k);
                    Node firstnode=node.getFirstChild();
                    Node lastnode=node.getLastChild();
                   String na=firstnode.getTextContent();
                   String pwd=lastnode.getTextContent();
                    String str=firstnode.getTextContent();
                    if(str.equals(name)){
                    	u.setname(na);
                    	u.setPassword(pwd);
                       }
                    }

          TransformerFactory transFactory=TransformerFactory.newInstance();
          Transformer transformer=transFactory.newTransformer();
          DOMSource domSource=new DOMSource(document); 
          File file=new File("用户列表.xml");
          FileOutputStream out=new FileOutputStream(file);
          StreamResult xmlResult=new StreamResult(out);
          transformer.transform(domSource,xmlResult);
                    }
     catch(Exception e){
          System.out.println(e);
       }
		return u;
	}
	
	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

}
