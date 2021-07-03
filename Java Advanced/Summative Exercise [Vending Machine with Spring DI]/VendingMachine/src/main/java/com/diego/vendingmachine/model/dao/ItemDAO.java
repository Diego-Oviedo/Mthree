package com.diego.vendingmachine.model.dao;

import com.diego.vendingmachine.model.dto.*;
import java.util.*;

public interface ItemDAO {

	public List<Item> addItem (Item item, Inventory inventory, int num_units);
	
	public List<Item> getItem (Inventory inventory,String SKU);
	
	public List<Item> editItem (Inventory inventory,String SKU, Item item);
	
	public List<Item> removeItem (Inventory inventory,String SKU);
	
}
