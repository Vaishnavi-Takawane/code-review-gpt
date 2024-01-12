package com.hsbc.ui;

import java.util.Comparator;

import com.hsbc.model.Pizza;

public class PizzaSorter implements Comparator<Pizza>{

	@Override
	public int compare(Pizza o1, Pizza o2) {
		//sorting logic
		return o1.getPizzaName().compareTo(o2.getPizzaName());
	}
}
