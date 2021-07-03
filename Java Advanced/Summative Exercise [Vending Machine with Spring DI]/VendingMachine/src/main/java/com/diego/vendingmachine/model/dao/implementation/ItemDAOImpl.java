package com.diego.vendingmachine.model.dao.implementation;

import com.diego.vendingmachine.model.dao.ItemDAO;
import com.diego.vendingmachine.model.dto.Inventory;
import com.diego.vendingmachine.model.dto.Item;
import java.time.LocalDate;
import java.util.*;
import org.springframework.stereotype.Component;

@Component("item_dao")
public class ItemDAOImpl implements ItemDAO {

	public List<Item> createItem(Item item, Inventory inventory, int num_units) {	

		String SKU = "ITM"+//Prefix
					item.getItem_description().substring(0,2)+//Description piece
					item.getItem_description().substring(3,4) + //Description piece
					"000"+//Zeros
					LocalDate.now().getMonth()+//Month
					(String.valueOf(LocalDate.now().getYear()).substring(2,4));//Year
		
		item.setSKU(SKU);
		
		List<Item> item_stock = new ArrayList<Item>();
		
		while (num_units >= 0) {
			
			item_stock.add(item);
			
			num_units--;
		}
		
		inventory.getInventory().put(item.getSKU(), item_stock);
			
		return inventory.getInventory().get(item.getSKU());
	}

	public List<Item> retreiveItem(Inventory inventory,String SKU) {
		
		List<Item> item_found = inventory.getInventory().get(SKU);
		
		return item_found;
	}

	public List<Item> updateItem(Inventory inventory,String SKU, Item item) {
		
		int units_in_stock = inventory.getInventory().get(SKU).size();
				
		inventory.getInventory().remove(SKU);
		
		String new_SKU = "ITM"+//Prefix
				item.getItem_description().substring(0,2)+//Description piece
				item.getItem_description().substring(3,4) + //Description piece
				"000"+//Zeros
				LocalDate.now().getMonth()+//Month
				(String.valueOf(LocalDate.now().getYear()).substring(2,4));//Year
	
		item.setSKU(new_SKU);
		
		List<Item> item_updated = createItem(item,inventory,units_in_stock);
		
		return item_updated;
	}

	public List<Item> deleteItem(Inventory inventory,String SKU) {
		
		List<Item> item_deleted = inventory.getInventory().remove(SKU);
		
		return item_deleted;
	}

}
