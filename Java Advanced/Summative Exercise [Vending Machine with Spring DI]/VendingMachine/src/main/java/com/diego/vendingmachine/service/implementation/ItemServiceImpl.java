package com.diego.vendingmachine.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.diego.vendingmachine.model.dto.*;
import com.diego.vendingmachine.model.dao.*;
import com.diego.vendingmachine.service.ItemService;

@Component("item_service")
public class ItemServiceImpl implements ItemService {

	@Autowired
	@Qualifier("audit_dao")
	private AuditDAO audit_dao;

	@Autowired
	@Qualifier("item_dao")
	private ItemDAO item_dao;

	public List<Item> createItem(Item item, Inventory inventory, int num_units)
			throws vendingMachinePersistenceException, DataSourceException {

		List<Item> item_created = null;
		try {
			if (inventory.getInventory().containsKey(item.getSKU())) {// if the item already exists

				item_created = item_dao.editItem(inventory, item.getSKU(), item, num_units);

				audit_dao.writeAuditEntry("UPDATE_item [" + item_created.get(0).getSKU() + " - "
						+ item_created.get(0).getItem_description() + "] {quantity updated}");
			} else {

				item_created = item_dao.addItem(item, inventory, num_units);

				audit_dao.writeAuditEntry("CREATE_item [" + item_created.get(0).getSKU() + " - "
						+ item_created.get(0).getItem_description() + "] {item added}");

			}

		} catch (Exception e) {
			if (e.getClass().equals(DataSourceException.class)) {
				throw new DataSourceException(e.getMessage(), e.getCause());
			} else if (e.getClass().equals(vendingMachinePersistenceException.class)) {
				throw new vendingMachinePersistenceException(e.getMessage(), e.getCause());
			} else {
				e.printStackTrace();

			}
		}

		return item_created;
	}

	public List<Item> retreiveItem(Inventory inventory, String SKU) {
		return item_dao.getItem(inventory, SKU);
	}

	public List<Item> updateItem(Inventory inventory, String SKU, Item item, int num_units) {
		return item_dao.editItem(inventory, SKU, item, num_units);
	}

	public List<Item> deleteItem(Inventory inventory, String SKU)
			throws vendingMachinePersistenceException, DataSourceException {
		List<Item> item_deleted = null;

		item_deleted = item_dao.removeItem(inventory, SKU);

		audit_dao.writeAuditEntry("DELETE_item [" + item_deleted.get(0).getSKU() + " - "
				+ item_deleted.get(0).getItem_description() + "] {item deleted}");

		return item_deleted;
	}

}
