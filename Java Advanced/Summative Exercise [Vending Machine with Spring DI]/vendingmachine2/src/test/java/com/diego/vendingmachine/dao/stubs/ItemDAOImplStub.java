package com.diego.vendingmachine.dao.stubs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.diego.vendingmachine.dao.DataSourceException;
import com.diego.vendingmachine.dao.InventoryException;
import com.diego.vendingmachine.dao.ItemDAO;
import com.diego.vendingmachine.dto.Item;

@Component("item_dao_test")
public class ItemDAOImplStub implements ItemDAO {

	private Item test_item;
	
	public ItemDAOImplStub() {
		test_item = new Item();
		test_item.setSKU("TSTS0001");
		test_item.setItem_description("TEST ITEM");
		test_item.setUnit_price(new BigDecimal("3.78"));
		
		int[] stock = new int [3];
		stock[0] = 1;
		stock[1] = 1;
		stock[2] = 1;

		test_item.setUnits_in_stock(stock); 
		
	}

	public ItemDAOImplStub(Item test_item) {
		super();
		this.test_item = test_item;
	}

	public Item addItem(Item item) throws DataSourceException, InventoryException {
		if (item.equals(test_item)) {
            return test_item;
        }else if (!item.equals(test_item)) {
            return item;
        } else {
            return null;
        }
	}

	public Item getItem(String SKU) throws DataSourceException, InventoryException {
		if (SKU.equals(test_item.getSKU())) {
            return test_item;
        } else {
            return null;
        }       
	}

	public Item findItembyDescription(String item_description) throws DataSourceException, InventoryException {
		if (item_description.equals(test_item.getItem_description())) {
            return test_item;
        } else {
            return null;
        }       
	}

	public Item editItem(String SKU, Item item) throws DataSourceException, InventoryException {
		if (SKU.equals(test_item.getSKU()) && item.equals(test_item)) {
            return test_item;
        } else {
            return item;
        }       
	}

	public Item removeItem(String SKU) throws DataSourceException, InventoryException {
		if (SKU.equals(test_item.getSKU())) {
            return test_item;
        } else {
            return null;
        }       
	}

	public List<Item> getAllItems() throws DataSourceException, InventoryException {
		List<Item> itemList = new ArrayList<Item>();
        itemList.add(test_item);
        return itemList;
	}
	
	

}
