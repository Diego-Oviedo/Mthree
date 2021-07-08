package com.diego.vendingmachine.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.diego.vendingmachine.dao.*;
import com.diego.vendingmachine.dto.*;
import com.diego.vendingmachine.service.*;

@Component("item_service")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDAO item_dao;
	
	@Autowired
	private AuditDAO audit_dao;
	
	public Item createItem(Item item) throws DataSourceException, InventoryException, vendingMachinePersistenceException {
		Item item_added = null;
		
		//If the item aimed to be added already exists 
		if(item_dao.getItem(item.getSKU()) != null) {
			item_dao.editItem(item.getSKU(), item);
		}else {
			item_added = item_dao.addItem(item);
		}
		audit_dao.writeAuditEntry("[Item Created] : " + item_added.getSKU() + " " + item_added.getItem_description());
		return item_added;
	}

	public Item retreiveItem(String SKU) throws DataSourceException, InventoryException {
		return item_dao.getItem(SKU);
	}

	public Item retreiveItembyDescription(String item_description) throws DataSourceException, InventoryException {
		return item_dao.findItembyDescription(item_description);
	}

	public Item updateItem(String SKU, Item item) throws DataSourceException, InventoryException, vendingMachinePersistenceException {
		Item item_updated = item_dao.editItem(SKU, item);
		audit_dao.writeAuditEntry("[Item Updated] : " + item_updated.getSKU() + " " + item_updated.getItem_description());
		return item_updated;
	}

	public Item deleteItem(String SKU) throws DataSourceException, InventoryException, vendingMachinePersistenceException {
		Item item_deleted = item_dao.removeItem(SKU);
		audit_dao.writeAuditEntry("[Item Deleted] : " + item_deleted.getSKU() + " " + item_deleted.getItem_description());
		return item_deleted;
	}

	public List<Item> retreiveAllItems() throws DataSourceException, InventoryException {
		return item_dao.getAllItems();
	}

}
