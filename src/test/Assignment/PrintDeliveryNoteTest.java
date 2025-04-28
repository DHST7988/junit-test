package Assignment;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PrintDeliveryNoteTest {
	
	//decision tree
	@Test
	public void testPrintDeliveryNoteValid() {
		PrintDeliveryNote pdnMock = mock(PrintDeliveryNote.class);
		Item item = new Parcel(50, 5, pdnMock);
		item.printDeliveryNote();
		verify(pdnMock).printNote(item);
	}
	
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "printDeliveryNoteInvalidParams")
	public void testPrintDeliveryNoteInvalid(int weight, int distance) {
		Item item = new Parcel(weight, distance);
		item.printDeliveryNote();
	}
	
	private Object[] printDeliveryNoteInvalidParams() {
		return new Object[] {
				new Object[] {-50, 5},
				new Object[] {50, -5}
		};
	}

}
