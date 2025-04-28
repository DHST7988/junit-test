package Assignment;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class TotalChargeTest {
	
	@Test
	@Parameters(method = "totalChargeValidParam")
	public void testTotalChargeValid(double baseCharges, double additionalCharges, double expectedresult) {
		Parcel parcel = new Parcel();
		parcel.setBaseCharges(baseCharges);
		parcel.setAdditionalCharges(additionalCharges);
		parcel.calculateTotalCharges();
		assertEquals(expectedresult, parcel.getTotalCharges(),0.01);
	}
	
	private Object[] totalChargeValidParam() {
		return new Object[] {
			new Object[] {5.0, 0.0, 5.0},
			new Object[] {5.0, 5.0, 10.0}
		};
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "totalChargeInvalidParam")
	public void testTotalChargeInvalid(double baseCharges, double additionalCharges) {
		Parcel parcel = new Parcel();
		parcel.setBaseCharges(baseCharges);
		parcel.setAdditionalCharges(additionalCharges);
		parcel.calculateTotalCharges();
	}
	
	private Object[] totalChargeInvalidParam() {
		return new Object[] {
			new Object[] {-5.0, -5.0},
			new Object[] {-5.0, 0.0},
			new Object[] {-5.0, 5.0},
			new Object[] {5.0, -5.0}
		};
	}
	
}