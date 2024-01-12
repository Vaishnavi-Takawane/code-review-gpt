package com.hsbc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Pizza implements Serializable,  Comparable<Pizza> {	//model class that contains getter, setter, constructor, etc
	private String pizzaName;
	private String description;
	private int sizeIncms;
	private String majorIngredientOne;
	private String majorIngredientTwo;
	private String majorIngredientThree;
	private int weight;
	private float price;
	private Date date;
	public Pizza() {
		super();
	}
	public Pizza(String pizzaName, String description, int sizeIncms, String majorIngredientOne,
			String majorIngredientTwo, String majorIngredientThree, int weight, float price, Date date) {
		super();
		this.pizzaName = pizzaName;
		this.description = description;
		this.sizeIncms = sizeIncms;
		this.majorIngredientOne = majorIngredientOne;
		this.majorIngredientTwo = majorIngredientTwo;
		this.majorIngredientThree = majorIngredientThree;
		this.weight = weight;
		this.price = price;
		this.date = date;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSizeIncms() {
		return sizeIncms;
	}
	public void setSizeIncms(int sizeIncms) {
		this.sizeIncms = sizeIncms;
	}
	public String getMajorIngredientOne() {
		return majorIngredientOne;
	}
	public void setMajorIngredientOne(String majorIngredientOne) {
		this.majorIngredientOne = majorIngredientOne;
	}
	public String getMajorIngredientTwo() {
		return majorIngredientTwo;
	}
	public void setMajorIngredientTwo(String majorIngredientTwo) {
		this.majorIngredientTwo = majorIngredientTwo;
	}
	public String getMajorIngredientThree() {
		return majorIngredientThree;
	}
	public void setMajorIngredientThree(String majorIngredientThree) {
		this.majorIngredientThree = majorIngredientThree;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Pizza [pizzaName=" + pizzaName + ", description=" + description + ", sizeIncms=" + sizeIncms
				+ ", majorIngredientOne=" + majorIngredientOne + ", majorIngredientTwo=" + majorIngredientTwo
				+ ", majorIngredientThree=" + majorIngredientThree + ", weight=" + weight + ", price=" + price
				+ ", date=" + date + "]";
	}
	public void preparation() {
		System.out.println("1. Preheat the oven to 450°F (230°C).\r\n"
				+ "2. Roll out the pizza dough on a floured surface.\r\n"
				+ "3. Place the dough on a pizza pan or baking sheet.\r\n"
				+ "4. Brush olive oil over the dough.\r\n"
				+ "5. Spread pizza sauce evenly over the dough.\r\n"
				+ "6. Add a layer of shredded cheese.\r\n"
				+ "7. Add your chosen toppings.\r\n"
				+ "8. Season with salt and Italian herbs.\r\n"
				+ "9. Bake in the preheated oven for 12-15 minutes or until golden and bubbly.\r\n"
				+ "10. Remove from the oven and let it cool slightly.\r\n"
				+ "11. Slice the pizza into portions.\r\n"
				+ "12. Serve and enjoy!");
	}
	@Override
	public int hashCode() {
		return Objects.hash(date, description, majorIngredientOne, majorIngredientThree, majorIngredientTwo, pizzaName,
				price, sizeIncms, weight);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		return Objects.equals(date, other.date) && Objects.equals(description, other.description)
				&& Objects.equals(majorIngredientOne, other.majorIngredientOne)
				&& Objects.equals(majorIngredientThree, other.majorIngredientThree)
				&& Objects.equals(majorIngredientTwo, other.majorIngredientTwo)
				&& Objects.equals(pizzaName, other.pizzaName)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price) && sizeIncms == other.sizeIncms
				&& weight == other.weight;
	}
	
	public int compareTo(Pizza p) {
		if(this.pizzaName.equalsIgnoreCase(p.pizzaName)) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
}
