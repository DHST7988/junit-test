package Assignment;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runner.RunWith;

import junitparams.Parameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class ClientRegistrationTest {
	Client client = new Client();

	// decision tree
	@Test
	public void testClientRegisterValid() throws IOException {
		String fileName = "testClientRegisterValid.txt";
		Scanner inputStream = null;
		ArrayList<String[]> linesRead = new ArrayList<String[]>();
		String[] values = null;
		String expResult = null;
		
		try {
			inputStream = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Error in opening the file " + fileName);
			System.exit(0);
		}
		while(inputStream.hasNextLine()) {
			String singleLine = inputStream.nextLine();
			String[] tokens = singleLine.split("!");
			linesRead.add(tokens);
		}
		
		for (String[] strArray:linesRead) {
			values = strArray[0].split(";");
			expResult = strArray[1];
		}
		client.register(values[0], values[1], values[2]);
		assertTrue(client.searchClient(expResult));
	}
	
	// decision tree
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "clientRegisterInvalidParams")
	public void testClientRegisterInvalid(String name, String address, String number) throws IOException {
		client.register(name, address, number);
	}
	
	private Object[] clientRegisterInvalidParams() {
		return new Object[] {
				new Object[] {null, "123, Taman Baru", "012-3456789"},
				new Object[] {"John", null, "018-1122334"},
				new Object[] {"Jane", "11, Sungai Long", null},
				new Object[] {"", "123, Taman Baru", "012-3456789"},
				new Object[] {"John", "", "018-1122334"},
				new Object[] {"Jane", "11, Sungai Long", ""}
		};
	}

}
