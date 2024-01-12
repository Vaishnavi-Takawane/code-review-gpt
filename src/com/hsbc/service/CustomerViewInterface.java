package com.hsbc.service;

import com.hsbc.exception.PizzaAlreadyExitsException;
import com.hsbc.exception.PizzaNotFoundException;
import com.hsbc.model.Pizza;
//inteface implemented by CustomerView class
public interface CustomerViewInterface {
	public boolean AddPizzaDetailsandStore(Pizza pizza[]) throws PizzaAlreadyExitsException;
	public Pizza displayPizzaDetailsbyName(String pizzaName) throws PizzaNotFoundException;
	public Pizza updatePizza(String pizzaName,Pizza pizza);
	public boolean deletePizza(String pizzaName);
	public Pizza[] getPizzaByCountBySize(int size);
}
