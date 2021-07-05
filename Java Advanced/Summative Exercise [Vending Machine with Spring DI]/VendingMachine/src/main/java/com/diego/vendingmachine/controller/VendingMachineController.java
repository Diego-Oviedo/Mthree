package com.diego.vendingmachine.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
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

	public void run() throws DataSourceException, 
							 InventoryException, 
							 InsufficientFundsException,
							 vendingMachinePersistenceException {

		try {
			Item item_selected = displayMenu();
			BigDecimal payment = takePayment(item_selected);
			entryASale(item_selected,payment);
			
		} catch (Exception e) {
			if (e.equals(DataSourceException.class)) {
				run();
				throw new DataSourceException(e.getMessage().toString(),e.getCause());	
			} else if (e.equals(InventoryException.class)) {
				run();
				throw new InventoryException(e.getMessage().toString(),e.getCause());
			} else if (e.equals(InsufficientFundsException.class)) {
				run();
				throw new InsufficientFundsException(e.getMessage().toString(),e.getCause());
			} else if (e.equals(vendingMachinePersistenceException.class)) {
				run();
				throw new vendingMachinePersistenceException(e.getMessage().toString(),e.getCause());
			}else {
				int exception_result;
				exception_result = view.print("Error", e.getCause().toString() + "\n" + e.getMessage().toString());
				if (exception_result == 1) {
					run();
				}
			}
		}

	}

	public Item displayMenu() throws DataSourceException, 
									 InventoryException, 
									 InsufficientFundsException,
									 vendingMachinePersistenceException {

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
	
	public BigDecimal takePayment(Item item_selected) {
		BigDecimal payment = null;
		payment = view.printReceivePayment(item_selected);
		return payment;	
	}
	
	public void entryASale(Item item_selected,BigDecimal payment) throws DataSourceException, 
																		 InventoryException,
																		 InsufficientFundsException, 
																		 vendingMachinePersistenceException {
		Inventory inventory = inventory_service.retreiveInventory();
		
		if (item_selected != null) {

			while (payment == null) {
				
				payment = takePayment(item_selected);
			}
			try {

				Sale sale = null;
				
				Map<String, BigDecimal> change = payment_service.receivePayment(payment, item_selected.getUnit_price());
				
				if (change == null) {
					BigDecimal refund = payment_service.refundCustomer(payment);
					int result_no_funds = view.printRefund(refund,item_selected);
					if (result_no_funds == 0) {
						run();
					}
				}
				sale = new Sale();
				sale.setSales_date(LocalDate.now());
				sale.setSold_item(item_selected);
				sale_service.entrySale(inventory, sale);
				
				int result_sale = view.printCloseSale(sale,change);

				inventory_service.updateInventory();
				if (result_sale == 0) {
					run();
				}

			} catch (Exception e) {
				
				if (e.equals(DataSourceException.class)) {
					run();
					throw new DataSourceException(e.getMessage().toString(),e.getCause());	
				} else if (e.equals(InventoryException.class)) {
					run();
					throw new InventoryException(e.getMessage().toString(),e.getCause());
				} else if (e.equals(InsufficientFundsException.class)) {
					run();
					throw new InsufficientFundsException(e.getMessage().toString(),e.getCause());
				} else if (e.equals(vendingMachinePersistenceException.class)) {
					run();
					throw new vendingMachinePersistenceException(e.getMessage().toString(),e.getCause());
				}else {
					int exception_result;
					exception_result = view.print("Error", e.getCause().toString() + "\n" + e.getMessage().toString());
					if (exception_result == 1) {
						run();
					}
				}
			}
		}

	}

}
