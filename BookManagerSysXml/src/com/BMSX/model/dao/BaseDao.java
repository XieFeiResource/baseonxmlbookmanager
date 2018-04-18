package com.BMSX.model.dao;

public interface BaseDao {
	String driverClassName="com.mysql.jdbc.Driver";
	String url="jdbc:mysql:///bookmanage?useUnicode=true&characterEncoding=UTF-8";
	String username="root";
	String password="123";
	
	public Boolean add(Object o);
	public Boolean delete(Object o);
	public Boolean update(Object o);
	public Object list();
}
