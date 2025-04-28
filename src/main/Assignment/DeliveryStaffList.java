package Assignment;

import java.util.ArrayList;
import java.util.Random;

public class DeliveryStaffList {
	private ArrayList <DeliveryStaff> deliveryStaff;
	
	public DeliveryStaffList() {
		deliveryStaff = new ArrayList<>();
		deliveryStaff.add(new DeliveryStaff("Alex", "0123456789"));
		deliveryStaff.add(new DeliveryStaff("James", "0123456789"));
		deliveryStaff.add(new DeliveryStaff("Susan", "0123456789"));
		deliveryStaff.add(new DeliveryStaff("Henry", "0123456789"));
	}
	
	public DeliveryStaff randomAssignDeliveryStaff() {
		Random random = new Random();
		int ran = random.nextInt(3 - 0 + 1);
		return deliveryStaff.get(ran);
	}
	
	public ArrayList<DeliveryStaff> getDeliveryStaffList() {
		return deliveryStaff;
		
	}
	
}
