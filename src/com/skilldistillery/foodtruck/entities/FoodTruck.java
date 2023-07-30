package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private String typeOfFood;
	private String nameOfTruck;
	private double rating;
	private int truckID;
	private static int nextTruckID = 0;

	public FoodTruck() {

		truckID = nextTruckID;
		nextTruckID++;

	}

	public String getTypeOfFood() {
		return typeOfFood;
	}

	public void setTypeOfFood(String typeOfFood) {
		this.typeOfFood = typeOfFood;
	}

	public String getNameOfTruck() {
		return nameOfTruck;
	}

	public void setNameOfTruck(String nameOfTruck) {
		this.nameOfTruck = nameOfTruck;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getTruckID() {
		return truckID;
	}

	@Override
	public String toString() {
		return "FoodTruck [typeOfFood=" + typeOfFood + ", nameOfTruck=" + nameOfTruck + ", rating=" + rating
				+ ", truckID=" + truckID + "]";
	}

}
