package com.hsbc.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hsbc.exception.PizzaAlreadyExitsException;
import com.hsbc.exception.PizzaNotFoundException;
import com.hsbc.model.Pizza;

public class PizzaListStoreImpl implements PizzaStore{
	private static List<Pizza> list=new ArrayList<>();	//stores obj in form of list
	@Override
	public boolean addNewPizza(Pizza[] pizza) throws PizzaAlreadyExitsException {	//adds pizza in list
		boolean isAdded=false;
		for(Pizza p:pizza) {
			list.add(p);
			isAdded=true;
		}
		return isAdded;
	}

	@Override
	public Pizza getPizzaByName(String pizzaName) throws PizzaNotFoundException {
		for(Pizza p:list) {
			if(p!=null && pizzaName.equalsIgnoreCase(p.getPizzaName())) {
				return p;
			}
		}
		throw new PizzaNotFoundException();
	}

	@Override
	public Pizza updatePizza(String pizzaName, Pizza pizza) {
		int cnt=-1;
		Pizza pizzaUpdated=new Pizza();
		Iterator<Pizza> itr=list.iterator();
		while(itr.hasNext()) {
			Pizza p=itr.next();
			cnt++;
			if(p!=null && p.getPizzaName().equalsIgnoreCase(pizzaName)) {
				list.set(cnt,pizza);
				pizzaUpdated=pizza;
			}
		}
		return pizzaUpdated;
	}

	@Override
	public boolean deletePizza(String pizzaName) {
		Iterator<Pizza> itr=list.iterator();
		Pizza result=null;
		while(itr.hasNext()) {
			Pizza pizza=itr.next();
			if(pizza!=null && pizza.getPizzaName().equalsIgnoreCase(pizzaName)) {
				result=pizza;
				break;
			}
		}
		return list.remove(result);
	}

	@Override
	public Pizza[] getPizzaByCountBySize(int size) {
		int i=0;
		Iterator<Pizza> itr=list.iterator();
		Pizza result[]=new Pizza[10];
		while(itr.hasNext()) {
			Pizza pizza=itr.next();
			if(pizza!=null && pizza.getSizeIncms()==size) {
				result[i]=pizza;
				i++;
			}
		}
		return result;
	}

}
