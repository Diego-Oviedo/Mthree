package com.diego.vendingmachine;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.*;

import com.diego.vendingmachine.model.dto.*;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] a) {
	    /*JFrame frame = new JFrame();

	    ImageIcon blueIcon = new ImageIcon("src/main/resources/802590-200.png");
	  
	    
	    blueIcon.setDescription("Hello world");
	    
	    Object stringArray[] = {"Cancel",blueIcon, blueIcon , blueIcon,blueIcon,blueIcon,blueIcon,blueIcon};
	  
	    
	    
	    int text = JOptionPane.showOptionDialog(frame, "Continue printing?", "Select an Option",
	        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.YES_NO_CANCEL_OPTION, null, stringArray,
	        stringArray[0]);
	     
	    if(text == 0) {
	    	System.exit(0);
	    }
	    
	   
	    Class<? extends Object> test = stringArray[text].getClass();
	    
	    System.out.println(test.toString());
	     
	    
	    JOptionPane.showInputDialog(null, stringArray[text],"Please inster your money");
	    */
		
		Map<String,List<Item>> test_inventory = new HashMap<String,List<Item>>();
		
		List<Item> test_item = new ArrayList<Item>();
		
		List<Item> test_item_02 = new ArrayList<Item>();
		
		Item item = new Item();
		
		item.setSKU("0001");
		item.setItem_description("Lays");
		item.setUnit_price(new BigDecimal("4.55").setScale(2,RoundingMode.UNNECESSARY));
		item.setIcon(new ImageIcon("src/main/resources/icons/Lays_icon.png"));
		
		Item item_02 = new Item();
		
		item_02.setSKU("0002");
		item_02.setItem_description("M&M's");
		item_02.setUnit_price(new BigDecimal("4.55").setScale(2,RoundingMode.UNNECESSARY));
		item_02.setIcon(new ImageIcon("src/main/resources/icons/M&M_icon.png"));
		
		test_item.add(item);
		test_item.add(item);
		test_item.add(item);
		test_item.add(item);
		test_item.add(item);
		
		test_item_02.add(item_02);
		test_item_02.add(item_02);
		test_item_02.add(item_02);
		
		
		test_inventory.put(item.getSKU(), test_item);
		test_inventory.put(item_02.getSKU(), test_item_02);
		
		
		Item item_sec = displayMultipleObjects("item","Test",test_inventory);
		
		System.out.println(item_sec.toString());
	    
	  }

	public static Item displayMultipleObjects(String prompt, String label, Map<String,List<Item>> inventory) {
		JFrame frame = new JFrame();

		Object [] array_icons = new Object [(inventory.size()+1)];
		Item [] array_items = new Item [(inventory.size()+1)];
		int counter = 1;
		
		array_icons[0] = "Cancel";
		array_items[0] = null;
		
		Set<String> keys = inventory.keySet();
		
		for (String key : keys) {
			
			List<Item> item = inventory.get(key);
			
			if(!item.isEmpty()) {
				
				//System.out.println(item.get(0).toString());
				array_icons[counter] = item.get(0).getIcon();
				array_items[counter] = item.get(0);
			}
			
			counter++;
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int input = JOptionPane.showOptionDialog(frame, prompt, label,
		        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.YES_NO_CANCEL_OPTION, null, array_icons,
		        array_icons[0]);
		
		 if(input == -1 || input == 0) {
			 	System.out.println("Bye bye");
		    	System.exit(0);
		    }
		 
		 Item item_selected = array_items[input];
		
		return item_selected;
	}
	
}
