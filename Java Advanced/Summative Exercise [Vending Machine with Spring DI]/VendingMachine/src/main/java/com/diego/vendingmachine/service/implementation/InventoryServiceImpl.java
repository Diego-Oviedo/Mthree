package com.diego.vendingmachine.service.implementation;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.diego.vendingmachine.model.dao.*;
import com.diego.vendingmachine.model.dao.implementation.InventoryDAOImpl;
import com.diego.vendingmachine.model.dto.*;
import com.diego.vendingmachine.service.*;

@Component("inventory_service")
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	@Qualifier("audit_dao")
	private AuditDAO audit_dao;

	@Autowired
	@Qualifier("inventory_dao")
	private InventoryDAO inventory_dao;

	public Inventory createInventory(String file_name)
			throws DataSourceException, InventoryException, vendingMachinePersistenceException, IOException {

		Inventory inventory_created = null;
		try {
			inventory_dao = new InventoryDAOImpl(file_name);

			inventory_created = inventory_dao.addInventory(file_name); 

			audit_dao.writeAuditEntry(
					"CREATE_inventory [" + inventory_created.getInventory().values() + "] \n{inventory created}");
		} catch (Exception e) {
			if (e.getClass().equals(DataSourceException.class)) {
				throw new DataSourceException(e.getMessage(), e.getCause());
			} else if (e.getClass().equals(InventoryException.class)) {
				throw new InventoryException(e.getMessage(), e.getCause());
			} else if (e.getClass().equals(vendingMachinePersistenceException.class)) {
				throw new vendingMachinePersistenceException(e.getMessage(), e.getCause());
			} else {
				e.printStackTrace(); 

			}

		}

		return inventory_created;
	}

	public Inventory retreiveInventory() throws DataSourceException, InventoryException {
		Inventory inventory_retreived = null;
		try {
			inventory_retreived = inventory_dao.getInventory();
		} catch (Exception e) {
			if (e.getClass().equals(DataSourceException.class)) {
				throw new DataSourceException(e.getMessage(), e.getCause());
			} else if (e.getClass().equals(InventoryException.class)) {
				throw new InventoryException(e.getMessage(), e.getCause());
			} else {
				e.printStackTrace();

			}
		}

		return inventory_retreived;
	}

	public Inventory updateInventory()
			throws DataSourceException, InventoryException, vendingMachinePersistenceException {
		Inventory inventory_updated = null;

		try {
			inventory_updated = inventory_dao.editInventory();
		} catch (Exception e) {
			if (e.getClass().equals(DataSourceException.class)) {
				throw new DataSourceException(e.getMessage(), e.getCause());
			} else if (e.getClass().equals(InventoryException.class)) {
				throw new InventoryException(e.getMessage(), e.getCause());
			} else if (e.getClass().equals(vendingMachinePersistenceException.class)) {
				throw new vendingMachinePersistenceException(e.getMessage(), e.getCause());
			} else {
				e.printStackTrace();

			}
		}

		return inventory_updated;
	}

	public Inventory deleteInventory()
			throws DataSourceException, InventoryException, vendingMachinePersistenceException {

		Inventory inventory_deleted = null;
		try {
			inventory_deleted = inventory_dao.editInventory();
			audit_dao.writeAuditEntry(
					"DELETE_inventory [" + inventory_deleted.getInventory().toString() + "] \n{inventory deleted}");

		} catch (Exception e) {
			if (e.getClass().equals(DataSourceException.class)) {
				throw new DataSourceException(e.getMessage(), e.getCause());
			} else if (e.getClass().equals(InventoryException.class)) {
				throw new InventoryException(e.getMessage(), e.getCause());
			} else if (e.getClass().equals(vendingMachinePersistenceException.class)) {
				throw new vendingMachinePersistenceException(e.getMessage(), e.getCause());
			} else {
				e.printStackTrace();

			}
		}

		return inventory_deleted;
	}

}
