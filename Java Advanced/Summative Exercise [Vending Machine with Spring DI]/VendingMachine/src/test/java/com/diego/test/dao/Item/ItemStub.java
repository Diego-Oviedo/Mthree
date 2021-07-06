package com.diego.test.dao.Item;

import java.util.List;

import com.diego.vendingmachine.model.dao.ItemDAO;
import com.diego.vendingmachine.model.dto.Inventory;
import com.diego.vendingmachine.model.dto.Item;

public class ItemStub implements ItemDAO {

	public List<Item> addItem(Item item, Inventory inventory, int num_units) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Item> getItem(Inventory inventory, String SKU) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Item> editItem(Inventory inventory, String SKU, Item item, int num_units) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Item> removeItem(Inventory inventory, String SKU) {
		// TODO Auto-generated method stub
		return null;
	}

}
