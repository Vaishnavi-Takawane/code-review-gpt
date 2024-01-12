package com.hsbc.dao;

import com.hsbc.model.Pizza;
import com.hsbc.exception.PizzaNotFoundException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import com.hsbc.exception.PizzaAlreadyExitsException;
//stores pizza in file
public class PizzaStoreFileImpl implements PizzaStore{

	public Pizza pizzas[]=new Pizza[10];
	public int index=0;
	@Override
	public boolean addNewPizza(Pizza pizza[])  throws PizzaAlreadyExitsException{	//overrided methods
		boolean isAdded=false;
		File file=new File("Pizza.txt");
		FileOutputStream output=null;
		ObjectOutputStream objOutput=null;
		try {
			output = new FileOutputStream(file);
			objOutput = new ObjectOutputStream(output);
			objOutput.writeObject(pizza);
			isAdded=true;
		} 
		catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
		try {
			objOutput.close();
			output.close();
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return isAdded;
	}

	@Override
	public Pizza getPizzaByName(String pizzaName) throws PizzaNotFoundException{
		Pizza availablePizza=null;
		File file=new File("Pizza.txt");
		try {
			FileInputStream input=new FileInputStream(file);
			ObjectInputStream objInput=new ObjectInputStream(input);
			availablePizza=(Pizza)objInput.readObject();
			input.close();
			objInput.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return availablePizza;
	}

	//The below methods are not mentioned in assignment therefore they are yet to be completed
	@Override
	public Pizza updatePizza(String pizzaName, Pizza pizza) {
		return null;
	}

	@Override
	public boolean deletePizza(String pizzaName) {
		return false;
	}
	
	@Override
	public Pizza[] getPizzaByCountBySize(int size) {
		return null;
	}
}
