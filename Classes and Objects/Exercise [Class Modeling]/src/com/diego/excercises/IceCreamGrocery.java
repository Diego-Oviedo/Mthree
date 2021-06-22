package com.diego.excercises;

public class IceCreamGrocery {

	String department = "Dairy department";//read-only
	String SKU;//read/write
	int price;//read/write
	String description;//read/write

	//constructor
	public IceCreamGrocery(String department, String sKU, int price, String description) {
		super();
		this.department = department;
		SKU = sKU;
		this.price = price;
		this.description = description;
	}

	//getters
	public String getDepartment() {
		return department;
	}

	public String getSKU() {
		return SKU;
	}

	public int getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	//setters
	
	public void setDepartment(String department) {
		this.department = department;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public void getIceCreamReport() {
		System.out.println("IceCreamGrocery \ndepartment: " + department + "\n SKU: " + SKU + "\n price: " + price + "\n description: "
				+ description );
	}
	
	
	
	
}
