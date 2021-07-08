package com.diego.vendingmachine.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

	@SuppressWarnings("unlikely-arg-type")
	public void run() throws DataSourceException, InventoryException, InsufficientFundsException,
			vendingMachinePersistenceException, NoItemInventoryException {

		try {
			Item item_selected = displayMenu();
			BigDecimal payment = takePayment(item_selected);
			entryASale(item_selected, payment);
		} catch (Exception e) {
			if (e.getClass().equals(DataSourceException.class)) {
				run();
				throw e; //new DataSourceException(e.getMessage(), e.getCause());
			} else if (e.getClass().equals(InventoryException.class)) {
				run();
				throw new InventoryException(e.getMessage(), e.getCause());
			} else if (e.getClass().equals(InsufficientFundsException.class)) {
				run();
				throw new InsufficientFundsException(e.getMessage(), e.getCause());
			} else if (e.getClass().equals(vendingMachinePersistenceException.class)) {
				run();
				throw new vendingMachinePersistenceException(e.getMessage(), e.getCause());
			} else if (e.getClass().equals(NullPointerException.class)) {
				run();
			} else {
				int exception_result; 
				exception_result = view.print("Error", e.getClass() + "");
				if (exception_result == 0) {
					run();
				}
			}
		} 

	}

	public Item displayMenu() throws DataSourceException, InventoryException, InsufficientFundsException,
			vendingMachinePersistenceException, NoItemInventoryException {

		Inventory inventory = inventory_service.retreiveInventory(); 

		if (inventory.getInventory().isEmpty()) {
			int result_out_stock = view.printOutOfStock();

			if (result_out_stock == 1) {
				run();
			}

		}
		Item item_selected = view.displayStock(inventory);

		return item_selected;
	}

	public BigDecimal takePayment(Item item_selected) throws DataSourceException, InventoryException,
			InsufficientFundsException, vendingMachinePersistenceException, NoItemInventoryException {
		BigDecimal payment = null;
		payment = view.printReceivePayment(item_selected);
		if (payment == null) {
			run();
		}

		return payment;
	}

	public void entryASale(Item item_selected, BigDecimal payment) throws DataSourceException, InventoryException,
			InsufficientFundsException, vendingMachinePersistenceException, NoItemInventoryException {
		Inventory inventory = inventory_service.retreiveInventory();

		if (item_selected != null) {

			while (payment == null) {

				payment = takePayment(item_selected);
			}

			Sale sale = null;

			Map<String, BigDecimal> change = payment_service.receivePayment(payment, item_selected.getUnit_price());

			if (change == null) {
				BigDecimal refund = payment_service.refundCustomer(payment);
				int result_no_funds = view.printRefund(refund, item_selected);
				if (result_no_funds == 0) {
					run();
				}
			}
			sale = new Sale();
			sale.setSales_date(LocalDate.now());
			sale.setSold_item(item_selected);
			sale_service.entrySale(inventory, sale);

			int result_sale = view.printCloseSale(sale, change);

			inventory_service.updateInventory();
			if (result_sale == 0) {
				run();
			}

		}

	}

}
























/*
 * List<Item> item_01_list = new ArrayList<Item>();
 * 
 * Item item_01 = new Item();
 * 
 * item_01.setSKU("ITM001"); item_01.setItem_description("Lays");
 * item_01.setUnit_price(new
 * BigDecimal("3.75").setScale(2,RoundingMode.UNNECESSARY)); item_01.setIcon(new
 * ImageIcon("src/main/resources/icons/Lays_icon.png"));
 * item_01.getIcon().setDescription("Lays_icon.png");
 * 
 * //inventory.getInventory().put(item_01.getSKU(), item_01_list);
 * item_service.createItem(item_01, inventory, 15);
 * inventory_service.updateInventory();
 * 
 * List<Item> item_02_list = new ArrayList<Item>();
 * 
 * Item item_02 = new Item();
 * 
 * item_02.setSKU("ITM002"); item_02.setItem_description("Kit Kat");
 * item_02.setUnit_price(new
 * BigDecimal("1.67").setScale(2,RoundingMode.UNNECESSARY)); item_02.setIcon(new
 * ImageIcon("src/main/resources/icons/KitKat_icon.png"));
 * item_02.getIcon().setDescription("KitKat_icon.png");
 * 
 * //inventory.getInventory().put(item_02.getSKU(), item_02_list);
 * item_service.createItem(item_02, inventory, 15);
 * inventory_service.updateInventory();
 * 
 * List<Item> item_03_list = new ArrayList<Item>();
 * 
 * Item item_03 = new Item();
 * 
 * item_03.setSKU("ITM003"); item_03.setItem_description("M&M's");
 * item_03.setUnit_price(new
 * BigDecimal("2.34").setScale(2,RoundingMode.UNNECESSARY)); item_03.setIcon(new
 * ImageIcon("src/main/resources/icons/M&M_icon.png"));
 * item_03.getIcon().setDescription("M&M_icon.png");
 * 
 * //inventory.getInventory().put(item_03.getSKU(), item_03_list);
 * item_service.createItem(item_03, inventory, 15);
 * inventory_service.updateInventory();
 * 
 * List<Item> item_04_list = new ArrayList<Item>();
 * 
 * Item item_04 = new Item();
 * 
 * item_04.setSKU("ITM004"); item_04.setItem_description("Snickers");
 * item_04.setUnit_price(new
 * BigDecimal("3.28").setScale(2,RoundingMode.UNNECESSARY)); item_04.setIcon(new
 * ImageIcon("src/main/resources/icons/Snickers_icon.png"));
 * item_04.getIcon().setDescription("Snickers_icon.png");
 * 
 * //inventory.getInventory().put(item_04.getSKU(), item_04_list);
 * item_service.createItem(item_04, inventory, 15);
 * inventory_service.updateInventory();
 * 
 * List<Item> item_05_list = new ArrayList<Item>();
 * 
 * Item item_05 = new Item();
 * 
 * item_05.setSKU("ITM005"); item_05.setItem_description("Trident Gum");
 * item_05.setUnit_price(new
 * BigDecimal("1.15").setScale(2,RoundingMode.UNNECESSARY)); item_05.setIcon(new
 * ImageIcon("src/main/resources/icons/Trident_icon.png"));
 * item_05.getIcon().setDescription("Trident_icon.png");
 * 
 * //inventory.getInventory().put(item_05.getSKU(), item_05_list);
 * item_service.createItem(item_05, inventory, 15);
 * inventory_service.updateInventory();
 * 
 * 
 * List<Item> item_06_list = new ArrayList<Item>();
 * 
 * Item item_06 = new Item();
 * 
 * item_06.setSKU("ITM006"); item_06.setItem_description("Naya Water");
 * item_06.setUnit_price(new
 * BigDecimal("2.10").setScale(2,RoundingMode.UNNECESSARY)); item_06.setIcon(new
 * ImageIcon("src/main/resources/icons/waterBottle_icon.png"));
 * item_06.getIcon().setDescription("waterBottle_icon.png");
 * 
 * //inventory.getInventory().put(item_06.getSKU(), item_06_list);
 * item_service.createItem(item_06, inventory, 15);
 * inventory_service.updateInventory();
 * 
 */

