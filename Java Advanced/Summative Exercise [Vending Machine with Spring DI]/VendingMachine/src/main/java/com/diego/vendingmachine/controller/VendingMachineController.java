package com.diego.vendingmachine.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.diego.vendingmachine.model.dao.DataSourceException;
import com.diego.vendingmachine.model.dao.InventoryException;
import com.diego.vendingmachine.model.dao.vendingMachinePersistenceException;
import com.diego.vendingmachine.model.dto.Inventory;
import com.diego.vendingmachine.model.dto.Item;
import com.diego.vendingmachine.model.dto.Sale;
import com.diego.vendingmachine.service.*;
import com.diego.vendingmachine.view.*;



@Component("controller")
public class VendingMachineController {

	@Autowired 
	@Qualifier("sale_service")
	private SaleService sale_service;
	
	@Autowired
	@Qualifier("item_service")
	private ItemService item_service;
	
	@Autowired
	@Qualifier("inventory_service")
	private InventoryService inventory_service;
	
	@Autowired
	@Qualifier("payment_service")
	private PaymentService payment_service;
	
	@Autowired
	@Qualifier("view")
	private vendingMachineView view;
	
	public void run() throws DataSourceException, InventoryException, InsufficientFundsException, vendingMachinePersistenceException {
		
		try {
		displayMenu();
		}catch(Exception e) {
			if(e.equals(NullPointerException.class)) {
				System.out.println("error");
				run();
			}
			
			
		}
		
	}
	
	
	public void displayMenu() throws DataSourceException, InventoryException, InsufficientFundsException, vendingMachinePersistenceException {
		
		Inventory inventory = inventory_service.retreiveInventory();
		/*
		List<Item> item_01_list = new ArrayList<Item>();
		
		Item item_01 = new Item();
		
		item_01.setSKU("ITM001");
		item_01.setItem_description("Lays");
		item_01.setUnit_price(new BigDecimal("3.75").setScale(2,RoundingMode.UNNECESSARY));
		item_01.setIcon(new ImageIcon("src/main/resources/icons/Lays_icon.png"));
		item_01.getIcon().setDescription("Lays_icon.png");
		
		item_01_list.add(item_01);
		item_01_list.add(item_01);
		item_01_list.add(item_01);
		item_01_list.add(item_01);
		item_01_list.add(item_01);
		item_01_list.add(item_01);
		item_01_list.add(item_01);
		
		//inventory.getInventory().put(item_01.getSKU(), item_01_list);
		item_service.createItem(item_01, inventory, 400);
		inventory_service.updateInventory();
		
		List<Item> item_02_list = new ArrayList<Item>();
		
		Item item_02 = new Item();
		
		item_02.setSKU("ITM002");
		item_02.setItem_description("Kit Kat");
		item_02.setUnit_price(new BigDecimal("1.67").setScale(2,RoundingMode.UNNECESSARY));
		item_02.setIcon(new ImageIcon("src/main/resources/icons/KitKat_icon.png"));
		item_02.getIcon().setDescription("KitKat_icon.png");
		
		item_02_list.add(item_02);
		item_02_list.add(item_02);
		item_02_list.add(item_02);
		item_02_list.add(item_02);
		item_02_list.add(item_02);
		item_02_list.add(item_02);
		item_02_list.add(item_02);
		
		//inventory.getInventory().put(item_02.getSKU(), item_02_list);
		item_service.createItem(item_02, inventory, 350);
		inventory_service.updateInventory();
		
		List<Item> item_03_list = new ArrayList<Item>();
		
		Item item_03 = new Item();
		
		item_03.setSKU("ITM003");
		item_03.setItem_description("M&M's");
		item_03.setUnit_price(new BigDecimal("2.34").setScale(2,RoundingMode.UNNECESSARY));
		item_03.setIcon(new ImageIcon("src/main/resources/icons/M&M_icon.png"));
		item_03.getIcon().setDescription("M&M_icon.png");
		
		item_03_list.add(item_03);
		item_03_list.add(item_03);
		item_03_list.add(item_03);
		item_03_list.add(item_03);
		item_03_list.add(item_03);
		item_03_list.add(item_03);
		item_03_list.add(item_03);
		
		//inventory.getInventory().put(item_03.getSKU(), item_03_list);
		item_service.createItem(item_03, inventory, 250);
		inventory_service.updateInventory();
		
		List<Item> item_04_list = new ArrayList<Item>();
		
		Item item_04 = new Item();
		
		item_04.setSKU("ITM004");
		item_04.setItem_description("Snickers");
		item_04.setUnit_price(new BigDecimal("3.28").setScale(2,RoundingMode.UNNECESSARY));
		item_04.setIcon(new ImageIcon("src/main/resources/icons/Snickers_icon.png"));
		item_04.getIcon().setDescription("Snickers_icon.png");
		
		item_04_list.add(item_04);
		item_04_list.add(item_04);
		item_04_list.add(item_04);
		item_04_list.add(item_04);
		item_04_list.add(item_04);
		item_04_list.add(item_04);
		item_04_list.add(item_04);
		
		//inventory.getInventory().put(item_04.getSKU(), item_04_list);
		item_service.createItem(item_04, inventory, 400);
		inventory_service.updateInventory();
		
		List<Item> item_05_list = new ArrayList<Item>();
		
		Item item_05 = new Item();
		
		item_05.setSKU("ITM005");
		item_05.setItem_description("Trident Gum");
		item_05.setUnit_price(new BigDecimal("1.15").setScale(2,RoundingMode.UNNECESSARY));
		item_05.setIcon(new ImageIcon("src/main/resources/icons/Trident_icon.png"));
		item_05.getIcon().setDescription("Trident_icon.png");
		
		item_05_list.add(item_05);
		item_05_list.add(item_05);
		item_05_list.add(item_05);
		item_05_list.add(item_05);
		item_05_list.add(item_05);
		item_05_list.add(item_05);
		item_05_list.add(item_05);
		
		//inventory.getInventory().put(item_05.getSKU(), item_05_list);
		item_service.createItem(item_05, inventory, 380);
		inventory_service.updateInventory();
		
		
		List<Item> item_06_list = new ArrayList<Item>();
		
		Item item_06 = new Item();
		
		item_06.setSKU("ITM006");
		item_06.setItem_description("Naya Water");
		item_06.setUnit_price(new BigDecimal("2.10").setScale(2,RoundingMode.UNNECESSARY));
		item_06.setIcon(new ImageIcon("src/main/resources/icons/waterBottle_icon.png"));
		item_06.getIcon().setDescription("waterBottle_icon.png");
		
		item_06_list.add(item_06);
		item_06_list.add(item_06);
		item_06_list.add(item_06);
		item_06_list.add(item_06);
		item_06_list.add(item_06);
		item_06_list.add(item_06);
		item_06_list.add(item_06);
		
		//inventory.getInventory().put(item_06.getSKU(), item_06_list);
		item_service.createItem(item_06, inventory, 390);
		inventory_service.updateInventory();
		
		*/
		
		
		BigDecimal payment = null;
		Sale sale;
		if(inventory.getInventory().isEmpty()) {
			int result_out_stock = view.printOutOfStock();
			
			if(result_out_stock == 1) {
				run();
			}
			
		}
		Item item_selected = view.displayMultipleObjects("Available items", "Vending Machine", inventory);
		if(item_selected != null) {
			String user_entry_pymnt = view.readString("Item",item_selected.toString(), item_selected.getIcon());
			Pattern pattern = Pattern.compile("[0-999]");
		    Matcher matcher = pattern.matcher(user_entry_pymnt);
		    System.out.println("Result"+ user_entry_pymnt);
		    if(user_entry_pymnt == null) {
		    	run();
		    }
			while(user_entry_pymnt.equals("") || !matcher.find()) {
				user_entry_pymnt = view.readString("Item",item_selected.toString() + "\nPLEASE ENTER A NUMBER", item_selected.getIcon());
				pattern = Pattern.compile("[0-999]");
			    matcher = pattern.matcher(user_entry_pymnt);
			    if(user_entry_pymnt == null) {
			    	run();
			    }
			}
			try {
			payment = new BigDecimal(user_entry_pymnt).setScale(2,RoundingMode.HALF_UP);
			Map <String,BigDecimal> change = payment_service.receivePayment(payment, item_selected.getUnit_price());
			if(change == null) {
				BigDecimal refund = payment_service.refundCustomer(payment);
				int result_no_funds = view.print("Vending Machine", "Insufficient Funds..." + "\n"+ refund.toString() + "$ has be refunded", new ImageIcon("src/main/resources/icons/InsufficientFunds_icon.png"));
				if(result_no_funds == 0) {
					run();
				}
			
			}
			sale = new Sale();
			sale.setSales_date(LocalDate.now());
			sale.setSold_item(item_selected);
			sale_service.entrySale(inventory, sale);
			int result_sale = view.print("Sale", "Thanks!!!\nHere is your change is :\n" 
																+ "Dollars: " + change.get("DOLLARS") + " [1$]\n"
																+ "Quarters: " + change.get("QUARTERS") + " [25¢]\n"
																+ "Dimes: " + change.get("DIMES") + " [10¢]\n"
																+ "Nickels: " + change.get("NICKELS") + " [5¢]\n"
																+ "Pennies: " + change.get("PENNIES") + " [1¢]"
																,sale.getSold_item().getIcon());
			
			
			inventory_service.updateInventory();
			if(result_sale == 0) {
				run();
			}
			
			}catch(Exception e) {
				if(e.equals(InsufficientFundsException.class)) {
					view.readInt("Insufficient Funds", e.getCause().toString());
					BigDecimal refund = payment_service.refundCustomer(payment);
					view.readString("Refund", refund.toString() + "$ has be refunded");
				}else if(e.equals(NullPointerException.class)) {
					run();
				}
				
				
			}
		
		}
	}
	
	
}
