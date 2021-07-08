package com.diego.vendingmachine.dao;
 
public interface AuditDAO {

	public void writeAuditEntry(String entry) throws vendingMachinePersistenceException,DataSourceException;
}
