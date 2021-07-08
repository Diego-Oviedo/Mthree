package com.diego.vendingmachine.service.test;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.diego.vendingmachine.dao.DataSourceException;
import com.diego.vendingmachine.dao.InventoryException;
import com.diego.vendingmachine.dao.vendingMachinePersistenceException;
import com.diego.vendingmachine.dto.Item;
import com.diego.vendingmachine.service.*;
import com.diego.vendingmachine.service.stubs.ItemServiceImplStub;

class ItemServiceTest {
	
	@Autowired
	@Qualifier("item_service_test")
	private ItemService item_service_test;

	@BeforeEach
	void setUp() throws Exception {
		item_service_test = new ItemServiceImplStub();
	}

	@Test
	void testCreateExistingItem() {
		/*Testing: Attempt to create an item that already exists*/
		//ARRANGE
		Item test_item = new Item();
		test_item.setSKU("TSTS0001");
		test_item.setItem_description("TEST ITEM");
		test_item.setUnit_price(new BigDecimal("3.78"));
		
		int[] stock = new int [3];
		stock[0] = 1;
		stock[1] = 1;
		stock[2] = 1;

		test_item.setUnits_in_stock(stock); 
		
		Item item_added = null;
		
		//ACT
		try {
		item_added = item_service_test.createItem(test_item);
		} catch (DataSourceException e) {
			fail("No exception expected.");
		} catch (InventoryException e) {
			fail("No exception expected.");
		} catch (vendingMachinePersistenceException e) {
			fail("No exception expected.");
		}
		
		//ASSERT
		assertNotNull( item_added, "Item added shoul not be null");
		assertEquals(item_added, test_item, "Item added should be the same as the already existing and not create a new one");
		
	}
	
	@Test
	void testCreateItem() {
		/*Testing: Attempt to create an item not previously recorded*/
		//ARRANGE
		Item test_item = new Item();
		test_item.setSKU("TSTS0002");
		test_item.setItem_description("TEST ITEM 2");
		test_item.setUnit_price(new BigDecimal("4.78"));
		
		int[] stock = new int [2];
		stock[0] = 1;
		stock[1] = 1;

		test_item.setUnits_in_stock(stock); 
		
		Item item_added = null;
		
		//ACT
		try {
		item_added = item_service_test.createItem(test_item);
		} catch (DataSourceException e) {
			fail("No exception expected.");
		} catch (InventoryException e) {
			fail("No exception expected.");
		} catch (vendingMachinePersistenceException e) {
			fail("No exception expected.");
		}
		
		//ASSERT
		assertNotNull( item_added, "Item added shoul not be null");
		assertEquals(item_added, test_item, "Item added should be same as the attempted item to create");
		assertTrue(item_added.getSKU().equals(test_item.getSKU()),"SKU's should be the same");
		assertTrue(item_added.getItem_description().equals(test_item.getItem_description()),"descriptions should be the same");
		assertEquals(item_added.getUnit_price().compareTo(test_item.getUnit_price()), 0 ,"prices should be the same");
		assertEquals(item_added.getUnits_in_stock().length ,test_item.getUnits_in_stock().length, "stocks should be the same");
	}
	
	@Test
	void testRetreiveNonExistingItem() {
		/*Testing: Retrieve an item by SKU*/
		//ARRANGE
		Item item_retreived = null;
		
		//ACT & ASSERT
		try {
			item_retreived = item_service_test.retreiveItem("TSTS0002");
		} catch (DataSourceException e) {
			fail("No exception expected.");
		} catch (InventoryException e) {
			fail("No exception expected.");
		} catch (NonExistingItemException e) {
			//EXPECTING THIS THE EXCEPTION TO BE THROWN
			assertTrue(e.getMessage().contains("Item not registered..."));
		}
		
	
	}
	
