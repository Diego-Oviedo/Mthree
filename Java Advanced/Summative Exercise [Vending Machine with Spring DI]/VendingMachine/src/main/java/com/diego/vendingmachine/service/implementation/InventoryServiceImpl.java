package com.diego.vendingmachine.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.diego.vendingmachine.model.dao.*;
import com.diego.vendingmachine.model.dto.*;
import com.diego.vendingmachine.service.*;

@Component("inventory_service")
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	@Qualifier("audit_dao")
	private AuditDAO audit_dao;
	
	@Autowired
	@Qualifier("iventory_dao")
	private InventoryDAO inventory_dao;
	
	
	public Inventory createInventory(String file_name) throws DataSourceException, 
															  InventoryException, 
															  vendingMachinePersistenceException {
		
		Inventory inventory_created = inventory_dao.addInventory(file_name);
		
		audit_dao.writeAuditEntry("CREATE_inventory [" + inventory_created.getInventory().values() 
													+ "] \n{inventory created}");
		
		return inventory_created;
	}

	public Inventory retreiveInventory() throws DataSourceException, InventoryException {
		return inventory_dao.getInventory();
	}

	public Inventory updateInventory() throws DataSourceException, 
											  InventoryException, 
											  vendingMachinePersistenceException {
		Inventory inventory_updated = inventory_dao.editInventory();
		audit_dao.writeAuditEntry("UPDATE_inventory [" + inventory_updated.getInventory().toString() 
				+ "] \n{inventory updated}");
		
		return inventory_updated;
	}

	public Inventory deleteInventory() throws DataSourceException, 
											  InventoryException, 
											  vendingMachinePersistenceException {
		
		Inventory inventory_deleted = inventory_dao.editInventory();
		audit_dao.writeAuditEntry("DELETE_inventory [" + inventory_deleted.getInventory().toString() 
				+ "] \n{inventory deleted}");
		
		return inventory_deleted;
	}

}
