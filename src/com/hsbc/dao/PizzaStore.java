package com.hsbc.dao;

import com.hsbc.model.Pizza;
import com.hsbc.exception.PizzaAlreadyExitsException;
import com.hsbc.exception.PizzaNotFoundException;
//inteface implemented by all classes in dao
public interface PizzaStore {
	public boolean addNewPizza(Pizza pizza[])  throws PizzaAlreadyExitsException;
	public Pizza getPizzaByName(String pizzaName) throws PizzaNotFoundException;
	public Pizza updatePizza(String pizzaName, Pizza pizza);
	public boolean deletePizza(String pizzaName);
	public Pizza[] getPizzaByCountBySize(int size);
}
