package com.diego.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Arrays;

public class Item {
	
	private String SKU;
	private String item_description;
	private BigDecimal unit_price;
	private int[] units_in_stock;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(String sKU, String item_description, BigDecimal unit_price, int[] units_in_stock) {
		super();
		SKU = sKU;
		this.item_description = item_description;
		this.unit_price = unit_price;
		this.units_in_stock = units_in_stock;
	}

	public String getSKU() {
		return SKU;
	}

	public String getItem_description() {
		return item_description;
	}

	public BigDecimal getUnit_price() {
		return unit_price;
	}

	public int[] getUnits_in_stock() {
		return units_in_stock;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	public void setUnit_price(BigDecimal unit_price) {
		this.unit_price = unit_price;
	}

	public void setUnits_in_stock(int[] units_in_stock) {
		this.units_in_stock = units_in_stock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SKU == null) ? 0 : SKU.hashCode());
		result = prime * result + ((item_description == null) ? 0 : item_description.hashCode());
		result = prime * result + ((unit_price == null) ? 0 : unit_price.hashCode());
		result = prime * result + Arrays.hashCode(units_in_stock);
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
		Item other = (Item) obj;
		if (SKU == null) {
			if (other.SKU != null)
				return false;
		} else if (!SKU.equals(other.SKU))
			return false;
		if (item_description == null) {
			if (other.item_description != null)
				return false;
		} else if (!item_description.equals(other.item_description))
			return false;
		if (unit_price == null) {
			if (other.unit_price != null)
				return false;
		} else if (!unit_price.equals(other.unit_price))
			return false;
		if (!Arrays.equals(units_in_stock, other.units_in_stock))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "• " + item_description + " ・ price: $" + unit_price
				+ " [" + units_in_stock.length + "]";
	}
	
	

}
