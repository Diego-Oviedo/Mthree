package com.diego.vendingmachine.model.dto;

import java.time.LocalDate;

public class Sale {
	
	private String sales_number;
	private LocalDate sales_date;
	private Item sold_item; 
	
	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sale(String sales_number, LocalDate sales_date, Item sold_item) {
		super();
		this.sales_number = sales_number;
		this.sales_date = sales_date;
		this.sold_item = sold_item;
	}

	public String getSales_number() {
		return sales_number;
	}

	public LocalDate getSales_date() {
		return sales_date;
	}

	public Item getSold_item() {
		return sold_item;
	}

	public void setSales_number(String sales_number) {
		this.sales_number = sales_number;
	}

	public void setSales_date(LocalDate sales_date) {
		this.sales_date = sales_date;
	}

	public void setSold_item(Item sold_item) {
		this.sold_item = sold_item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sales_date == null) ? 0 : sales_date.hashCode());
		result = prime * result + ((sales_number == null) ? 0 : sales_number.hashCode());
		result = prime * result + ((sold_item == null) ? 0 : sold_item.hashCode());
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
		Sale other = (Sale) obj;
		if (sales_date == null) {
			if (other.sales_date != null)
				return false;
		} else if (!sales_date.equals(other.sales_date))
			return false;
		if (sales_number == null) {
			if (other.sales_number != null)
				return false;
		} else if (!sales_number.equals(other.sales_number))
			return false;
		if (sold_item == null) {
			if (other.sold_item != null)
				return false;
		} else if (!sold_item.equals(other.sold_item))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "• Sale\n・ sales_number: " + sales_number + "\n・ sales_date: " + sales_date + "\n・ sold_item: "
				+ sold_item;
	}
	
	
}
