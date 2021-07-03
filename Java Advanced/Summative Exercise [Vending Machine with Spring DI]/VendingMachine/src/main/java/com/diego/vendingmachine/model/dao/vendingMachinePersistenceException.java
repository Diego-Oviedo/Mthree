package com.diego.vendingmachine.model.dao;

public class vendingMachinePersistenceException  extends Exception{

	public vendingMachinePersistenceException(String message) {
        super(message);
    }
    
    public vendingMachinePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
