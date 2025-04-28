package Assignment;

import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class StaffAssignationIntegrationTest {

	@Test
	public void testStaffAssignationValidIntegrationTest() { 
		DeliveryStaffList dsl = new DeliveryStaffList();
		Item item = new Parcel(500,10);
		item.assignDeliveryStaff();
		assertTrue(dsl.getDeliveryStaffList().contains(item.getDeliveryStaff()));
	}
}
