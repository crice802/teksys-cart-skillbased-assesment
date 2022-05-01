package com.example;
import java.util.*
public class CartSystem extends TheSystem {
	CartSystem() {
	}

	@Override
	public void display() {
		// Your code here

		System.out.println("Cart:");
		System.out.printf("%-20s %-20s %-10s %-10s %-10s %n", "Name", "Description", "Price", "Available Quantity",
				"Sub Total");
		Double tax = subtotal * .05;
		Double total = subtotal * tax;

		for(Map.Entry<String, Item> items : getItemCollection().entrySet()){
            String name = items.getValue().getItemName();
            String desc = items.getValue().getItemDesc();
            Double price = items.getValue().getItemPrice();
            Integer quantity = items.getValue().getQuantity();
            subTotal += (items.getValue().getItemPrice() * items.getValue().getQuantity());
	}
	
	System.out.printf("%-20s %-20s %-10.2f %-10d %-10d %n", key, val.getItemDesc(), val.getItemPrice(),
			val.getAvailableQuantity(), subtotal);

}
