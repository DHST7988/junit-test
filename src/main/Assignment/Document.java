package Assignment;
import java.util.*;
public class Document extends Item {
	
	public Document() {
		
	}
	
	public Document(int weight, int distance) {
		super(weight, distance);
	}
	
	public Document(int weight, int distance, PrintDeliveryNote pdn) {
		super(weight, distance, pdn);
	}
	
	public Document(int weight, int distance, DeliveryStaffList dsl) {
		super(weight, distance, dsl);
	}
	
	public Document(int weight, int distance, Email email) {
		super(weight, distance, email);
	}
	
	@Override
	public void calculateBaseCharges() {
		if (weight >= 0 && weight < 300) {
			if (distance >=0 ) {
			baseCharges = 3.00;
			}
			else {
				throw new IllegalArgumentException("Distance cannot be smaller than 0");
			}
		}
		else if (weight >= 300 && weight < 1001) {
			if(distance >= 0 && distance < 10) {
				baseCharges = 4.00;
			}
			else if(distance >= 10 && distance <= 30) {
				baseCharges = 5.00;
			}
			else if(distance > 30) {
				baseCharges = 6.00;
			}
			else {
				throw new IllegalArgumentException("Distance cannot be smaller than 0");
			}
		}
		else if (weight >= 1001 && weight < 3001) {
			if(distance >= 0 && distance < 10) {
				baseCharges = 6.00;
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
		else if (weight >= 3001 && weight < 5001) {
			if(distance >= 0 && distance < 10) {
				baseCharges = 12.00;
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
		else if (weight >= 5000) {
			if(distance >= 0 && distance < 10) {
				baseCharges = 25.00;
			}
			else if(distance >= 10 && distance <= 30) {
				baseCharges = 30.00;
			}
			else if(distance > 30) {
				baseCharges = 35.00;
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
