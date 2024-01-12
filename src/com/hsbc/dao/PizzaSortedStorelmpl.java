package com.hsbc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.hsbc.exception.PizzaAlreadyExitsException;
import com.hsbc.exception.PizzaNotFoundException;
import com.hsbc.model.Pizza;

public class PizzaSortedStorelmpl implements PizzaStore {

	private static Set<Pizza> pizza=new TreeSet<>();	//adds pizza in treeset
	@Override
	public boolean addNewPizza(Pizza[] p) throws PizzaAlreadyExitsException {	//overrided methods
		boolean isAdded=false;
		for(int i=0;i<p.length;i++) {
			pizza.add(p[i]);
			isAdded=true;
		}
		return isAdded;
	}

	@Override
	public Pizza getPizzaByName(String pizzaName) throws PizzaNotFoundException {
		List<Pizza> list = new ArrayList<>(pizza);
		int i=-1;
		for(Pizza p:pizza) {
			if(p!=null && pizza.contains(pizzaName)) {
				return list.get(i++);
			}
		}
		throw new PizzaNotFoundException();
	}

	@Override
	public Pizza updatePizza(String pizzaName, Pizza pizzaUpdate) {
		if(pizza.contains(pizzaName)) {
			pizza.add(pizzaUpdate);
		}
		return pizzaUpdate;
	}

	@Override
	public boolean deletePizza(String pizzaName) {
		return pizza.remove(pizzaName);
	}

	@Override
	public Pizza[] getPizzaByCountBySize(int size) {
		int cnt=0;
		Pizza p[]=new Pizza[1];
		for (Pizza value : pizza) {
			if(pizza.contains(size)) {
				p[cnt]=value;
				cnt++;
			}
        }
		return p;
	}
	
}
