package Assignment;
import org.junit.Test;
import static org.mockito.Mockito.*;

import org.junit.runner.RunWith;

import junitparams.Parameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class EmailTest {
	
	// decision tree
	@Test
	public void testEmailNotiValid() {
		Email emock = mock (Email.class);
		Item item= new Parcel(25, 5, emock);
		item.sendEmail();
		verify(emock).sendEmailNotification(item);
	}
	
	// decision tree
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "sendEmailInvalidParams")
	public void testEmailNotiInvalid(int weight, int distance) {
		Item item = new Parcel(weight, distance);
		item.sendEmail();
	}
	
	private Object[] sendEmailInvalidParams() {
		return new Object[] {
				new Object[] {-50, 5},
				new Object[] {50, -5}
		};
	}
}
