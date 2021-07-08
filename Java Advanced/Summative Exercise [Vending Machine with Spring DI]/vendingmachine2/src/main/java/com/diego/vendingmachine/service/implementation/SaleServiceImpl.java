package com.diego.vendingmachine.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.diego.vendingmachine.dao.*;
import com.diego.vendingmachine.dto.*;
import com.diego.vendingmachine.service.ItemService;
import com.diego.vendingmachine.service.NoItemInventoryException;
import com.diego.vendingmachine.service.SaleService;

@Component("sale_service")
public class SaleServiceImpl implements SaleService {

	@Autowired
	private ItemService item_service;
	
	@Autowired
	private AuditDAO audit_dao;
	
	public Item entrySale(Item item) throws NoItemInventoryException, vendingMachinePersistenceException, DataSourceException, InventoryException {
		Item item_sold = null;

			if (item_service.retreiveItem(item.getSKU()).getUnits_in_stock().length <= 0) {// If item does not exists in
				throw new NoItemInventoryException("Item out of stock");
				
			} else {

				item_sold = item_service.retreiveItem(item.getSKU());
				
				int new_units_in_stock = ((item.getUnits_in_stock().length) - 1);
				
				int[] new_item_stock = new int[new_units_in_stock];

				for (int i = new_units_in_stock-1; i >= 0; i--) {

					new_item_stock[i] = i;
				}

				
				item_sold.setUnits_in_stock(new_item_stock);
				
				item_service.updateItem(item.getSKU(), item_sold);

				audit_dao.writeAuditEntry("[Item Sold] : " + item_sold.getSKU() + " " + item_sold.getItem_description());

			}

		return item_sold;
	}

}
