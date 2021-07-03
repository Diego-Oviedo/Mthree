package com.diego.vendingmachine.model.dao;

import com.diego.vendingmachine.model.dto.*;
import java.util.*;

public interface ItemDAO {

	public List<Item> createItem (Item item, Inventory inventory, int num_units);
	
	public List<Item> retreiveItem (Inventory inventory,String SKU);
	
	public List<Item> updateItem (Inventory inventory,String SKU, Item item);
	
	public List<Item> deleteItem (Inventory inventory,String SKU);
	
}
