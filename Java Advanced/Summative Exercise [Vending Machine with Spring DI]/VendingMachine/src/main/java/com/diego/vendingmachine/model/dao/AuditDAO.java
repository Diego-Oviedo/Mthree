package com.diego.vendingmachine.model.dao;



public interface AuditDAO {

	public void writeAuditEntry(String entry) throws vendingMachinePersistenceException,DataSourceException;
}
