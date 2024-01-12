package com.hsbc.dao;

import com.hsbc.model.Pizza;
import com.hsbc.exception.PizzaNotFoundException;
import com.hsbc.exception.PizzaAlreadyExitsException;

public class PizzaStoreImpl implements PizzaStore{
	//stores pizza in array
	public Pizza pizzas[]=new Pizza[10];
	public int index=0;
	@Override
	public boolean addNewPizza(Pizza pizza[])  throws PizzaAlreadyExitsException{		//overrided methods
		boolean isAdded=false;
		if(index<pizzas.length) {
			for(Pizza p:pizza) {
				for(int i=0;i<pizzas.length;i++) {
					if(p!=null && pizzas[i]!=null && pizzas[i].getPizzaName().equalsIgnoreCase(p.getPizzaName())) {
						System.out.println("encounter");
						 throw new PizzaAlreadyExitsException();
					}
				}
				pizzas[index]=p;
				index++;
			}
			isAdded=true;
		}
		return isAdded;
	}

	@Override
	public Pizza getPizzaByName(String pizzaName) throws PizzaNotFoundException{
		for(int i=0;i<pizzas.length;i++) {
			if(pizzas[i]!=null && pizzaName.equalsIgnoreCase(pizzas[i].getPizzaName())) {
				return pizzas[i];
			}
		}
		throw new PizzaNotFoundException();
	}

	@Override
	public Pizza updatePizza(String pizzaName, Pizza pizza) {
		for(int i=0;i<pizzas.length;i++) {
			if(pizzas[i]!=null && pizzas[i].getPizzaName().equalsIgnoreCase(pizzaName)) {
				pizzas[i]=pizza;
				return pizzas[i];
			}
		}
		return null;
	}

	@Override
	public boolean deletePizza(String pizzaName) {
		boolean isDeleted=false;
			for(int i=0;i<pizzas.length;i++) {
				if(pizzas[i]!=null && pizzas[i].getPizzaName().equalsIgnoreCase(pizzaName)) {
					pizzas[i]=null;
					isDeleted=true;
				}
			}
		return isDeleted;
	}
	
	@Override
	public Pizza[] getPizzaByCountBySize(int size) {
		Pizza p[]=new Pizza[10];
		int index=0;
		for(int i=0;i<pizzas.length;i++) {
			if(pizzas[i]!= null && pizzas[i].getSizeIncms()==size) {
				p[index]=new Pizza();
				p[index]=pizzas[i];
				index++;
			}
		}
		return p;
	}
}
