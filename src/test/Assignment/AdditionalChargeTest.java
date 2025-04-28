package Assignment;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class AdditionalChargeTest {
	
	//equivalence partitioning
	@Test
	@Parameters(method="additionalChargeParam")
	public void testAdditionalCharge(boolean sameDayDelivery, boolean Insurance, double expectedresult) {
		Parcel parcel = new Parcel();
		parcel.calculateAdditionalCharges(sameDayDelivery, Insurance);
		assertEquals(expectedresult, parcel.getAdditionalCharges(),0.01);
	}
	
	private Object[] additionalChargeParam() {
		return new Object[] {
			new Object[] {true,true,25},
			new Object[] {true,false,10},
			new Object[] {false,true, 15},
			new Object[] {false,false, 0},
		};
	}
}
