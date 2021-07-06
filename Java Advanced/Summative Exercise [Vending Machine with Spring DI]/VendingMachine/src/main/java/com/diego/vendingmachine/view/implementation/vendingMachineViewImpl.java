package com.diego.vendingmachine.view.implementation;

import com.diego.vendingmachine.model.dto.Inventory;
import com.diego.vendingmachine.model.dto.Item;
import com.diego.vendingmachine.model.dto.Sale;
import com.diego.vendingmachine.view.vendingMachineView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import org.springframework.stereotype.Component;

@Component("view")
public class vendingMachineViewImpl implements vendingMachineView {

	public Item displayStock(Inventory inventory) {
		JFrame frame = new JFrame();
		Item item_selected = null;
		//Object [] array_icons = new Object [(inventory.getInventory().size()+1)];
		//Item [] array_items = new Item [(inventory.getInventory().size()+1)];
		ArrayList <Object> array_icons_toList = new ArrayList<Object>();
		ArrayList <Item> array_items_toList = new ArrayList<Item>();
		
		
		int counter = 1;
		
		//array_icons[0] = "Exit";
		array_icons_toList.add("Exit");
		//array_items[0] = null;
		array_items_toList.add(new Item());
		
		Set<String> keys = inventory.getInventory().keySet();
		
		for (String key : keys) {
			
			if(inventory.getInventory().get(key) != null) {
			
			List<Item> item = inventory.getInventory().get(key);
			
			if(!item.isEmpty() || item.size() > 0) {
				
				//array_icons[counter] = item.get(0).getIcon();
				array_icons_toList.add(item.get(0).getIcon());
				//array_items[counter] = item.get(0);
				array_items_toList.add(item.get(0));
			}
			}
			counter++;
		}
		
		Object [] array_icons = array_icons_toList.toArray();
		Item[] array_items = new Item [(array_items_toList.size()+1)];
		
		counter = 0;
		for(Item item : array_items_toList) {
			array_items[counter] = item;
			counter++;
		}
		
			int input = JOptionPane.showOptionDialog(frame, "Available items", "Vending Machine",
		        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.YES_NO_CANCEL_OPTION, null, array_icons,
		        array_icons[0]);
		
			if(input == -1 || input == 0) {
		    	System.exit(0);
		    }		 
			
		 item_selected = array_items[input];
		 
		return item_selected;
	}
	
	public int printOutOfStock() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(frame, "There is no items availables", "Vending Machine", JOptionPane.OK_OPTION,new ImageIcon("src/main/resources/icons/outOfStock_icon.png"));
	
		int result = JOptionPane.OK_OPTION;
	    return result;
	}
	
	public BigDecimal printReceivePayment(Item item_selected) {
		BigDecimal payment = null;
		
		String user_entry_pymnt = readString("Item",
				item_selected.toString() + "\n\nPlease insert the money and click OK", item_selected.getIcon());
		Pattern pattern = Pattern.compile("[0-999]");
		Matcher matcher = pattern.matcher(user_entry_pymnt);
		if (user_entry_pymnt == null || user_entry_pymnt.equals("-2")) {
			payment = null;
		}
		while (user_entry_pymnt.equals("") || !matcher.find()) {
			user_entry_pymnt = readString("Item",
					item_selected.toString() + "\n\nPLEASE ENTER VALID AMOUNT (e.g. 3.50)",
					item_selected.getIcon());
			pattern = Pattern.compile("[0-999]");
			matcher = pattern.matcher(user_entry_pymnt);
			if (user_entry_pymnt == null) {
				payment = null;
			}
		}
		
		payment = new BigDecimal(user_entry_pymnt).setScale(2,RoundingMode.HALF_UP);

		return payment;
	}
	
	public int printRefund(BigDecimal refund, Item item_selected) {
		int result = print("Vending Machine",
				"Insufficient Funds..." + "\n" + refund.toString() + "$ has be refunded"
						+ "\n\nThe selected item price is: " + item_selected.getUnit_price(),
				new ImageIcon("src/main/resources/icons/InsufficientFunds_icon.png"));
		return result;
	}
	
	public int printCloseSale(Sale sale, Map<String, BigDecimal> change) {
		int result = print("Sale",
				"Thanks!!!"
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
						+ "Pennies: " + change.get("PENNIES") + " [1¢]",
				sale.getSold_item().getIcon());
		return result;
	}
		
	public int print(String label, String msg) {
		JFrame frame = new JFrame();
	    JOptionPane.showMessageDialog(frame, msg, label, JOptionPane.OK_OPTION);
	    
	    int result = JOptionPane.OK_OPTION;
	    return result;
	}
	
	public int print(String label, String msg, ImageIcon icon) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(frame, msg, label, JOptionPane.OK_OPTION,icon);
		
		int result = JOptionPane.OK_OPTION;
	    return result;
	}

	public int readInt(String label, String prompt) {
		JFrame frame = new JFrame();
	    int input = Integer.parseInt(JOptionPane.showInputDialog(frame, prompt, label));
	    if(input == -1) {
	    	System.exit(0);
	    }
	    
	    return input;
	}
	
	public String readString(String label, String prompt, ImageIcon icon) {
		JFrame frame = new JFrame();
		String input = null;
		input = JOptionPane.showInputDialog(frame, prompt, label, JOptionPane.CANCEL_OPTION,icon,  null, "").toString();

		if(input.equals("-1")) {
	    	System.exit(0);
	    }
		
		return input;
	}

	public int readInt(String label, String prompt, int min, int max) {
		JFrame frame = new JFrame();
	    int input = Integer.parseInt(JOptionPane.showInputDialog(frame, prompt, label));
	    if(input > min || input < max) {
	    	input = Integer.parseInt(JOptionPane.showInputDialog(frame, "Please provide a number between " + min + " and " + max , "Entry error",
	    	        JOptionPane.WARNING_MESSAGE));
	    }
	    if(input == -1) {
	    	System.exit(0);
	    }

		return input;
	}

	public String readString(String label, String prompt) {
		JFrame frame = new JFrame();
	    String input = JOptionPane.showInputDialog(frame, prompt,label);
	    if(input.equals("-1")) {
	    	System.exit(0);
	    }
		return input;
	}

	


}
