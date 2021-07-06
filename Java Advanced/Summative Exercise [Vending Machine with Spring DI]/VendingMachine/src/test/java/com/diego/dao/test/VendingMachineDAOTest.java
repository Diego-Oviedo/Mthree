package com.diego.dao.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.diego.vendingmachine.model.dao.*;
import com.diego.vendingmachine.model.dao.implementation.InventoryDAOImpl;
import com.diego.vendingmachine.model.dao.implementation.ItemDAOImpl;
import com.diego.vendingmachine.model.dao.implementation.PaymentDAOImpl;
import com.diego.vendingmachine.model.dao.implementation.SaleDAOImpl;
import com.diego.vendingmachine.model.dto.Inventory;
import com.diego.vendingmachine.model.dto.Item;
import com.diego.vendingmachine.model.dto.Sale;

@Component("Inventory_test")
public class VendingMachineDAOTest{
	
	
	@Autowired
	@Qualifier("inventory_dao")
	private InventoryDAO test_dao_inventory;
	
	@Autowired
	@Qualifier("item_dao")
	private ItemDAO test_dao_item;
	
	@Autowired
	@Qualifier("sale_dao")
	private SaleDAO test_dao_sale;
	
	@Autowired
	@Qualifier("payment_dao")
	private PaymentDAO test_dao_payment;
	
	
	protected void setUp() throws Exception {
		
		
	}
	
	@Test
	void testAddandGetInventory() throws DataSourceException, InventoryException, IOException {
		//ARRANGE
		Item item_01 = new Item();
		List<Item> item_01_list  = new ArrayList<Item>();
		
		
		String testFile = "src/test/Test_01";
		new FileWriter(testFile);
		
		
		test_dao_inventory = new InventoryDAOImpl(testFile);
		

		item_01.setSKU("ITM00TST");
		item_01.setItem_description("Test Item");
		item_01.setUnit_price(new BigDecimal("3.75").setScale(2,RoundingMode.UNNECESSARY));
		item_01.setIcon(new ImageIcon("src/main/resources/icons/itemDefault_icon.png"));
		item_01.getIcon().setDescription("itemDefault_icon.png");
		
		item_01_list.add(item_01);
		item_01_list.add(item_01);
		item_01_list.add(item_01);

		
		//ACT
		Inventory inventory = test_dao_inventory.addInventory(testFile);
		inventory = test_dao_inventory.getInventory();
		inventory.getInventory().put(item_01.getSKU(), item_01_list);
		Inventory inventory_retreived = test_dao_inventory.getInventory();
		
		
		//ASSERT
		assertNotNull(inventory_retreived,"The inevntory must not be null");
		assertEquals(inventory_retreived.getInventory().get(item_01.getSKU()),inventory.getInventory().get("ITM00TST"),"The inventory retreived should be the same as the inventory entered");

	}
	
	@Test
	void testUpdateInventory() throws IOException, DataSourceException, InventoryException {
		
		//ARRANGE
		String testFile = "src/test/Test_02";
		new FileWriter(testFile);
		
		
		test_dao_inventory = new InventoryDAOImpl(testFile);
		
		Item item_01 = new Item();
		List<Item> item_01_list  = new ArrayList<Item>();

		item_01.setSKU("ITM00TST");
		item_01.setItem_description("Test Item");
		item_01.setUnit_price(new BigDecimal("3.75").setScale(2,RoundingMode.UNNECESSARY));
		item_01.setIcon(new ImageIcon("src/main/resources/icons/itemDefault_icon.png"));
		item_01.getIcon().setDescription("itemDefault_icon.png");
		
		item_01_list.add(item_01);
		item_01_list.add(item_01);
		item_01_list.add(item_01);
		
		Inventory inventory = test_dao_inventory.addInventory(testFile);
		inventory = test_dao_inventory.getInventory();
		inventory.getInventory().put(item_01.getSKU(), item_01_list);
		
		//ASSERT
		assertTrue(inventory.getInventory().containsKey(item_01.getSKU()), "The should contain the element added");
		assertFalse(inventory.getInventory().containsKey("ITM00TST_02"), "The should not contain the element ITM00TST_02");
		
		//ARRAGNGE
		Item item_02 = new Item();
		List<Item> item_02_list  = new ArrayList<Item>();

		item_02.setSKU("ITM00TST_02");
		item_02.setItem_description("Test Item 02");
		item_02.setUnit_price(new BigDecimal("3.75").setScale(2,RoundingMode.UNNECESSARY));
		item_02.setIcon(new ImageIcon("src/main/resources/icons/itemDefault_icon.png"));
		item_02.getIcon().setDescription("itemDefault_icon.png");
		
		item_02_list.add(item_02);
		item_02_list.add(item_02);
		item_02_list.add(item_02);
		
		inventory.getInventory().put(item_02.getSKU(), item_02_list);
		
		
		//ACT
		test_dao_inventory.editInventory();
		inventory.getInventory().remove("ITMTE000JULY21");//removing auto generated Key
		
		//ASSERT
		assertTrue(inventory.getInventory().size() == 2, "The should contain the element added plus the previous element [0  and 1]");
		assertTrue(inventory.getInventory().containsKey("ITM00TST_02"), "The should not contain the element ITM00TST_02");
				
		
	}
	
