package Assignment;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class StaffAssignationTest {
	
	//decision tree
	@Test
	public void testStaffAssignationValid() {
		DeliveryStaffList dslmock = mock(DeliveryStaffList.class);
		Item item = new Parcel(500,10,dslmock);
		DeliveryStaff ds = new DeliveryStaff("Alex", "0123456789");
		when(dslmock.randomAssignDeliveryStaff()).thenReturn(ds);
		item.assignDeliveryStaff();
		assertEquals(ds, item.getDeliveryStaff());
	}
    
	// decision tree
	@Test(expected = IllegalArgumentException.class)
	@Parameters (method = "staffAssignationInvalidParams")
	public void testStaffAssignationInvalidNullInstanceVariable(String name, String number) {
		DeliveryStaffList dslmock = mock(DeliveryStaffList.class);
		Item item = new Parcel(500, 10, dslmock);
		DeliveryStaff ds = new DeliveryStaff(name, number);
		when(dslmock.randomAssignDeliveryStaff()).thenReturn(ds);
		item.assignDeliveryStaff();
	}

	private Object[] staffAssignationInvalidParams() {
		return new Object[] { 
			new Object[] { null, "12345678" }, 
			new Object[] { "Jimmy", null },
			new Object[] { "", "12345678" }, 
			new Object[] { "Jimmy", "" } 
		};
	}
	
	// decision tree
	@Test(expected = IllegalArgumentException.class)
	public void testStaffAssignationInvalidNullObject(String name, String number) {
		DeliveryStaffList dslmock = mock(DeliveryStaffList.class);
		Item item = new Parcel(500, 10, dslmock);
		when(dslmock.randomAssignDeliveryStaff()).thenReturn(null);
		item.assignDeliveryStaff();
	}
}
