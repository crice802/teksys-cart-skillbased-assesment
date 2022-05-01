package com.example;

import java.util.Map;

public class CartSystem extends TheSystem {
	CartSystem() {
	}

	@Override
	public void display() {
		// Your code here

		double subTotal = 0.0;

		System.out.println("Cart:");
		System.out.printf("%-20s %-20s %-10s %-10s %-10s%n", "Name", "Description", "Price", "Quantity", "Sub Total");

		for (Map.Entry<String, Item> items : getItemCollection().entrySet()) {
			String name = items.getValue().getItemName();
			String desc = items.getValue().getItemDesc();
			Double price = items.getValue().getItemPrice();
			Integer quantity = items.getValue().getQuantity();
			subTotal += (items.getValue().getItemPrice() * items.getValue().getQuantity());

			System.out.printf("%-20s %-20s %-10.2f %-10d %-10.2f%n\n", name, desc, price, quantity, subTotal);

		}

		Double pretax = subTotal;
		Double tax = 0.05 * subTotal;
		Double total = subTotal + tax;

		System.out.printf("%-20s %-20.2f%n%-20s %-20.2f%n%-20s %-20.2f%n", "Pre-tax Total", pretax, "Tax", tax, "Total",
				total);
	}
}
