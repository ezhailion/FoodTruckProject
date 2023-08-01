package com.skilldistillery.foodtruck.app;

import com.skilldistillery.foodtruck.entities.FoodTruck;
import java.util.Scanner;

public class FoodTruckApp {
	private FoodTruck[] arrOfFoodTrucks;

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();

		app.launchApp();

	}

	public void launchApp() {
		// Only for invoking your non static methods and setup

		Scanner kb = new Scanner(System.in);

		retrieveTruckData(kb);

		int input = 0;
		do {
			showMenu();
			input = kb.nextInt();
			kb.nextLine();
			inputChoice(input);
		} while (input != 4);
		kb.close();
	}

// Method that instantiates the private fields of the FoodTruck class.
	public void retrieveTruckData(Scanner kb) {
		arrOfFoodTrucks = new FoodTruck[5];

		for (int i = 0; i < arrOfFoodTrucks.length; i++) {
			System.out.println("What is the name of your truck?");
			String truckName = kb.nextLine();
			if (truckName.equals("quit")) {
				break;
			} else {
				System.out.println("What is the type of food do you sell?");
				String truckType = kb.nextLine();
				System.out.println("What is the rating on a scale of 1 to 5 of your food truck?");
				double truckRating = kb.nextDouble();
				kb.nextLine();
				FoodTruck fTruck = new FoodTruck();
				fTruck.setNameOfTruck(truckName);
				fTruck.setTypeOfFood(truckType);
				fTruck.setRating(truckRating);

				arrOfFoodTrucks[i] = fTruck;

			}
		}

	}

	// Displays menu for the user
	public void showMenu() {

		System.out.println();
		System.out.println("************************************");
		System.out.println("*Select an option by entering a number.*");
		System.out.println("*1. Show me all of your trucks!*");
		System.out.println("*2. Show me your best truck!*");
		System.out.println("*3. What's the average rating of all of your trucks here?*");
		System.out.println("*4. Well what are you still doing here?*");
		System.out.println("************************************");
		System.out.println();

	}

// resolves the input data for the menu choices
	public void inputChoice(int input) {
		// display all input trucks

		if (input == 1) {
			displayTrucks();
			// find the highest rating of all of the trucks that have been input, and
			// display.
		} else if (input == 2) {

			highestRating();
			// add ratings of all trucks and divide by the length of occupied indexes

		} else if (input == 3) {
			averageRating();

		} else if (input > 4) {
			System.err.println("That's not a valid input!");
		} else

		{
			System.out.println("Goodbye.");
		}

	}

// Similar purpose to .length, but still compiles if the array is less than the maximum index.
	public int lengthOfArray(FoodTruck[] arrOfFoodTrucks) {
		int counter = 0;
		for (int i = 0; i < arrOfFoodTrucks.length; i++) {
			if (arrOfFoodTrucks[i] != null) {
				counter++;
			}
		}

		return counter;

	}

	public void displayTrucks() {
		for (FoodTruck foodTruck : arrOfFoodTrucks) {

			if (foodTruck != null) {
				System.out.println(foodTruck);
			}
		}
	}

	public void highestRating() {
		FoodTruck highestRating = new FoodTruck();
		highestRating.setRating(0);
		for (FoodTruck foodTruck : arrOfFoodTrucks) {
			if (foodTruck != null && foodTruck.getRating() > highestRating.getRating()) {

				highestRating = foodTruck;
			}
		}
		System.out.println(highestRating.getNameOfTruck() + " is the highest with: " + highestRating.getRating());

	}

	public void averageRating() {
		double average;
		double rate = 0;
		for (FoodTruck foodTruck : arrOfFoodTrucks) {

			if (foodTruck != null) {
				rate += foodTruck.getRating();
			}
		}
		average = rate / lengthOfArray(arrOfFoodTrucks);
		System.out.println("Our average rating of our food trucks is: " + average);
	}
}
