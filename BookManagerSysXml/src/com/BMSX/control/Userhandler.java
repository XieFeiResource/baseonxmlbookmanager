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
	public static void main(String[] args) {
		Userhandler u=new Userhandler();
		User o=new User();
		o.setname("谢飞");
		o.setPassword("123456");
		u.b.update(o);
	}
}
