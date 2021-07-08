package com.diego.vendingmachine.service.test;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.diego.vendingmachine.dao.DataSourceException;
import com.diego.vendingmachine.dao.InventoryException;
import com.diego.vendingmachine.dto.Item;
import com.diego.vendingmachine.service.*;
import com.diego.vendingmachine.service.stubs.ItemServiceImplStub;
import com.diego.vendingmachine.service.stubs.PaymentServiceImplStub;

class PaymentServiceTest {

	@Autowired
	@Qualifier("payment_service")
	private PaymentService payment_service_test;
	
	@Autowired
	@Qualifier("item_service_test")
	private ItemService item_service_test;
	
	@BeforeEach
	void setUp() throws Exception {
		payment_service_test = new PaymentServiceImplStub();
		item_service_test = new ItemServiceImplStub();
	}

	@Test
	void testGiving0AsChange() throws DataSourceException, InventoryException, NonExistingItemException {
		/*Testing: Giving 0 as change (paying the exact amount)*/
		//ARRANGE
		Item item_to_sell = new Item();
		item_to_sell.setSKU("TSTS0001");
		item_to_sell.setItem_description("TEST ITEM");
		item_to_sell.setUnit_price(new BigDecimal("6.78"));//PRICE 
		
		int[] stock = new int [2];
		stock[0] = 1;
		stock[1] = 1;
		
		item_to_sell.setUnits_in_stock(stock);
		
		BigDecimal payment = new BigDecimal("6.78");
		Map<String,BigDecimal> change = null;
		
		//ACT & ASSERT
		
		try {
		change  =	payment_service_test.receivePayment(payment, item_to_sell.getUnit_price());
		} catch (InsufficientFundsException e) {
			fail("No exception expected.");
		}
		
		BigDecimal change_converted = change.get("DOLLARS").setScale(2, RoundingMode.UNNECESSARY)
				 .add(change.get("QUARTERS").multiply(new BigDecimal("0.25"))
				 .add(change.get("DIMES").multiply(new BigDecimal("0.10"))
				 .add(change.get("NICKELS").multiply(new BigDecimal("0.05"))
				 .add(change.get("PENNIES").multiply(new BigDecimal("0.01"))
					)//end pennies addition
					)//end nickels addition
					)//end dimes addition 
					);//end quarters addition
		
		//ASSERT
		assertEquals(change_converted, new BigDecimal("0.00") ,"The reminder should be the 0.00 [6.78(payment) - 6.78(item price)]");
		
	}
	
	@Test
	void testGivingChange() throws DataSourceException, InventoryException, NonExistingItemException {
		/*Testing: Giving (paying more than the marked item price )*/
		//ARRANGE
		Item item_to_sell = new Item();
		item_to_sell.setSKU("TSTS0001");
		item_to_sell.setItem_description("TEST ITEM");
		item_to_sell.setUnit_price(new BigDecimal("6.78"));//PRICE 
		
		int[] stock = new int [2];
		stock[0] = 1;
		stock[1] = 1;
		
		item_to_sell.setUnits_in_stock(stock);
		
		BigDecimal payment = new BigDecimal("13.90");
		Map<String,BigDecimal> change = null;
		
		//ACT & ASSERT
		
		try {
		change  =	payment_service_test.receivePayment(payment, item_to_sell.getUnit_price());
		} catch (InsufficientFundsException e) {
			fail("No exception expected.");
		}
		
		BigDecimal change_converted = change.get("DOLLARS").setScale(2, RoundingMode.UNNECESSARY)
				 .add(change.get("QUARTERS").multiply(new BigDecimal("0.25"))
				 .add(change.get("DIMES").multiply(new BigDecimal("0.10"))
				 .add(change.get("NICKELS").multiply(new BigDecimal("0.05"))
				 .add(change.get("PENNIES").multiply(new BigDecimal("0.01"))
					)//end pennies addition
					)//end nickels addition
					)//end dimes addition 
					);//end quarters addition
		
		//ASSERT
		assertEquals(change.get("DOLLARS"), new BigDecimal("7") ,"The amount of dollars should be 7");
		assertEquals(change.get("QUARTERS"), new BigDecimal("0") ,"The amount of quarters should be 0");
		assertEquals(change.get("DIMES"), new BigDecimal("1") ,"The amount of dimes should be 1");
		assertEquals(change.get("NICKELS"), new BigDecimal("0") ,"The amount of nickels should be 0");
		assertEquals(change.get("PENNIES"), new BigDecimal("2") ,"The amount of pennies should be 2");
	
	}
	
	@Test
	void testPayingLessThanThePrice() throws DataSourceException, InventoryException, NonExistingItemException {
		/*Testing: Paying less than the displayed item price*/
		//ARRANGE
		Item item_to_sell = new Item();
		item_to_sell.setSKU("TSTS0001");
		item_to_sell.setItem_description("TEST ITEM");
		item_to_sell.setUnit_price(new BigDecimal("6.78"));//PRICE 
		
		int[] stock = new int [2];
		stock[0] = 1;
		stock[1] = 1;
		
		item_to_sell.setUnits_in_stock(stock);
		
		BigDecimal payment = new BigDecimal("6.77");
		
		//ACT & ASSERT
		
		try {
			payment_service_test.receivePayment(payment, item_to_sell.getUnit_price());
		} catch (InsufficientFundsException e) {
			//EXPECTING THIS THE EXCEPTION TO BE THROWN
			assertTrue(e.getMessage().contains("Insufficient Funds..."));
		}

	}

}
