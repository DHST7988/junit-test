package Assignment;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses(value = {AdditionalChargeTest.class,
		ChargeTest.class,
		ClientIdentificationTest.class,
		ClientRegistrationTest.class,
		EmailTest.class,
		PrintDeliveryNoteTest.class,
		StaffAssignationTest.class,
		TotalChargeTest.class,
})
public class UnitTestSuite {


}
