package com.hsbc.exception;

public class PizzaAlreadyExitsException extends Exception {	//overloaded constructor
	public PizzaAlreadyExitsException() {
		super();
	}
    public PizzaAlreadyExitsException(String message) {
        super(message); 
    }

    public PizzaAlreadyExitsException(String message, Throwable cause) {
        super(message, cause); 
    }

    public PizzaAlreadyExitsException(Throwable cause) {
        super(cause); 
    }

}
