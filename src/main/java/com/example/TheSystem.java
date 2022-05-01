package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {

	private HashMap<String, Item> itemCollection;

	public void setItemCollection(HashMap<String, Item> itemCollection) {
		this.itemCollection = itemCollection;
	}

	TheSystem() {
		// Your code here
		itemCollection = new HashMap<>();

		if (getClass().getSimpleName().equals("AppSystem")) {

			try {

				File input = new File("resources/sample.txt");
				input = new File(input.getAbsolutePath());
				Scanner reader = new Scanner(input);
				while (reader.hasNextLine()) {
					Item newItem = new Item();

					String[] itemInfo = reader.nextLine().split("  ");
					Double Price = Double.parseDouble(itemInfo[2]);
					Integer Quantity = Integer.parseInt(itemInfo[3]);
					newItem.setItemName(itemInfo[0]);
					newItem.setItemDesc(itemInfo[1]);
					newItem.setItemPrice(Price);
					newItem.setAvailableQuantity(Quantity);
					itemCollection.put(itemInfo[0], newItem);
				}
				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();

			}
		}

	}

	public HashMap<String, Item> getItemCollection() {
		// Your code here

		return itemCollection;
	}

	public Boolean checkAvailability(Item item) {
		// Your code here
		if (item.getQuantity() >= item.getAvailableQuantity()) {
			System.out.println("System is unable to add " + item.getItemName() + " to the cart. System only has "
					+ item.getAvailableQuantity() + " " + item.getItemName() + "s");
			return false;
		} else {
			return true;
		}
	}

	public Boolean add(Item item) {
		if (item == null) {
			return false;
		} else if (itemCollection.containsKey(item.getItemName())) {
			Item collItem = this.itemCollection.get(item.getItemName());
			int currentQuant = collItem.getQuantity();
			collItem.setQuantity(currentQuant + 1);
			itemCollection.put(item.getItemName(), collItem); // Put replaces a value if it already contains it.
			return true;
		} else {
			itemCollection.put(item.getItemName(), item);
			return true;
		}
	}

	public Item remove(String itemName) {
		// Your code here
		return itemCollection.remove(itemName);
	}

	public abstract void display();
}
