package com.diego.vendingmachine;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.diego.vendingmachine.controller.VendingMachineController;
import com.diego.vendingmachine.model.dao.DataSourceException;
import com.diego.vendingmachine.model.dao.InventoryException;
import com.diego.vendingmachine.model.dao.vendingMachinePersistenceException;
import com.diego.vendingmachine.service.InsufficientFundsException;

public class App 
{
	public static void main(String[] a) throws DataSourceException, InventoryException, InsufficientFundsException, vendingMachinePersistenceException {



		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.diego.vendingmachine");
        appContext.refresh();

        VendingMachineController controller = appContext.getBean("controller", VendingMachineController.class);
        controller.run();
	
	}
	
}
