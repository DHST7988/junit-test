package Assignment;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public abstract class Item {
	protected int weight, distance;
	protected double baseCharges, additionalCharges, totalCharges;
	protected DeliveryStaff deliveryStaff;
	PrintDeliveryNote pdn;
	Email email;
	protected DeliveryStaffList dsl;
	
	public Item() {
	}
	
	public Item(int weight, int distance) {
		this.weight = weight;
		this.distance = distance;
		additionalCharges = 0;
		pdn = new PrintDeliveryNote();
		email = new Email();
		dsl = new DeliveryStaffList();
		assignDeliveryStaff();
	}
	
	public Item(int weight, int distance, PrintDeliveryNote pdn) {
		this.weight = weight;
		this.distance = distance;
		additionalCharges = 0;
		this.pdn = pdn;
		dsl = new DeliveryStaffList();
		assignDeliveryStaff();
	}
	
	public Item(int weight, int distance, DeliveryStaffList dsl) {
		this.weight = weight;
		this.distance = distance;
		this.dsl = dsl;
	}
	
	public Item(int weight, int distance, Email email) {
		this.weight = weight;
		this.distance = distance;
		additionalCharges = 0;
		pdn = new PrintDeliveryNote();
		this.email = email;
		dsl = new DeliveryStaffList();
		assignDeliveryStaff();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Item) {
			Item compareItem = (Item)obj;
			if (weight == compareItem.getWeight() && distance == compareItem.getDistance()
					&& deliveryStaff.equals(compareItem.getDeliveryStaff()) 
					&& totalCharges == compareItem.getTotalCharges())
				return true;
		}
		return false;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public abstract void calculateBaseCharges();
	
	public double getBaseCharges() {
		return baseCharges;
	}
	
	public void setBaseCharges(double baseCharges) {
		this.baseCharges = baseCharges;
	}
	
	public void calculateAdditionalCharges(boolean sameDayDelivery, boolean withInsurance) {
		if (sameDayDelivery)
			additionalCharges += 10;
		if (withInsurance)
			additionalCharges += 15;
	}
	
	public double getAdditionalCharges() {
		return additionalCharges;
	}
	
	public void setAdditionalCharges(double additionalCharges) {
		this.additionalCharges = additionalCharges;
	}
	
	public void calculateTotalCharges() {
		if (baseCharges > 0) {
			
			if (additionalCharges == 0) {
				totalCharges = baseCharges;
			}
			
			else if (additionalCharges > 0) {
				totalCharges = baseCharges + additionalCharges;
			}
			
			else {
				throw new IllegalArgumentException("Additional charges cannot be less than 0");
			}
		}
		
		else {
			throw new IllegalArgumentException("Base charges cannot be or less than 0");
		} 
	}
	
	public double getTotalCharges() {
		return totalCharges;
	}
	
	public void assignDeliveryStaff() {
		deliveryStaff = dsl.randomAssignDeliveryStaff();
		if (deliveryStaff == null || deliveryStaff.getName() == null || deliveryStaff.getName().length() == 0 ||
				deliveryStaff.getNumber() == null || deliveryStaff.getNumber().length() == 0) {
			throw new IllegalArgumentException();
		}
	}
	
	public DeliveryStaff getDeliveryStaff() {
		return deliveryStaff;
	}
	
	public void printDeliveryNote() {
		if (weight < 0 || distance < 0)
			throw new IllegalArgumentException();
		pdn.printNote(this);
	}
	
	public void sendEmail() {
		if (weight < 0 || distance < 0)
			throw new IllegalArgumentException();
		email.sendEmailNotification(this);
	}
}
