package com.diego.vendingmachine.dao.implementation;

import java.io.*;
import java.math.*;
import java.util.*;

import org.springframework.stereotype.Component;

import com.diego.vendingmachine.dao.*;
import com.diego.vendingmachine.dto.*;

@Component("item_dao")
public class ItemDAOImpl implements ItemDAO {

	public static final String FILE_PATH = "src/main/resources/inventory_data.txt";
	public static final String DELIMITER = "::";
	private List<Item> inventory = null;
	

	// DAO methods

	public Item addItem(Item item) throws InventoryException {
		Item item_added = null;
		try {
			List<Item> inventory = getAllItems();
			
			inventory.add(item_added);
			writeRecord();
			
		}catch(Exception e) {
			throw new InventoryException("Error when adding an item to the inventory [DAO layer].", e.getCause());
		}
		
		return item_added;
	}

	public Item getItem(String SKU) throws InventoryException, DataSourceException {
		Item item_selected = null;
		try {
			List<Item> inventory = getAllItems();
			
			for(Item item : inventory) {
				if(item.getSKU().equalsIgnoreCase(SKU))
					item_selected = item;
			}
			
		}catch(Exception e) {
			throw new InventoryException("Error when getting an item [DAO layer].", e.getCause());
		}
		
		return item_selected;
	}

	public Item findItembyDescription(String item_description) throws DataSourceException, InventoryException {
		Item item_selected = null;
		try {
			List<Item> inventory = getAllItems();
			
			for(Item item : inventory) {
				if(item.getItem_description().toLowerCase().contains(item_description.toLowerCase()))
					item_selected = item;
			}
			
		}catch(Exception e) {
			throw new InventoryException("Error when getting an item by its description [DAO layer].", e.getCause());
		}
		
		return item_selected;
	}

	public Item editItem(String SKU,Item item) throws DataSourceException, InventoryException {
		Item item_updated = null;
		
		try {
			item_updated = getItem(SKU);
			item_updated.setSKU(item.getSKU());
			item_updated.setItem_description(item.getItem_description());
			item_updated.setUnit_price(item.getUnit_price());
			item_updated.setUnits_in_stock(item.getUnits_in_stock());
			
			removeItem(SKU);
			inventory.add(item_updated);
			writeRecord();
			
		} catch (Exception e) {
			throw new InventoryException("Error when editing an item [DAO layer]",e.getCause());
		}
		
		return item_updated;
	}

	public Item removeItem(String SKU) throws DataSourceException, InventoryException {
		Item item_removed = null;
		try {
			
			List<Item> inventory = getAllItems();
			int counter = 0;
			
			for(Item item : inventory) {
				if(item.getSKU().equalsIgnoreCase(SKU)) {
					item_removed =  inventory.remove(counter);
					break;
				}
				counter ++;
			}
			writeRecord();
		}catch (Exception e) {
			throw new InventoryException("Error when removing an error [DAO layer].", e.getCause());
		}
		
		return item_removed;
	}

	public List<Item> getAllItems() throws InventoryException, DataSourceException {
		loadData();
		List<Item> inventory = null;
		try {
			inventory = new ArrayList<Item>();
			inventory = this.inventory;
		}catch(Exception e) {
			throw new InventoryException("Error when getting all the items [DAO layer].", e.getCause());
		}
		
		return inventory;
	}

	// UTILITY METHODS

	private void loadData() throws DataSourceException, InventoryException {

		Scanner reader;

		try {

			File file = new File(FILE_PATH);
			reader = new Scanner(file);
			reader.useDelimiter(DELIMITER);
		} catch (FileNotFoundException e) {
			throw new DataSourceException("File not found.", e.getCause());
		}

		String currentLine;
		Item current_item;
		inventory = new ArrayList<Item>();
		
		while (reader.hasNextLine()) {// while there is data to persist

			currentLine = reader.nextLine();

			current_item = unmarshallObject(currentLine); // Convert a line into an object

			inventory.add(current_item);
		}

		reader.close();// once done, close the reader
	}

	private Item unmarshallObject(String objectAsText) throws DataSourceException, InventoryException {

		String[] objectTokens = objectAsText.split(DELIMITER);// the split method will return an array of string with
		Item item = null; // every piece of data in each element
		try {
			item = new Item();

			item.setSKU(objectTokens[0]);

			item.setItem_description(objectTokens[1]);

			item.setUnit_price(new BigDecimal((objectTokens[2])).setScale(2, RoundingMode.HALF_UP));

			int units_in_stock = Integer.valueOf((objectTokens[3]));

			item.setUnits_in_stock(null);

			int[] item_stock = new int[units_in_stock];

			for (int i = (units_in_stock - 1); i >= 0; i--) {

				item_stock[i] = i;
			}

			item.setUnits_in_stock(item_stock);

		} catch (NullPointerException e) {
			throw new DataSourceException("Error when unmarshalling the object [from text to Object] [Null object].", e.getCause());
		}catch (Exception e) {
			e.printStackTrace();
			throw new InventoryException("Error when unmarshalling the object [from text to Object]. [DAO layer]", e.getCause());
		}

		return item;
	}

	private String marshallObject(Item item) throws DataSourceException, InventoryException {
		String itemAsText;
		try {
			itemAsText = item.getSKU() + DELIMITER;
			itemAsText += item.getItem_description() + DELIMITER;
			itemAsText += item.getUnit_price().setScale(2, RoundingMode.HALF_UP) + DELIMITER;
			itemAsText += item.getUnits_in_stock().length;
		} catch (NullPointerException e) {
			throw new InventoryException("Error when marshalling the object [from Object to text] [Null object].", e.getCause());
		}catch (Exception e) {
			throw new InventoryException("Error when marshalling the object [from Object to text]. [DAO layer]", e.getCause());
		}


		return itemAsText;
	}

	private void writeRecord() throws DataSourceException, InventoryException {
		PrintWriter out;

		try {
			out = new PrintWriter(new FileWriter(FILE_PATH));

			String itemAsText;
			
			//List<Item> inventory = getAllItems();

			for (Item item : inventory) {
				if (item != null) {

					itemAsText = marshallObject(item);
					// write the object to the file
					out.println(itemAsText);
					// force PrintWriter to write line to the file
					out.flush();
				}

			}

		} catch (IOException e) {
			throw new DataSourceException("Error when writing data. [Wrtting the file]", e.getCause());
		} catch (NullPointerException e) {
			throw new InventoryException("Error when writing data. [Null value]", e.getCause());
		}catch (Exception e) {
			throw new InventoryException("No record found", e.getCause());
		}

		// Clean up
		out.close();

	}
}