	@Test
	void testAddandGetItem() throws IOException, DataSourceException, InventoryException {
		//ARRANGE
		String testFile = "src/test/Test_03";
		new FileWriter(testFile);
		
		
		test_dao_inventory = new InventoryDAOImpl(testFile);
		test_dao_item = new ItemDAOImpl();
		
		Item item_01 = new Item();
		List<Item> item_01_list  = new ArrayList<Item>();

		item_01.setSKU("ITM00TST");
		item_01.setItem_description("Test Item");
		item_01.setUnit_price(new BigDecimal("3.75").setScale(2,RoundingMode.UNNECESSARY));
		item_01.setIcon(new ImageIcon("src/main/resources/icons/itemDefault_icon.png"));
		item_01.getIcon().setDescription("itemDefault_icon.png");
		
		Inventory inventory = test_dao_inventory.addInventory(testFile);
		
		
		//ACT
		List<Item> item_added = test_dao_item.addItem(item_01, inventory, 5);
		
		//ACT & ASSERT
		assertFalse(item_added.isEmpty(),"The list of items must not be EMPTY");
		assertTrue(item_added.get(0).getSKU().equals("ITMTE000JULY21"),"SKU's should be the same");
		/*As per the following logic, the ID will be autogenerated 
		String SKU = "ITM"+//Prefix 
					item.getItem_description().substring(0,2).toUpperCase()+//Description piece
					"000"+//Zeros
					LocalDate.now().getMonth()+//Month
					(String.valueOf(LocalDate.now().getYear()).substring(2,4));//Year
		*/
		assertTrue(item_added.get(0).getItem_description().equals("Test Item"),"item description should be the same");
		assertEquals(item_added.get(0).getUnit_price(), new BigDecimal("3.75") ,"price should be the same");
		assertNotNull(test_dao_item.getItem(inventory, "ITMTE000JULY21"),"Retreiving item by SKU ");
		
	}
	
	
	@Test
	void testUpdateItem() throws IOException, DataSourceException, InventoryException {
		//ARRANGE
		String testFile = "src/test/Test_04";
		new FileWriter(testFile);
		
		
		test_dao_inventory = new InventoryDAOImpl(testFile);
		test_dao_item = new ItemDAOImpl();
		
		Item item_01 = new Item();

		item_01.setSKU("ITM00TST");
		item_01.setItem_description("Test Item");
		item_01.setUnit_price(new BigDecimal("3.75").setScale(2,RoundingMode.UNNECESSARY));
		item_01.setIcon(new ImageIcon("src/main/resources/icons/itemDefault_icon.png"));
		item_01.getIcon().setDescription("itemDefault_icon.png");
		
		Inventory inventory = test_dao_inventory.addInventory(testFile);
		
		List<Item> item_added = test_dao_item.addItem(item_01, inventory, 5);
		
		//ASSERT
		assertEquals(test_dao_item.getItem(inventory, "ITMTE000JULY21").get(0).getUnit_price(), new BigDecimal("3.75") ,"price should be the same");
		assertTrue(test_dao_item.getItem(inventory, "ITMTE000JULY21").get(0).getItem_description().equals("Test Item"),"item description should be the same");
		
		//ARRANGE
		Item item_02 = new Item();
		List<Item> item_02_list  = new ArrayList<Item>();

		item_02.setSKU("ITM00TST");
		item_02.setItem_description("Test Item UPDATED");
		item_02.setUnit_price(new BigDecimal("5.55").setScale(2,RoundingMode.UNNECESSARY));
		item_02.setIcon(new ImageIcon("src/main/resources/icons/itemDefault_icon.png"));
		item_02.getIcon().setDescription("itemDefault_icon.png");
		

		//ACT
		test_dao_item.editItem(inventory, "ITMTE000JULY21", item_02, 10);
		
		//ASSERT
		assertEquals(test_dao_item.getItem(inventory, "ITMTE000JULY21").get(0).getUnit_price(), new BigDecimal("5.55") ,"price should be the same as per last update");
		assertTrue(test_dao_item.getItem(inventory, "ITMTE000JULY21").get(0).getItem_description().equals("Test Item UPDATED"),"item description should be the same as per last update");
		
		
	}
	
