package com.diego.vendingmachine.model.dao.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.diego.vendingmachine.model.dao.*;
import com.diego.vendingmachine.model.dto.*;

@Component("iventory_dao")
public class InventoryDAOImpl implements InventoryDAO {
	
	public final String FILE_PATH;
	public static final String DELIMITER = "::";
	private Map<String,List<Item>> inventory = new HashMap<String,List<Item>>();

	public InventoryDAOImpl() {
		super();
		FILE_PATH = "inventory_data.txt";
	}
	
	public InventoryDAOImpl(String fILE_PATH) {
		super();
		FILE_PATH = fILE_PATH;
	}

	public Inventory createInventory(String file_name) throws DataSourceException,InventoryException{
		
		Inventory new_inventory = null;
		Map<String,List<Item>> new_inventory_structure = null;
		try {
		      File file = new File(file_name+".txt");
		      if (file.createNewFile()) {
		    	  
		    	  new_inventory_structure = new HashMap<String,List<Item>>();
		    	  
		    	  new_inventory = new Inventory(new_inventory_structure);
		      } else {
		    	  throw new DataSourceException("File name already exists.");
		      }
		    } catch (IOException e) { 	
		    	throw new DataSourceException("Error processing file",e.getCause());
		    }
		return new_inventory;
	}

	public Inventory retreiveInventory() throws DataSourceException,InventoryException {
		loadData();
		Inventory inventory = new Inventory();
		inventory.setInventory(this.inventory);
		
		return inventory;
	}

	public Inventory updateInventory()throws DataSourceException,InventoryException {
		writeRecord();
		return retreiveInventory();
	}

	public Inventory deleteInventory()throws DataSourceException,InventoryException{
		Inventory inventory =retreiveInventory();
		Inventory deleted_inventory = createInventory("BackUp_inventory_"+ LocalDate.now()+".txt");
		deleted_inventory = inventory;
		updateInventory();
		
		inventory.getInventory().clear();
		
		return inventory;
	}
	
	
	//UTILITY METHODS 

		private void loadData() throws DataSourceException,InventoryException {
			   
			Scanner reader;
			 
		    try {
		        
		    	File file = new File(FILE_PATH);
			      reader = new Scanner(file);
			      reader.useDelimiter(DELIMITER);
		    } catch (FileNotFoundException e) {
		        throw new DataSourceException("File not found.", e.getCause());
		    }
		    
		    String currentLine;	    
		    List<Item> current_item;
		    	    
		    while (reader.hasNextLine()) {//while there is data to persist
		        
		        currentLine = reader.nextLine();

		        current_item = unmarshallObject(currentLine); //Convert a line into an object 
		        
		        inventory.put(current_item.get(0).getSKU(), current_item);
		    }
		    
		    reader.close();//once done, close the reader
		}
		
		
		private List<Item> unmarshallObject(String objectAsText){
			
			String[] objectTokens = objectAsText.split(DELIMITER);//the split method will return an array of string  with every piece of data in each element 
			
			 
			Item item = new Item();
			
			item.setSKU(objectTokens[0]);
			
			item.setItem_description(objectTokens[1]);

			item.setUnit_price(new BigDecimal((objectTokens[2])).setScale(2, RoundingMode.HALF_UP));
			
			int units_in_stock = Integer.valueOf((objectTokens[3]));
			
			String SKU = "ITM" + // Prefix
					item.getItem_description().substring(0, 2) + // Description piece
					item.getItem_description().substring(3, 4) + // Description piece
					"000" + // Zeros
					LocalDate.now().getMonth() + // Month
					(String.valueOf(LocalDate.now().getYear()).substring(2, 4));// Year

			item.setSKU(SKU);

			List<Item> item_stock = new ArrayList<Item>();

			while (units_in_stock >= 0) {

				item_stock.add(item);

				units_in_stock--;
		}
			
		    return item_stock;
		}
		
		private String marshallObject(Item item, int units_in_stock){
			String itemAsText = item.getSKU() + DELIMITER; 
			itemAsText += item.getItem_description()+ DELIMITER;
			itemAsText += item.getUnit_price().setScale(2, RoundingMode.HALF_UP) + DELIMITER;
			itemAsText += units_in_stock;
			
			return itemAsText;
		}
		
		private void writeRecord() throws DataSourceException,InventoryException { 
			PrintWriter out;
			
			try {
		        out = new PrintWriter(new FileWriter(FILE_PATH));
		    } catch (IOException e) {
		        throw new DataSourceException("Could not save student data.", e);
		    }
			
			String itemAsText;
			
			Inventory inventory = this.retreiveInventory();
			
			Set<String> keys = inventory.getInventory().keySet();
			
		    for (String key : keys) {
		    	
		    	List<Item> current_item = inventory.getInventory().get(key);
		    	
		    	Item item = current_item.get(0);
		    	
		    	int units_in_stock = (current_item.size()-1);
		    	
		    	itemAsText = marshallObject(item,units_in_stock);
		        // write the object to the file
		        out.println(itemAsText);
		        // force PrintWriter to write line to the file
		        out.flush();
		    }
		    // Clean up
		    out.close();
			
		}

}
