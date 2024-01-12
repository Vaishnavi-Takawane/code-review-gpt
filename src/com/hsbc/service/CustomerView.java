package com.hsbc.service;

import com.hsbc.dao.PizzaStore;
import com.hsbc.exception.PizzaAlreadyExitsException;
import com.hsbc.exception.PizzaNotFoundException;
import com.hsbc.model.Pizza;

public class CustomerView implements CustomerViewInterface{	//service class that is called by UI layer
	public PizzaStore dao=null;	
	public PizzaStore getDao() {
		return dao;
	}

	public void setDao(PizzaStore dao) {
		this.dao = dao;
	}

	@Override
	public boolean AddPizzaDetailsandStore(Pizza pizza[])  throws PizzaAlreadyExitsException {
		return dao.addNewPizza(pizza);
	}

	@Override
	public Pizza displayPizzaDetailsbyName(String pizzaName) throws PizzaNotFoundException{ 
		return dao.getPizzaByName(pizzaName);
	}

	@Override
	public Pizza updatePizza(String pizzaName, Pizza pizza) {
		return dao.updatePizza(pizzaName, pizza);
	}

	@Override
	public boolean deletePizza(String pizzaName) {
		return dao.deletePizza(pizzaName);
	}

	@Override
	public Pizza[] getPizzaByCountBySize(int size) {
		return dao.getPizzaByCountBySize(size);
	}
	

}
