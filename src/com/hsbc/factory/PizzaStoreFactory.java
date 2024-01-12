package com.hsbc.factory;

import com.hsbc.dao.PizzaListStoreImpl;
import com.hsbc.dao.PizzaMapStorelmpl;
import com.hsbc.dao.PizzaSortedStorelmpl;
import com.hsbc.dao.PizzaStore;
import com.hsbc.dao.PizzaStoreFileImpl;
import com.hsbc.dao.PizzaStoreImpl;

public class PizzaStoreFactory {
	public static PizzaStore getPizzaStorage(int ch) {	//returns obj based on choice
		PizzaStore dao=null;
		if(ch==1) {
			dao=new PizzaStoreImpl();
		}
		else if(ch==2) {
			dao=new PizzaListStoreImpl();
		}
		else if(ch==3) {
			dao=new PizzaSortedStorelmpl();
		}
		else {								//if any other choice
			dao=new PizzaMapStorelmpl();
		}
		return dao;
	}
}