	@Test
	void testEntrySale() throws IOException, DataSourceException, InventoryException {
		
		//ARRANGE
		String testFile = "src/test/Test_05";
		new FileWriter(testFile);
		
		
		test_dao_inventory = new InventoryDAOImpl(testFile);
		test_dao_item = new ItemDAOImpl();
		test_dao_sale = new SaleDAOImpl();
		
		Item item_01 = new Item();
		
		item_01.setSKU("ITM00TST");
		item_01.setItem_description("Test Item");
		item_01.setUnit_price(new BigDecimal("3.75").setScale(2,RoundingMode.UNNECESSARY));
		item_01.setIcon(new ImageIcon("src/main/resources/icons/itemDefault_icon.png"));
		item_01.getIcon().setDescription("itemDefault_icon.png");
		
		Inventory inventory = test_dao_inventory.addInventory(testFile);
		
		List<Item> item_added = test_dao_item.addItem(item_01, inventory, 5);
		
		//ASSERT
		assertEquals(test_dao_item.getItem(inventory, "ITMTE000JULY21").size(), 6 ,"quantities should be the entered + 1");
		
		
		//ACT 
		Sale sale_test = new Sale();
		sale_test.setSales_number("SLE0001");
		sale_test.setSales_date(LocalDate.now());
		sale_test.setSold_item(item_01);
		
		test_dao_sale.addSale(inventory, sale_test);
		test_dao_inventory.editInventory();
		
		//ASSERT
		assertEquals(test_dao_item.getItem(inventory, "ITMTE000JULY21").size(), 5 ,"quantities should be the previous value minus the sale (1)");
				
		
	}
	
	@Test
	void testGetChange() throws IOException, DataSourceException, InventoryException {
		
		//ARRANGE
		String testFile = "src/test/Test_06";
		new FileWriter(testFile);
		
		
		test_dao_inventory = new InventoryDAOImpl(testFile);
		test_dao_item = new ItemDAOImpl();
		test_dao_sale = new SaleDAOImpl();
		test_dao_payment = new PaymentDAOImpl();
		
		Item item_01 = new Item();
		
		item_01.setSKU("ITM00TST");
		item_01.setItem_description("Test Item");
		item_01.setUnit_price(new BigDecimal("3.68").setScale(2,RoundingMode.UNNECESSARY));
		item_01.setIcon(new ImageIcon("src/main/resources/icons/itemDefault_icon.png"));
		item_01.getIcon().setDescription("itemDefault_icon.png");
		
		Inventory inventory = test_dao_inventory.addInventory(testFile);
		
		List<Item> item_added = test_dao_item.addItem(item_01, inventory, 5);
		
		Sale sale_test = new Sale();
		sale_test.setSales_number("SLE0001");
		sale_test.setSales_date(LocalDate.now());
		sale_test.setSold_item(item_01);
		
		test_dao_sale.addSale(inventory, sale_test);
		test_dao_inventory.editInventory();
		
		
		//ACT 
		Map<String,BigDecimal> reminder  = test_dao_payment.getChange(new BigDecimal("5"), sale_test.getSold_item().getUnit_price());
		
		
		BigDecimal reminder_converted = reminder.get("DOLLARS").setScale(2, RoundingMode.UNNECESSARY)
				 .add(reminder.get("QUARTERS").multiply(new BigDecimal("0.25"))
				 .add(reminder.get("DIMES").multiply(new BigDecimal("0.10"))
				 .add(reminder.get("NICKELS").multiply(new BigDecimal("0.05"))
				 .add(reminder.get("PENNIES").multiply(new BigDecimal("0.01"))
					)//end pennies addition
					)//end nickels addition
					)//end dimes addition 
					);//end quarters addition
		
		
		//ASSERT
		assertEquals(reminder_converted, new BigDecimal("1.32") ,"The reminder should be the 1.32 [5(payment) - 3.68(item price)]");
		
		
		
	}

	
}
