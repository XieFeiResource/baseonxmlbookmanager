package com.BMSX.test;

import java.rmi.RemoteException;

import com.bm.shuju.Thenewmeg;
import com.bm.shuju.ThenewmegProxy;

public class Test {
	public void tongbumeg(com.bm.model.bean.Book b){
		ThenewmegProxy tp=new ThenewmegProxy();
		Thenewmeg tw=tp.getThenewmeg();
		try {
			tw.addbookmeg(b);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
