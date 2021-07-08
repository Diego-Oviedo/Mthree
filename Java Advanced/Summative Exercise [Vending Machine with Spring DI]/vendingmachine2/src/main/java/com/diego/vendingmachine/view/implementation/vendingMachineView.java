package com.diego.vendingmachine.view.implementation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diego.vendingmachine.dto.Item;
import com.diego.vendingmachine.view.InvalidEntryException;
import com.diego.vendingmachine.view.UserIO;

@Component("view")
public class vendingMachineView {
	
	@Autowired
	private UserIO io;
	
	public void displayVendingMachineBanner() {
        io.print("=== Vending Machine ===");
    }
	
	public Item displayVendingMachineStock(List<Item> items) throws InvalidEntryException {
        
        int counter = 1 ;
        for(Item item : items) {
        	io.print(counter + ". " + item.toString());
        	counter++;
        }
        int choice = 0;
        try {
        choice = io.readInt("Please select an item.", 1, (items.size() + 1));
        }catch(InputMismatchException e) {
        	throw new InvalidEntryException("Inavlid value putted [View Layer]");
        }
        
        Item item_selected = items.get((choice - 1));
        
        return item_selected;
    }
	
	public void displayVendingMachineOutOfStockBanner() {
        io.print("=== Items out of stock ===");
    }

	public void displayItemOutOfStockBanner() {
        io.print("-> Item out of stock");
    }
	
	public void displaySaleBanner() {
        io.print("=== Sale ===");
    }

	public BigDecimal displayTakePayment() throws InvalidEntryException {
		BigDecimal payment = null;
		try {
        payment = io.readBigDecimal("Please insert the money and hit enter");
		}catch(InputMismatchException e) {
        	throw new InvalidEntryException("Inavlid value putted [View Layer]");
        }catch(NumberFormatException e) {
        	throw new InvalidEntryException("Inavlid value putted [View Layer]");
        }
		
		return payment;
    }
	
	public void displayChange(Map<String, BigDecimal> change) {
        io.print("Thanks!!!"
				+ "\nHere is your change : " 
				+ "$"+ change.get("DOLLARS").setScale(2, RoundingMode.UNNECESSARY)
						 .add(change.get("QUARTERS").multiply(new BigDecimal("0.25"))
						 .add(change.get("DIMES").multiply(new BigDecimal("0.10"))
						 .add(change.get("NICKELS").multiply(new BigDecimal("0.05"))
						 .add(change.get("PENNIES").multiply(new BigDecimal("0.01"))
							)//end pennies addition
							)//end nickels addition
							)//end dimes addition 
							)//end quarters addition
						 +"\n"					
				+ "Dollars: " + change.get("DOLLARS") + " [1$]\n"
				+ "Quarters: " + change.get("QUARTERS") + " [25¢]\n" 
				+ "Dimes: " + change.get("DIMES")+ " [10¢]\n"
				+ "Nickels: " + change.get("NICKELS") + " [5¢]\n" 
				+ "Pennies: " + change.get("PENNIES") + " [1¢]");
    }
	
	public void displayInsufficientFunds(BigDecimal item_price) {
        io.print("=== Insufficient Funds ===\n");
        io.print("The selected item cost: " + item_price);
    }
	
	public void displayRefund(BigDecimal payment) {

        io.print("$ " + payment + " refunded");
    }
	
	public void displayError(String message) {

        io.print("Error: " + message);
    }
	
	public String displayContinueQuestion(String message) {

        return io.readString(message);
    }
	
	public void displayItemSelected(Item item) {

         io.print("Item selected {"+item.toString()+"}");
    }
	
	public void displayGoodByeMessage() {

        io.print("Thanks for using the system. Bye now.");
   }
	
}
