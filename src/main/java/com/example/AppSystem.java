package com.example;

public class AppSystem extends TheSystem {
	AppSystem() {

	}

	@Override
	public void display() {
		// Your code here
		System.out.println("AppSystem Inventory:");
		System.out.printf("%-20s %-20s %-10s %-10s%n", "Name", "Description", "Price", "Available Quantity");

		getItemCollection().forEach((key, val) -> {
			System.out.printf("%-20s %-20s %-10.2f %-10d%n", key, val.getItemDesc(), val.getItemPrice(),
					val.getAvailableQuantity());
		});

	}

	@Override // this overwrites the parents class add method
	public Boolean add(Item item) {
		// Your code here
		if (item == null) {
			return false;
		} else if (getItemCollection().containsKey(item.getItemName())) {
			System.out.println(item.getItemName() + " is already in the App System");
			return false;
		} else {
			getItemCollection().put(item.getItemName(), item);
			return true;
		}
	}

	public Item reduceAvailableQuantity(String item_name) {
		// Your code here
		if (!(getItemCollection().containsKey(item_name))) {
			return null;
		} else {
			getItemCollection().get(item_name)
					.setAvailableQuantity((getItemCollection().get(item_name).getAvailableQuantity()) - 1);
			if (getItemCollection().get(item_name).getAvailableQuantity() == 0) {
				getItemCollection().remove(item_name);
				return null;
			}

			return getItemCollection().get(item_name);
		}
	}
}
