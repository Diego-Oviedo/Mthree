package com.diego.vendingmachine.service.test;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.diego.vendingmachine.dao.*;
import com.diego.vendingmachine.dto.Item;
import com.diego.vendingmachine.service.*;
import com.diego.vendingmachine.service.stubs.*;

class SaleServiceTest {
	
	@Autowired
	@Qualifier("sale_service")
	private SaleService sale_service_test;
	
	@Autowired
	@Qualifier("item_service_test")
	private ItemService item_service_test;

	@BeforeEach
	void setUp() throws Exception {
		
		sale_service_test = new SaleServiceImplStub();
		
		item_service_test = new ItemServiceImplStub();
	}
	
	
	@Test
	void testEntrySale() throws DataSourceException, InventoryException, NonExistingItemException {
		/*Testing: method entrySale() with a regular item*/
		//ARRANGE
		Item item_to_sell = item_service_test.retreiveItem("TSTS0001");
		item_to_sell.setSKU("TSTS0001");
		
	
		//ACT & ASSERT
		try {
			sale_service_test.entrySale(item_to_sell);
		} catch (NoItemInventoryException e) {
			fail("No exception expected.");
		} catch (vendingMachinePersistenceException e) {
			fail("No exception expected.");
		} catch (DataSourceException e) {
			fail("No exception expected.");
		} catch (InventoryException e) {
			fail("No exception expected.");
		} catch (NonExistingItemException e) {
			fail("No exception expected.");
		}

	}

	@Test
	void testEntrySaleWithNonExistingItem() {
		/*Testing: method entrySale() with a non-existing item*/
		//ARRANGE
		Item item_to_sell = new Item();
		item_to_sell.setSKU("TSTS0002");
		item_to_sell.setItem_description("TEST ITEM 2");
		item_to_sell.setUnit_price(new BigDecimal("6.78"));
		
		int[] stock = new int [2];
		stock[0] = 1;
		stock[1] = 1;
		
		item_to_sell.setUnits_in_stock(stock);
		
		//ACT & ASSERT
		try {
			sale_service_test.entrySale(item_to_sell);
		} catch (NoItemInventoryException e) {
			fail("Incorrect exception was thrown.");
		} catch (vendingMachinePersistenceException e) {
			fail("Incorrect exception was thrown.");
		} catch (DataSourceException e) {
			fail("Incorrect exception was thrown.");
		} catch (InventoryException e) {
			fail("Incorrect exception was thrown.");
		} catch (NonExistingItemException e) {
			//EXPECTING THIS THE EXCEPTION TO BE THROWN
			assertTrue(e.getMessage().contains("Item not registered..."));
		}

	}
	
	@Test
	void testEntrySaleWithA0StockItem() throws DataSourceException, InventoryException, NonExistingItemException {
		/*Testing:  method entrySale() with a 0 stock item item*/
		//ARRANGE
		Item item_to_sell = item_service_test.retreiveItem("TSTS0001");
			
		
		//ACT & ASSERT
		try {
			sale_service_test.entrySale(item_to_sell);
			sale_service_test.entrySale(item_to_sell);
			sale_service_test.entrySale(item_to_sell);
		} catch (NoItemInventoryException e) {
			//EXPECTING THIS THE EXCEPTION TO BE THROWN
			assertTrue(e.getMessage().contains("Item out of stock"));
		} catch (vendingMachinePersistenceException e) {
			fail("Incorrect exception was thrown.");
		} catch (DataSourceException e) {
			fail("Incorrect exception was thrown.");
		} catch (InventoryException e) {
			fail("Incorrect exception was thrown.");
		} catch (NonExistingItemException e) {
			fail("Incorrect exception was thrown.");
		}

	}

}
