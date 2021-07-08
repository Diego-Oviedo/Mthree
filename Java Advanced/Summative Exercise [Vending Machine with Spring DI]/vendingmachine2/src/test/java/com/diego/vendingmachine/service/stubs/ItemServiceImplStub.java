package com.diego.vendingmachine.service.stubs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.diego.vendingmachine.dao.AuditDAO;
import com.diego.vendingmachine.dao.DataSourceException;
import com.diego.vendingmachine.dao.InventoryException;
import com.diego.vendingmachine.dao.ItemDAO;
import com.diego.vendingmachine.dao.vendingMachinePersistenceException;
import com.diego.vendingmachine.dao.implementation.AuditDAOImpl;
import com.diego.vendingmachine.dao.implementation.ItemDAOImpl;
import com.diego.vendingmachine.dao.stubs.AuditDAOImplStub;
import com.diego.vendingmachine.dao.stubs.ItemDAOImplStub;
import com.diego.vendingmachine.dto.Item;
import com.diego.vendingmachine.service.ItemService;
import com.diego.vendingmachine.service.NonExistingItemException;
import com.diego.vendingmachine.service.implementation.ItemServiceImpl;

@Component("item_service_test")
public class ItemServiceImplStub implements ItemService {
	
	@Autowired
	@Qualifier("item_dao_test")
	private ItemDAO item_dao_test;
	
	@Autowired
	@Qualifier("audit_dao_test")
	private AuditDAO audit_dao_test;
	
	public ItemServiceImplStub() {
		super();
		item_dao_test = new ItemDAOImplStub();
		audit_dao_test = new AuditDAOImplStub();
	}
	
	public Item createItem(Item item) throws DataSourceException, InventoryException, vendingMachinePersistenceException {
		Item item_added = null;
		
		//If the item aimed to be added already exists 
		if(item_dao_test.getItem(item.getSKU()) != null) {
			item_added =item_dao_test.editItem(item.getSKU(), item);
		}else {
			item_added = item_dao_test.addItem(item);
		}
		audit_dao_test.writeAuditEntry("[Item Created] : " + item_added.getSKU() + " " + item_added.getItem_description());
		return item_added;
	}

	public Item retreiveItem(String SKU) throws DataSourceException, InventoryException, NonExistingItemException {
		Item item_retreived = null;
		
		try {
			item_retreived = item_dao_test.getItem(SKU);
		}catch(NullPointerException e) {
			throw new NonExistingItemException("Item not registered...");
		}
		
		return item_retreived;
	}

	public Item retreiveItembyDescription(String item_description) throws DataSourceException, InventoryException {
		return item_dao_test.findItembyDescription(item_description);
	}

	public Item updateItem(String SKU, Item item) throws DataSourceException, InventoryException, vendingMachinePersistenceException {
		Item item_updated = item_dao_test.editItem(SKU, item);
		audit_dao_test.writeAuditEntry("[Item Updated] : " + item_updated.getSKU() + " " + item_updated.getItem_description());
		return item_updated;
	}

	public Item deleteItem(String SKU) throws DataSourceException, InventoryException, vendingMachinePersistenceException {
		Item item_deleted = item_dao_test.removeItem(SKU);
		audit_dao_test.writeAuditEntry("[Item Deleted] : " + item_deleted.getSKU() + " " + item_deleted.getItem_description());
		return item_deleted;
	}

	public List<Item> retreiveAllItems() throws DataSourceException, InventoryException {
		return item_dao_test.getAllItems();
	}

}
