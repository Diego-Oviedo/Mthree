package com.diego.vendingmachine;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.diego.vendingmachine.controller.*;
import com.diego.vendingmachine.model.dao.*;
import com.diego.vendingmachine.service.*;

public class App 
{
	public static void main(String[] a) throws DataSourceException, 
											   InventoryException, 
											   InsufficientFundsException, 
											   vendingMachinePersistenceException, 
											   NoItemInventoryException {



		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.diego.vendingmachine");
        appContext.refresh();

        VendingMachineController controller = appContext.getBean("controller", VendingMachineController.class);
        controller.run();
	
	}
	
}
