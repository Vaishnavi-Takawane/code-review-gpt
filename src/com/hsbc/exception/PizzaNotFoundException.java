package com.hsbc.exception;


public class PizzaNotFoundException extends Exception {	//overloaded constrcutor
		public PizzaNotFoundException(){
			super();
		}
	    public PizzaNotFoundException(String message) {
	        super(message); 
	    }

	    public PizzaNotFoundException(String message, Throwable cause) {
	        super(message, cause); 
	    }

	    public PizzaNotFoundException(Throwable cause) {
	        super(cause); 
	    }
}
