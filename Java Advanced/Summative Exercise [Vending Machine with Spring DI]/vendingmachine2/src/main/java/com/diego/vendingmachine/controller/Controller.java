package com.diego.vendingmachine.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diego.vendingmachine.dao.DataSourceException;
import com.diego.vendingmachine.dao.InventoryException;
import com.diego.vendingmachine.dao.vendingMachinePersistenceException;
import com.diego.vendingmachine.dto.Item;
import com.diego.vendingmachine.service.*;
import com.diego.vendingmachine.view.InvalidEntryException;
import com.diego.vendingmachine.view.implementation.*;

@Component("controller")
public class Controller {
	
	@Autowired
	private vendingMachineView view;
	
	@Autowired
	private ItemService item_service;
	
	@Autowired
	private PaymentService payment_service;
	
	@Autowired
	private SaleService sale_service;

	
	public void run(){
		String response = null;
		do {
			displayStock();
			response = view.displayContinueQuestion("\nwant to exit? (y/n)");
		
		}while (!response.equalsIgnoreCase("y"));
		
		view.displayGoodByeMessage();
	}
	
	public void displayStock() {
		
		List<Item> inventory= null;
		try {
			inventory = item_service.retreiveAllItems();
		} catch (DataSourceException e) {
			view.displayError(e.getMessage());
			System.exit(0);
		} catch (InventoryException e) {
			view.displayError(e.getMessage());
			System.exit(0);
		}
		
		view.displayVendingMachineBanner();
		Item item = null;
		try {
			item = view.displayVendingMachineStock(inventory);
		} catch (InvalidEntryException e) {
			view.displayError(e.getMessage());
			try {
				item = view.displayVendingMachineStock(inventory);
			} catch (InvalidEntryException e1) {
				view.displayError(e.getMessage());
				System.exit(0);
			}
		}
		if(item == null) {
			view.displayVendingMachineOutOfStockBanner();
			view.displayItemSelected(item);
			view.displayItemOutOfStockBanner();
		}
		view.displaySaleBanner();
		view.displayItemSelected(item);
		BigDecimal payment = null;
		Map<String, BigDecimal> change = null;
		try {
			payment = view.displayTakePayment();
		} catch (InvalidEntryException e) {
			view.displayError(e.getMessage());
			try {
				payment = view.displayTakePayment();
			} catch (InvalidEntryException e1) {
				view.displayError(e.getMessage());
				System.exit(0);
			}
		}
		if(item != null) {
			try {
			change = payment_service.receivePayment(payment, item.getUnit_price());
			} catch (InsufficientFundsException e) {
				view.displayInsufficientFunds(item.getUnit_price());
				BigDecimal refund = payment_service.refundCustomer(payment);
				view.displayRefund(refund);
			}
			if (change != null) {
				
				try {
					sale_service.entrySale(item);
				} catch (NoItemInventoryException e) {
					view.displayError(e.getMessage());
					System.exit(0);
				} catch (vendingMachinePersistenceException e) {
					view.displayError(e.getMessage());
					System.exit(0);
				} catch (DataSourceException e) {
					view.displayError(e.getMessage());
					System.exit(0);
				} catch (InventoryException e) {
					view.displayError(e.getMessage());
					System.exit(0);
				}	
			view.displayChange(change);
			}
		}
		
	}
}
