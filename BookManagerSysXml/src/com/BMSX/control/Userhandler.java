package com.BMSX.control;

import com.BMSX.model.dao.BaseDaoImpl;
import com.BMSX.model.dao.UserDao;
import com.BMSX.model.dao.UserDaoImpl;
import com.BMSX.modelbean.User;

public class Userhandler {
	private UserDao b;
	public Userhandler() {
		b=new UserDaoImpl();
	}
	
	public Boolean userlogin(String name) {
		User loginuser=b.searchone(name);
		System.out.println(loginuser);
		if(loginuser.getname()!=null) {
			return true;
		}
		return false;
	}
	
	public Boolean userRegister(User o) {
		Boolean flag=b.add(o);
		if(flag) {
			return true;
		}
		return false;
	}
}
