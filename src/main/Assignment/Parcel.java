package Assignment;
import java.util.*;

public class Parcel extends Item{
	
	public Parcel() {
		
	}
	
	public Parcel(int weight, int distance) {
		super(weight, distance);
	}
	
	public Parcel(int weight, int distance, PrintDeliveryNote pdn) {
		super(weight, distance, pdn);
	}
	
	public Parcel(int weight, int distance, DeliveryStaffList dsl) {
		super(weight, distance, dsl);
	}
	
	public Parcel(int weight, int distance, Email email) {
		super(weight, distance, email);
	}
	
	@Override
	public void calculateBaseCharges() {
		if (weight >= 0 && weight < 1001) {
			if(distance >= 0 && distance < 10) {
				baseCharges = 5.00;
			}
			else if(distance >= 10 && distance <= 30) {
				baseCharges = 8.00;
			}
			else if(distance > 30) {
				baseCharges = 10.00;
			}
			else {
				throw new IllegalArgumentException("Distance cannot be smaller than 0");
			}
		}
		else if (weight >= 1001 && weight < 2001) {
			if(distance >= 0 && distance < 10) {
				baseCharges = 15.00;
			}
			else if(distance >= 10 && distance <= 30) {
				baseCharges = 18.00;
			}
			else if(distance > 30) {
				baseCharges = 25.00;
			}
			else {
				throw new IllegalArgumentException("Distance cannot be smaller than 0");
			}
		}
		else if (weight >= 2001 && weight < 3001) {
			if(distance >= 0 && distance < 10) {
				baseCharges = 23.00;
			}
			else if(distance >= 10 && distance <= 30) {
				baseCharges = 28.00;
			}
			else if(distance > 30) {
				baseCharges = 35.00;
			}
			else {
				throw new IllegalArgumentException("Distance cannot be smaller than 0");
			}
		}
		else if (weight >= 3001 && weight < 5001) {
			if(distance >= 0 && distance < 10) {
				baseCharges = 35.00;
			}
			else if(distance >= 10 && distance <= 30) {
				baseCharges = 40.00;
			}
			else if(distance > 30) {
				baseCharges = 50.00;
			}
			else {
				throw new IllegalArgumentException("Distance cannot be smaller than 0");
			}
		}
		else if (weight >= 5001) {
			if(distance >= 0 && distance < 10) {
				baseCharges = 45.00;
			}
			else if(distance >= 10 && distance <= 30) {
				baseCharges = 50.00;
			}
			else if(distance > 30) {
				baseCharges = 60.00;
			}
			else {
				throw new IllegalArgumentException("Distance cannot be smaller than 0");
			}
		}
		else {
			throw new IllegalArgumentException("Weight cannot be smaller than 0");
		}
	}
}
