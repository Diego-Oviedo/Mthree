package com.diego.vendingmachine.service.stubs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.diego.vendingmachine.dao.AuditDAO;
import com.diego.vendingmachine.dao.DataSourceException;
import com.diego.vendingmachine.dao.InventoryException;
import com.diego.vendingmachine.dao.vendingMachinePersistenceException;
import com.diego.vendingmachine.dao.implementation.AuditDAOImpl;
import com.diego.vendingmachine.dao.stubs.AuditDAOImplStub;
import com.diego.vendingmachine.dto.Item;
import com.diego.vendingmachine.service.ItemService;
import com.diego.vendingmachine.service.NoItemInventoryException;
import com.diego.vendingmachine.service.NonExistingItemException;
import com.diego.vendingmachine.service.SaleService;
import com.diego.vendingmachine.service.implementation.ItemServiceImpl;

@Component("sale_service_test")
public class SaleServiceImplStub implements SaleService {

	@Autowired
	@Qualifier("item_service_test")
	private ItemService item_service_test;
	
	@Autowired
	@Qualifier("audit_dao_test")
	private AuditDAO audit_dao_test;
	
	
	
	public SaleServiceImplStub() {
		super();
		item_service_test = new ItemServiceImplStub();
		audit_dao_test = new AuditDAOImplStub();
	}



	public Item entrySale(Item item) throws NoItemInventoryException, vendingMachinePersistenceException, DataSourceException, InventoryException, NonExistingItemException {
		Item item_sold = null;
		
			//Handling to sell a non-existing item
			if(item_service_test.retreiveItem(item.getSKU()) == null)
				throw new NonExistingItemException("Item not registered...");
			//Handling to sell an item out of stock
			if (item_service_test.retreiveItem(item.getSKU()).getUnits_in_stock().length <= 0) {// If the selected item remains at 1 which is the 0 position, is considered as no stock 
				throw new NoItemInventoryException("Item out of stock");
				
			} else {

				item_sold = item_service_test.retreiveItem(item.getSKU());
				
				int new_units_in_stock = ((item.getUnits_in_stock().length) - 1);
				
				int[] new_item_stock = new int[new_units_in_stock];

				for (int i = new_units_in_stock-1; i >= 0; i--) {

					new_item_stock[i] = i;
				}

				
				item_sold.setUnits_in_stock(new_item_stock);
				
				item_service_test.updateItem(item.getSKU(), item_sold);

				audit_dao_test.writeAuditEntry("[Item Sold] : " + item_sold.getSKU() + " " + item_sold.getItem_description());

			}

		return item_sold;
	}

}