	@Test
	void testRetreiveItem() {
		/*Testing: Retrieve an item by SKU*/
		//ARRANGE
		Item item_retreived = null;
		
		//ACT
		try {
			item_retreived = item_service_test.retreiveItem("TSTS0001");
		} catch (DataSourceException e) {
			fail("No exception expected.");
		} catch (InventoryException e) {
			fail("No exception expected.");
		} catch (NonExistingItemException e) {
			fail("No exception expected.");
		}
		
		
		//ASSERT
		assertNotNull(item_retreived, "Item retreived shoul not be null");
		assertTrue(item_retreived.getSKU().equals("TSTS0001"),"SKU's should be TSTS0001");
		assertTrue(item_retreived.getItem_description().equals("TEST ITEM"),"descriptions should be TEST ITEM");
		assertEquals(item_retreived.getUnit_price().compareTo(new BigDecimal("3.78")), 0 ,"prices should be 3.78");
		assertEquals(item_retreived.getUnits_in_stock().length ,3, "stocks should be 3");
		
	}
	
	@Test
	void testRetreiveItembyDescription() {
		/*Testing: Retrieve an item by Description*/
		//ARRANGE
		Item item_retreived = null;
		
		//ACT
		try {
			item_retreived = item_service_test.retreiveItembyDescription("TEST ITEM");
		} catch (DataSourceException e) {
			fail("No exception expected.");
		} catch (InventoryException e) {
			fail("No exception expected.");
		}
		
		
		//ASSERT
		assertNotNull(item_retreived, "Item retreived shoul not be null");
		assertTrue(item_retreived.getSKU().equals("TSTS0001"),"SKU's should be TSTS0001");
		assertTrue(item_retreived.getItem_description().equals("TEST ITEM"),"descriptions should be TEST ITEM");
		assertEquals(item_retreived.getUnit_price().compareTo(new BigDecimal("3.78")), 0 ,"prices should be 3.78");
		assertEquals(item_retreived.getUnits_in_stock().length ,3, "stocks should be 3");
		
	}
	
	@Test
	void testUpdateItem() throws DataSourceException, InventoryException, NonExistingItemException {
		/*Testing: Update an item*/
		//ARRANGE
		Item item_retreived = item_service_test.retreiveItem("TSTS0001");
		
		item_retreived.setItem_description("TEST ITEM UPDATED");
		item_retreived.setUnit_price(new BigDecimal ("5.75"));
		
		Item item_updated = null;
		
		//ACT 
		try {
			item_updated = item_service_test.updateItem("TSTS0001", item_retreived);
		} catch (DataSourceException e) {
			fail("No exception expected.");
		} catch (InventoryException e) {
			fail("No exception expected.");
		} catch (vendingMachinePersistenceException e) {
			fail("No exception expected.");
		}
		
		//ASSERT
		assertNotNull(item_updated, "Item updated shoul not be null");
		assertTrue(item_updated.getItem_description().equals("TEST ITEM UPDATED"),"descriptions should be TEST ITEM UPDATED");
		assertEquals(item_updated.getUnit_price().compareTo(new BigDecimal("5.75")), 0 ,"prices should be 5.75");
	}

	@Test
	void testDeleteItem() throws DataSourceException, InventoryException, NonExistingItemException {
		/*Testing: Delete an item*/
		//ARRANGE
		Item item_retreived = item_service_test.retreiveItem("TSTS0001");
		
		Item item_deleted = null;
		
		//ACT
		try {
			item_deleted = item_service_test.deleteItem(item_retreived.getSKU());
		} catch (DataSourceException e) {
			fail("No exception expected.");
		} catch (InventoryException e) {
			fail("No exception expected.");
		} catch (vendingMachinePersistenceException e) {
			fail("No exception expected.");
		}
		
		//ASSERT
		assertNotNull(item_deleted, "Item deleted shoul not be null");
		assertTrue(item_deleted.getItem_description().equals("TEST ITEM"),"descriptions should be TEST ITEM");
		assertEquals(item_deleted.getUnit_price().compareTo(new BigDecimal("3.78")), 0 ,"prices should be 3.78");
		
	}
	
	@Test
	void testRetreiveAllItems() throws DataSourceException, InventoryException, NonExistingItemException {
		/*Testing: Retrieve all items*/
		//ARRANGE
		List<Item> items = null;
		Item item = item_service_test.retreiveItem("TSTS0001");
		
		//ACT
		try {
			items = item_service_test.retreiveAllItems();
		} catch (DataSourceException e) {
			fail("No exception expected.");
		} catch (InventoryException e) {
			fail("No exception expected.");
		}
		
		//ASSERT
		assertFalse(items.isEmpty(), "List should not be empty");
		assertTrue(items.contains(item), "List should contain the item well known as existing");
		
	}

}
