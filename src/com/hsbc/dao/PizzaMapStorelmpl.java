package com.hsbc.dao;

import java.util.HashMap;
import java.util.Map;

import com.hsbc.exception.PizzaAlreadyExitsException;
import com.hsbc.exception.PizzaNotFoundException;
import com.hsbc.model.Pizza;

public class PizzaMapStorelmpl implements PizzaStore {

	private static Map<String,Pizza> pizzaDetails=new HashMap<>();	//stores obj in map in form of key,value
	@Override
	public boolean addNewPizza(Pizza[] pizza) throws PizzaAlreadyExitsException {	//overrided methods
		boolean isAdded=false;
		for(int i=0;i<pizza.length;i++) {
			if(pizza[i]!=null) {
				pizzaDetails.put(pizza[i].getPizzaName(), pizza[i]);
				isAdded=true;
			}
		}
		return isAdded;
	}

	@Override
	public Pizza getPizzaByName(String pizzaName) throws PizzaNotFoundException {
		for(String s:pizzaDetails.keySet()) {
			if(pizzaDetails.get(s)!=null && pizzaDetails.get(s).getPizzaName().equalsIgnoreCase(pizzaName)) {
				return pizzaDetails.get(s);
			}
		}
		throw new PizzaNotFoundException();
	}

	@Override
	public Pizza updatePizza(String pizzaName, Pizza pizza) {
		if(pizzaDetails.get(pizzaName)!=null) {
			pizzaDetails.put(pizzaName, pizza);
		}
		return pizza;
	}

	@Override
	public boolean deletePizza(String pizzaName) {
		if(pizzaDetails.remove(pizzaName)==null){
			return true;
		}
		return false;
	}

	@Override
	public Pizza[] getPizzaByCountBySize(int size) {
		int cnt=0;
		Pizza res[]=new Pizza[10];
		for (Map.Entry<String, Pizza> entry : pizzaDetails.entrySet()) {
		    String key = entry.getKey();
		    Pizza value = entry.getValue();
		    if(value.getSizeIncms()==size) {
		    	res[cnt]=value;
		    	cnt++;
		    }
		}
		return res;
	}

}
