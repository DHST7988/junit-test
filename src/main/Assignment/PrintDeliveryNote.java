package Assignment;

import java.util.Random;

public class PrintDeliveryNote {
	public void printNote(Item item) {
		
		System.out.println("--------------------DELIVERY NOTES--------------------");
		System.out.println("Delivery staff's name: " + item.deliveryStaff.getName());
		System.out.println("Delivery staff's phone number: " + item.deliveryStaff.getNumber());
		System.out.println("Parcel's weight(g): " + item.weight);
		System.out.println("Delivery distance(km): " + item.distance);
		System.out.println("Total Charges(RM): " + item.totalCharges);
		System.out.println("------------------------------------------------------");
		
	}
}
