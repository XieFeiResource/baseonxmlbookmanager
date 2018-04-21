package com.BMSX.control;

import java.io.File;  
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.util.List;  
  
import org.dom4j.Document;  
import org.dom4j.Element;  
import org.dom4j.io.SAXReader;

import com.BMSX.model.dao.BookDaoImpl;
import com.BMSX.modelbean.Book;

public class Bookhandler {
	private BookDaoImpl bk;
	public Bookhandler() {
		bk=new BookDaoImpl();
	}
	public Boolean addbook(Book o) {
		Boolean flag=bk.add(o);
		if(flag) {
			return true;
		}
		return false;
	}
	public Boolean modifybook(Book o) {
		Boolean flag=bk.update(o);
		if(flag) {
			return true;
		}
		return false;
	}

	 public void importDataIntoDB() throws Exception{  
	        //sql  
	        String sql="insert into book (bname,bprice,baccount,bimagepath,bauthor,bdes) values(?,?,?,?,?,?)";  
	        //调用工具包里的数据库连接方法  
	        Connection connection = bk.getConn(); 
	        //执行sql  
	        PreparedStatement presta=connection.prepareStatement(sql);  
	        //定义解析器  
	        SAXReader reader=new SAXReader();  
	        //获取文档对象  
	       Document document=reader.read(new File("图书列表.xml"));  
	        //获取根元素  
	       Element root=document.getRootElement();  
	     //获取根元素下的用户集合  
	        List userList=root.elements();  
	        //双重循环遍历每一个用户下的子元素信息  
	        for (int i = 0; i < userList.size(); i++) {  
	            Element userElement=(Element)userList.get(i);  
	            List itemList=userElement.elements();
	            //遍历每个用户的子元素信息  
	            for (int j = 0; j< itemList.size(); j++) {
	                Element element=(Element)itemList.get(j);  
	                //获取子元素信息进行参数设置  
	                presta.setString(j+1, element.getText());  
	            }  
	            //批量更新  
	            presta.addBatch();  
	            presta.executeBatch();  
	        }  
	    }  
}
