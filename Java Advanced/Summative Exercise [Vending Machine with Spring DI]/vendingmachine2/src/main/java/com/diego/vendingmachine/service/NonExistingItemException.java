package com.diego.vendingmachine.service;

public class NonExistingItemException extends Exception{

	public NonExistingItemException(String message) {
        super(message);
    }
    
    public NonExistingItemException(String message, Throwable cause) {
        super(message, cause);
    }
}