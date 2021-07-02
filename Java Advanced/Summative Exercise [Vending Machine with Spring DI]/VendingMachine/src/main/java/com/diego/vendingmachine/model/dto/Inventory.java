package com.diego.vendingmachine.model.dto;

import java.util.*;

public class Inventory {

	private Map<String,List<Item>> inventory;

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inventory(Map<String, List<Item>> inventory) {
		super();
		this.inventory = inventory;
	}

	public Map<String, List<Item>> getInventory() {
		return inventory;
	}

	public void setInventory(Map<String, List<Item>> inventory) {
		this.inventory = inventory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inventory == null) ? 0 : inventory.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		if (inventory == null) {
			if (other.inventory != null)
				return false;
		} else if (!inventory.equals(other.inventory))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "• Inventory\n・ inventory: " + inventory;
	}
	
	
}
