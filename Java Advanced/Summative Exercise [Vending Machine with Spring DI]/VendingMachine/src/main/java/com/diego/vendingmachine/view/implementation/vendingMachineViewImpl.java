package com.diego.vendingmachine.view.implementation;

import com.diego.vendingmachine.model.dto.Inventory;
import com.diego.vendingmachine.model.dto.Item;
import com.diego.vendingmachine.view.vendingMachineView;
import java.util.*;

import javax.swing.*;

import org.springframework.stereotype.Component;

@Component("view")
public class vendingMachineViewImpl implements vendingMachineView {

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
	
	public int printOutOfStock() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(frame, "There is no items availables", "Vending Machine", JOptionPane.OK_OPTION,new ImageIcon("src/main/resources/icons/outOfStock_icon.png"));
	
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
		input = JOptionPane.showInputDialog(frame, prompt, label, JOptionPane.PLAIN_MESSAGE,icon,  null, "").toString();
		
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
		String input = null;
		input = JOptionPane.showInputDialog(frame, prompt,label);
	    if(input.equals("-1")) {
	    	System.exit(0);
	    }
		return input;
	}

	public Item displayMultipleObjects(String prompt, String label, Inventory inventory) {
		JFrame frame = new JFrame();

		Object [] array_icons = new Object [(inventory.getInventory().size()+1)];
		Item [] array_items = new Item [(inventory.getInventory().size()+1)];
		int counter = 1;
		
		array_icons[0] = "Exit";
		array_items[0] = null;
		
		Set<String> keys = inventory.getInventory().keySet();
		
		for (String key : keys) {
			
			List<Item> item = inventory.getInventory().get(key);
			
			if(!item.isEmpty()) {
				
				array_icons[counter] = item.get(0).getIcon();
				array_items[counter] = item.get(0);
			}
			
			counter++;
		}
		
		int input = JOptionPane.showOptionDialog(frame, prompt, label,
		        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.YES_NO_CANCEL_OPTION, null, array_icons,
		        array_icons[0]);
		
		 if(input == -1 || input == 0) {
		    	System.exit(0);
		    }
		 
		 Item item_selected = array_items[input];
		
		return item_selected;
	}
	
	
	

}
