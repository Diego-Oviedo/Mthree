package com.diego.vendingmachine.view.implementation;

import com.diego.vendingmachine.model.dto.Inventory;
import com.diego.vendingmachine.model.dto.Item;
import com.diego.vendingmachine.view.vendingMachineView;
import java.util.*;

import javax.swing.*;

public class vendingMachineViewImpl implements vendingMachineView {

	public void print(String label, String msg) {
		JFrame frame = new JFrame();

	    JOptionPane.showMessageDialog(frame, msg);

	}

	public int readInt(String label, String prompt) {
		JFrame frame = new JFrame();
	    int input = Integer.parseInt(JOptionPane.showInputDialog(frame, prompt, label));
		return input;
	}
	
	public int readInt(String label, String prompt, ImageIcon icon) {
		JFrame frame = new JFrame();
	    int input = Integer.parseInt(JOptionPane.showInputDialog(frame, prompt, label, JOptionPane.PLAIN_MESSAGE,icon,  null, "").toString());
		return input;
	}

	public int readInt(String label, String prompt, int min, int max) {
		JFrame frame = new JFrame();
	    int input = Integer.parseInt(JOptionPane.showInputDialog(frame, prompt, label));
	    if(input > min || input < max) {
	    	input = Integer.parseInt(JOptionPane.showInputDialog(frame, "Please provide a number between " + min + " and " + max , "Entry error",
	    	        JOptionPane.WARNING_MESSAGE));
	    }

		return input;
	}

	public String readString(String label, String prompt) {
		JFrame frame = new JFrame();
	    String input = JOptionPane.showInputDialog(frame, prompt,label);
		return input;
	}

	public Item displayMultipleObjects(String prompt, String label, Inventory inventory) {
		JFrame frame = new JFrame();

		Object [] array_icons = new Object [(inventory.getInventory().size()+1)];
		Item [] array_items = new Item [(inventory.getInventory().size()+1)];
		int counter = 1;
		
		array_icons[0] = "Cancel";
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
