package com.BMSX.control;

import java.io.FileOutputStream;  
import java.io.FileWriter;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;  
  
import org.dom4j.Document;  
import org.dom4j.DocumentHelper;  
import org.dom4j.Element;  
import org.dom4j.io.OutputFormat;  
import org.dom4j.io.XMLWriter;

import com.BMSX.model.dao.BaseDaoImpl;
import com.BMSX.model.dao.BookDaoImpl;  
  
  
public class DBToXmlService extends BaseDaoImpl{ 
    //导出xml文件  
    public void exportDataToXMlFile(String dbName,String tableName) throws Exception {  
        //创建文档并设置根元素userinfo  
                Element root=DocumentHelper.createElement("图书列表");  
                Document document=DocumentHelper.createDocument(root);  
                //访问数据库并将数据库信息封装进创建的xml文档中  
                accessDB(document, root,dbName,tableName);  
                //指定文档输出格式  
                OutputFormat format=new OutputFormat("   ", true);  
                //定义输出流，输出文档，限于内存中,表现为在控制台输出  
                XMLWriter xmlWriter=new XMLWriter(format);  
                xmlWriter.write(document);  
                //获取当前时间  
                SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");  
                String time = sf.format(new Date());  
                //把文档输出到存储设备，硬盘：第一种方式  
                String fileName ="图书列表.xml";  
                XMLWriter xmlWriter2=new XMLWriter(new FileOutputStream(fileName),format);  
                xmlWriter2.write(document);  
                //把文档输出到存储设备，硬盘：第二种方式  
                XMLWriter xmlWriter3=new XMLWriter(new FileWriter(fileName), format);  
                xmlWriter3.write(document);  
                //必须进行刷新和关闭，否则写入内容为空  
                xmlWriter3.flush();  
    }  
      
    //定义静态函数访问数据库  
    public static void accessDB(Document doc,Element root,String dbName,String tableName) {  
        try {  
            //数据库连接字符串  
            String url="jdbc:mysql://localhost:3306/"+dbName;  
            //连接数据库执行查询  
            Class.forName(driverClassName);
			Connection conn=DriverManager.getConnection(url, username, password);
            Statement statement=conn.createStatement();  
            //获得数据库结果集  
            ResultSet rs=statement.executeQuery("select * from "+tableName);  
            //生成xml文档  
            createXml(doc, root, rs);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
    }  
    //定义静态函数创建xml文档  
    public static void createXml(Document doc,Element root,ResultSet rs) throws SQLException {  
        while (rs.next()) {  
            //生成与表名对应的元素节点并添加到根元素节点下  
            Element user=root.addElement("图书");  
            //添加子元素userid  
            Element bname=user.addElement("名称");  
            bname.setText(rs.getString("bname"));  
            //添加子元素username  
            Element bprice=user.addElement("价格");  
            bprice.setText(rs.getString("bprice"));  
            //添加子元素password  
            Element baccount=user.addElement("库存");  
            baccount.setText(rs.getString("baccount"));
            
            Element bimagepath=user.addElement("图片路径");  
            bimagepath.setText(rs.getString("bimagepath"));
            
            Element bauthor=user.addElement("作者");  
            bauthor.setText(rs.getString("bauthor")); 
            
            Element bdes=user.addElement("描述");  
            bdes.setText(rs.getString("bdes"));  
        }  
    }

	@Override
	public Boolean add(Object o) {
		// TODO Auto-generated method stub
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
