package com.BMSX.control;

import com.BMSX.model.dao.BaseDaoImpl;
import com.BMSX.model.dao.BookDao;
import com.BMSX.model.dao.BookDaoImpl;
import com.BMSX.modelbean.Book;

public class Bookhandler {
	private BookDao bk;
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

}
