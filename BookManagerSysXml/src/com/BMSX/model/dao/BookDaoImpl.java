package com.BMSX.model.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.BMSX.modelbean.Book;

public class BookDaoImpl extends BaseDaoImpl implements BookDao {

	@Override
	public Boolean add(Object o) {//添加图书
		Book u=(Book) o;
		try{ DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.parse(new File("图书列表.xml"));
        Element root=document.getDocumentElement();
        root.appendChild(document.createElement("图书"));//为根节点添加价格标记。

       NodeList nodeList=document.getElementsByTagName("图书");//获得用户节点集合
       int  size=nodeList.getLength();
                Node node=nodeList.item(size-1);
                if(node.getNodeType()==Node.ELEMENT_NODE){
                   Element elementNode=(Element)node;
                   elementNode.setAttribute("id",u.getBno());
                   Element name=document.createElement("名称");
                   name.appendChild(document.createTextNode(u.getBname()));
                   Element price=document.createElement("价格");
                   price.appendChild(document.createTextNode(u.getBprice()));
                   Element account=document.createElement("库存");
                   account.appendChild(document.createTextNode(u.getBaccount()));
                   Element imagepath=document.createElement("图片路径");
                   imagepath.appendChild(document.createTextNode(u.getBimagepath()));
                   Element author=document.createElement("作者");
                   author.appendChild(document.createTextNode(u.getBauthor()));
                   Element des=document.createElement("描述");
                   des.appendChild(document.createTextNode(u.getBdes()));
                   elementNode.appendChild(name); 
                   elementNode.appendChild(price); 
                   elementNode.appendChild(account); 
                   elementNode.appendChild(imagepath); 
                   elementNode.appendChild(author); 
                   elementNode.appendChild(des); 
            }  
      TransformerFactory transFactory=TransformerFactory.newInstance();
      Transformer transformer=transFactory.newTransformer();
      DOMSource domSource=new DOMSource(document); 
      File file=new File("图书列表.xml");
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
	public Boolean delete(Object o) {//删除一本图书
		Book u=(Book) o;
		try{ 
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.parse(new File("图书列表.xml"));
        Element root=document.getDocumentElement();

        NodeList nodeList=document.getElementsByTagName("图书");//获得出厂日期节点集合
      int size=nodeList.getLength();
      for(int k=0;k<size;k++){
                Node node=nodeList.item(k);
                if(node.getNodeType()==Node.ELEMENT_NODE){
                	Element elementNode=(Element)node;
                    String str=elementNode.getFirstChild().getTextContent();
                    if(str.equals(u.getBname())){
                    	System.out.println(str);
                    	root.removeChild(node);
                      }
                }
            }

      TransformerFactory transFactory=TransformerFactory.newInstance();
      Transformer transformer=transFactory.newTransformer();
      DOMSource domSource=new DOMSource(document); 
      File file=new File("图书列表.xml");
      FileOutputStream out=new FileOutputStream(file);
      StreamResult xmlResult=new StreamResult(out);
      transformer.transform(domSource,xmlResult);
                }
 catch(Exception e){
      System.out.println(e);
   }
		return true;
	}

	@Override
	public Boolean update(Object o) {
		Book u=(Book) o;
		List<Book> books=(List<Book>) searchone(u.getBname());
		 try{
			 DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder=factory.newDocumentBuilder();
	            Document document=builder.parse(new File("图书列表.xml"));
	            Element root=document.getDocumentElement();

	            NodeList nodeList=root.getElementsByTagName("图书");//获得书名的节点集合
	            int size=nodeList.getLength();
             for(int k=0;k<size;k++){
            	 Node node=nodeList.item(k);
            	 Element elementNode=(Element)node;
            	 if(elementNode.getFirstChild().getTextContent().equals(books.get(0).getBname())) {
            		 NodeList nodes=node.getChildNodes();
                    	nodes.item(0).setTextContent(u.getBname());;
                    	nodes.item(1).setTextContent(u.getBprice());
                    	nodes.item(2).setTextContent(u.getBaccount());
                    	nodes.item(3).setTextContent(u.getBimagepath());
                    	nodes.item(4).setTextContent(u.getBauthor());
                    	nodes.item(5).setTextContent(u.getBdes());
            	 }
                 }   

           TransformerFactory transFactory=TransformerFactory.newInstance();
           Transformer transformer=transFactory.newTransformer();
           DOMSource domSource=new DOMSource(document); 
           File file=new File("图书列表.xml");
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
	
	public Object searchone(String name) {
		Book u=new Book();
		List<Book> list = new ArrayList<Book>();
		 try{
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document document=builder.parse(new File("图书列表.xml"));
            Element root=document.getDocumentElement();

            NodeList nodeList=root.getElementsByTagName("图书");//获得书名的节点集合
            int size=nodeList.getLength();
            for(int k=0;k<size;k++){
                    Node node=nodeList.item(k);
                    NodeList nodes=node.getChildNodes();
                    	String bname=nodes.item(0).getTextContent();
                    	String bprice=nodes.item(1).getTextContent();
                    	String baccount=nodes.item(2).getTextContent();
                    	String bimagepath=nodes.item(3).getTextContent();
                    	String bauthor=nodes.item(4).getTextContent();
                    	String bdes=nodes.item(5).getTextContent();
                    if(bname.equals(name)){
                    	u.setBname(bname);
                    	u.setBprice(bprice);
                    	u.setBaccount(baccount);
                    	u.setBimagepath(bimagepath);
                    	u.setBauthor(bauthor);
                    	u.setBdes(bdes);
                    	list.add(u);
                       }
                    }

          TransformerFactory transFactory=TransformerFactory.newInstance();
          Transformer transformer=transFactory.newTransformer();
          DOMSource domSource=new DOMSource(document); 
          File file=new File("图书列表.xml");
          FileOutputStream out=new FileOutputStream(file);
          StreamResult xmlResult=new StreamResult(out);
          transformer.transform(domSource,xmlResult);
                    }
     catch(Exception e){
          System.out.println(e);
       }
		return list;
	}
	
	@Override
	public Object list() {//列出所有商品
		List<Book> list = new ArrayList<Book>();
		 try{
           DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
           DocumentBuilder builder=factory.newDocumentBuilder();
           Document document=builder.parse(new File("图书列表.xml"));
           Element root=document.getDocumentElement();

           NodeList nodeList=root.getElementsByTagName("图书");//获得书名的节点集合
           int size=nodeList.getLength();
           for(int k=0;k<size;k++){
                   Node node=nodeList.item(k);
                   NodeList nodes=node.getChildNodes();
                   	String bname=nodes.item(0).getTextContent();
                   	String bprice=nodes.item(1).getTextContent();
                   	String baccount=nodes.item(2).getTextContent();
                   	String bimagepath=nodes.item(3).getTextContent();
                   	String bauthor=nodes.item(4).getTextContent();
                   	String bdes=nodes.item(5).getTextContent();
                   	Book u=new Book();
                   	u.setBname(bname);
                   	u.setBprice(bprice);
                   	u.setBaccount(baccount);
                   	u.setBimagepath(bimagepath);
                   	u.setBauthor(bauthor);
                   	u.setBdes(bdes);
                   	list.add(u);
           }
		 }
           catch(Exception e){
               System.out.println(e);
            }
		return list;
	}

	// 为table中的二维数组赋值
		public Object[][] Createdata(List<Book> list) {
			Object[][] data = new Object[list.size()][6];
			for (int i = 0; i < list.size(); i++) {
				data[i][0] = list.get(i).getBname();
				data[i][1] = list.get(i).getBauthor();
				data[i][2] = list.get(i).getBprice();
				data[i][3] = list.get(i).getBaccount();
				data[i][4] = list.get(i).getBimagepath();
				data[i][5] = list.get(i).getBdes();
			}
			return data;
		}
		
}
