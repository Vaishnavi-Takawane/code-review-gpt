/*
 * CR08_11 -> Vaishnavi Takawane
 * Modified version of pizza project 
 * 
In the previous question make the below modifications to the Pizza class.
1.1.add insertion date field of type Date.
1.2.Override hashCode and equals method.
1.3.Implement comparable interface. While comparing two objects consider pizza name filed.

Create different implementation classes to Storage interface as mentioned below.
2.1.Pizza ListStorelmpl: Use Array list for storing the pizza objects.
2.2.PizzaSortedStorelmpl: Use TreeSet for storing the Pizza objects.
2.3.PizzaMapStorelmpl : Use HashMap for storing the Pizza objects as values and pizza name as keys.

Modify getPizzaStore() as mentioned below. Method should accept integer as a parameter.
3.1.PizzaStore getPizzaStor(int code) method.
3.2.If code = 1 then return PizzaStorelmpl object.
3.3.If code = 2 then return PizzaListStorelmpl.
3.4.If code=3 then return PizzaSortedStorelmpl.
3.5.For any other value return PizzaMapStorelmpl.
 * */

package com.hsbc.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.hsbc.dao.PizzaStore;
import com.hsbc.exception.PizzaAlreadyExitsException;
import com.hsbc.exception.PizzaNotFoundException;
import com.hsbc.factory.PizzaStoreFactory;
import com.hsbc.model.Pizza;
import com.hsbc.service.CustomerView;


public class PizzaApplication {
	public static void sorting() {
		//sort method
		List<Pizza> pizza=new ArrayList<>();
		Pizza p1=new Pizza("Cheese N Corn1","Loaded cheese pizza",20,"Cheese","Corn","Mayo",20,200,new Date());
		Pizza p2=new Pizza("Veggie1","Loaded veggies pizza",15,"Capsicum","Tomato","Basil",30,300,new Date());
		Pizza p3=new Pizza("Barbeque chicken1","Non-veg pizza",20,"Chicken","mushroom","onion",25,350,new Date());
		
		pizza.add(p1);
		pizza.add(p2);
		pizza.add(p3);
		
		System.out.println("Before sorting");
		for(Pizza p:pizza) {
			System.out.println(p);
		}
		
		System.out.println("After sorting");
		Collections.sort(pizza,new PizzaSorter());
		for(Pizza p:pizza) {
			System.out.println(p);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CustomerView service=new CustomerView();
		
		System.out.println("Enter where you want to store");
		System.out.println("1.Array ");
		System.out.println("2.ArrayList ");
		System.out.println("3.TreeSet ");
		System.out.println("Any Other value. HashMap ");
		int ch=sc.nextInt();
		
		PizzaStore dao = PizzaStoreFactory.getPizzaStorage(ch);
		service.setDao(dao);		
	
		System.out.println("1. Add");
		System.out.println("2. Display");
		System.out.println("3. Update");
		System.out.println("4. Delete");
		System.out.println("5. Get Pizzas by size");
		System.out.println("6. Get recipe");
		System.out.println("7. sort");
		int choice;
		
		//menu driven program
		Pizza pizzas[]=new Pizza[10];
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		do {
			System.out.println("Which operation you want to perform");
			choice=sc.nextInt();
			switch(choice) {
			case 1:		//Add
				System.out.println("Enter number of objects to add");
				int noOfObj=sc.nextInt();
				if(noOfObj<11) {
					for(int i=0;i<noOfObj;i++) {
						System.out.println("Enter pizza name, description, size, ingredient1, ingredient2, ingredient3, weight, price & date");
						String pizzaName=sc.next();
						String des=sc.next();
						int size=sc.nextInt();
						String ing1=sc.next();
						String ing2=sc.next();
						String ing3=sc.next();
						int weight=sc.nextInt();
						float price=sc.nextFloat();
						String d=sc.next();
						try {
							date=sdf.parse(d);
						}
						catch (ParseException e) {
							System.out.println(e.getMessage());
						}
						pizzas[i]=new Pizza();
						pizzas[i].setPizzaName(pizzaName);
						pizzas[i].setDescription(des);
						pizzas[i].setSizeIncms(size);
						pizzas[i].setMajorIngredientOne(ing1);
						pizzas[i].setMajorIngredientTwo(ing2);
						pizzas[i].setMajorIngredientThree(ing3);
						pizzas[i].setWeight(weight);
						pizzas[i].setPrice(price);
						pizzas[i].setDate(date);
						
					}
					boolean isAdded=false;
					try {
						isAdded = service.AddPizzaDetailsandStore(pizzas);
					} 
					catch (PizzaAlreadyExitsException e) {
						System.out.println(e.getMessage());
					}
					if(isAdded) {
						System.out.println("Pizzas details added");
					}
					else {
						System.out.println("Pizza details not added");
					}
				}
				else {
					System.out.println("Storage limit exceeded");
				}
			break;
			case 2:		//display
				Pizza p=new Pizza();
				System.out.println("Enter pizza name to search");
				try {
					p=service.displayPizzaDetailsbyName(sc.next());
				} 
				catch (PizzaNotFoundException e1) {
					System.out.println(e1.getMessage());
				}
				if(p.getPizzaName() == null) {
					System.out.println("Pizza not found");
				}
				else {
					System.out.println(p);
				}
			break;
			case 3:
				System.out.println("Enter pizza name to update details");
				String name=sc.next();
				try {
					date=sdf.parse("28/08/2023");
				} 
				catch (ParseException e) {
					System.out.println(e.getMessage());
				}
				Pizza updatePizza=new Pizza(name,"loaded",22,"cheese","corn","mayo",12,230,date);
				updatePizza=service.updatePizza(name, updatePizza);
				System.out.println(updatePizza);
			break;
			case 4:
				System.out.println("Enter pizza name to delete details from list");
				boolean isDeleted=service.deletePizza(sc.next());
				if(isDeleted) {
					System.out.println("Pizza deleted from list");
				}
				else {
					System.out.println("Pizza not deleted from list");
				}
				
			break;
			case 5:
				System.out.println("Enter size to get pizza by size");
				int n=sc.nextInt();
				Pizza pizzaSize[]=new Pizza[10];
				for(int i=0;i<10;i++) {
					pizzaSize[i]=new Pizza();
				}
				pizzaSize=service.getPizzaByCountBySize(n);
				if(pizzaSize!=null) {
					for(Pizza pizza:pizzaSize) {
						if(pizza!=null) {
							System.out.println(pizza);
						}
						else {
							break;
						}
					}
				}
				else {
					System.out.println("Pizza not available");
				}
				
			break;
			case 6:
				Pizza pizzaRecipe=new Pizza();
				pizzaRecipe.preparation();
			break;
			case 7:
				sorting();
			break;
			default:
				System.out.println("Invalid option");
			}
			System.out.println("Do you want to continue. Press 1");
			ch=sc.nextInt();
		}while(ch==1);
		
		sc.close();

	}

}
