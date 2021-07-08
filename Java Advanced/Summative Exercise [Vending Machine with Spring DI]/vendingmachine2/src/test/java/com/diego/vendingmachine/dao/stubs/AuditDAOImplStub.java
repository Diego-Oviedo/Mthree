package com.diego.vendingmachine.dao.stubs;

import org.springframework.stereotype.Component;

import com.diego.vendingmachine.dao.AuditDAO;
import com.diego.vendingmachine.dao.DataSourceException;
import com.diego.vendingmachine.dao.vendingMachinePersistenceException;

@Component("audit_dao_test")
public class AuditDAOImplStub implements AuditDAO {

	public void writeAuditEntry(String entry) throws vendingMachinePersistenceException, DataSourceException {
		// TODO Auto-generated method stub

	}

}
