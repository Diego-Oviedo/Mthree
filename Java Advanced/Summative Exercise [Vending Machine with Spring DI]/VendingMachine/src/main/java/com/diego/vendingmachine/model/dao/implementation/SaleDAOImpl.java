package com.diego.vendingmachine.model.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.diego.vendingmachine.model.dao.*;
import com.diego.vendingmachine.model.dto.*;

@Component("sale_dao")
public class SaleDAOImpl implements SaleDAO {
	
	@Autowired
	@Qualifier("iventory_dao")
	InventoryDAO inventory_dao;
	
	public Item entrySale(Inventory inventory, Sale sale) {
		
		String sku_sold = sale.getSold_item().getSKU();
		
		Item item_sold = inventory.getInventory().get(sku_sold).remove(0);
		
		return item_sold;
	}

}
