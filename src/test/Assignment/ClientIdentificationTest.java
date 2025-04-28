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
public class ClientIdentificationTest {
    
	//decision tree
	@Test
	@Parameters (method = "searchClientValidParams")
	public void testSearchClientValid(String name, boolean expResult) throws IOException {
		Client client = new Client();
		boolean actResult = client.searchClient(name);
		if (expResult == true)
			assertTrue(actResult);
		else
			assertFalse(actResult);
	}
	
	private Object[] searchClientValidParams() {
		return new Object[] {
			new Object[] {"Sam", true},
			new Object[] {"Kim", false}
		};
	}
	
	
	
	//decision tree
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "searchClientInvalidParams")
	public void testSearchClientInvalid(String name) throws IOException {
		Client client = new Client();
		client.searchClient(name);
	}
	
	private Object[] searchClientInvalidParams() {
		return new Object[] {
			new Object[] {null},
			new Object[] {""}
		};
	}
}
