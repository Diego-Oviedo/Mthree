package com.diego.vendingmachine.model.dao.implementation;

import org.springframework.stereotype.Component;
import com.diego.vendingmachine.model.dao.*;
import com.diego.vendingmachine.model.dto.*;

@Component("sale_dao")
public class SaleDAOImpl implements SaleDAO {

	public Item addSale(Inventory inventory, Sale sale) {

		String sku_sold = sale.getSold_item().getSKU();

		Item item_sold = inventory.getInventory().get(sku_sold).remove(0);

		return item_sold;
	}

}
