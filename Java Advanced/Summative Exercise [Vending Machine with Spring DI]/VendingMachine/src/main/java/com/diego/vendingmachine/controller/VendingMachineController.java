package com.diego.vendingmachine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.diego.vendingmachine.service.*;



@Component("contoller")
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
	
	
	
	
	
}
