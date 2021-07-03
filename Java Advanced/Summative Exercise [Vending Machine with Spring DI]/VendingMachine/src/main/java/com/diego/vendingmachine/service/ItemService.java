package com.diego.vendingmachine.service;

import java.util.List;

import com.diego.vendingmachine.model.dao.*;
import com.diego.vendingmachine.model.dto.*;

public interface ItemService {

	public List<Item> createItem(Item item, Inventory inventory, int num_units) throws vendingMachinePersistenceException, DataSourceException;
	
	public List<Item> retreiveItem(Inventory inventory,String SKU);
	
	public List<Item> updateItem(Inventory inventory,String SKU, Item item, int num_units);
	
	public List<Item> deleteItem(Inventory inventory,String SKU) throws vendingMachinePersistenceException, DataSourceException;
	
}
