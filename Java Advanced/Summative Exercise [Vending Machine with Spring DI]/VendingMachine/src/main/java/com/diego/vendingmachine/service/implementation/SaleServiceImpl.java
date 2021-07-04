package com.diego.vendingmachine.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.diego.vendingmachine.model.dao.*;
import com.diego.vendingmachine.model.dto.*;
import com.diego.vendingmachine.service.*;

@Component("sale_service")
public class SaleServiceImpl implements SaleService {
	
	@Autowired
	@Qualifier("audit_dao")
	private AuditDAO audit_dao;
	
	@Autowired
	@Qualifier("sale_dao")
	private SaleDAO sale_dao;


	public Item entrySale(Inventory inventory, Sale sale) throws NoItemInventoryException, 
																vendingMachinePersistenceException,
																DataSourceException{
		  
		Item item_sold = null;
		
		if (!inventory.getInventory().containsKey(sale.getSold_item().getSKU())) {//If item does not exists in inventory
			
			throw new NoItemInventoryException("Item out of stock");
		}else {
			
			item_sold = sale_dao.addSale(inventory, sale);
			
			audit_dao.writeAuditEntry("SALE_item [" + item_sold.getSKU() 
									 + " - " + item_sold.getItem_description() 
									 + "] {item sold}");
			
		}
		
		return item_sold;
	}

}
