package com.diego.excercises;

public class IceCreamDairy {

	final int serving_size = 55;//read-only
	int total_fat;//read/write
	int cholesterol;//read/write
	int sodium;//read/write
	int carbohydrate;//read/write

	//constructor
	public IceCreamDairy(int total_fat, int cholesterol, int sodium, int carbohydrate) {
		super();
		this.total_fat = total_fat;
		this.cholesterol = cholesterol;
		this.sodium = sodium;
		this.carbohydrate = carbohydrate;
	}
	
	
	//getters
	public int getServing_size() {
		return serving_size;
	}

	public int getTotal_fat() {
		return total_fat;
	}

	public int getCholesterol() {
		return cholesterol;
	}

	public int getSodium() {
		return sodium;
	}

	public int getCarbohydrate() {
		return carbohydrate;
	}

	//setters
	public void setTotal_fat(int total_fat) {
		this.total_fat = total_fat;
	}

	public void setCholesterol(int cholesterol) {
		this.cholesterol = cholesterol;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}

	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	public void getIceCreamReport() {
		System.out.println("IceCreamDairy \nserving_size: " + serving_size + "\n total_fat: " + total_fat + "\n cholesterol: "
				+ cholesterol + "\n sodium: " + sodium + "\n carbohydrate: " + carbohydrate );
	}
	
	
	
	
	
	
}
