package Assignment;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.Parameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class ChargeTest {
	
	//decision tree
	@Test
	public void testParcelChargeValid() {
		Scanner inputStream = null;
		ArrayList<String[]> linesRead = new ArrayList<String[]>();
		int weight;
		int distance;
		double expResult;
		
		try {
			inputStream = new Scanner(new File("parcelChargeValidParams.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Error in opening the file");
			System.exit(0);
		}
		while(inputStream.hasNextLine()) {
			String singleLine = inputStream.nextLine();
			String[] tokens = singleLine.split(",");
			linesRead.add(tokens);
		}
		
		for (String[] strArray:linesRead) {
			weight = Integer.parseInt(strArray[0]);
			distance = Integer.parseInt(strArray[1]);
			expResult = Double.parseDouble(strArray[2]);
			Parcel parcel = new Parcel(weight, distance);
			parcel.calculateBaseCharges();
			assertEquals(expResult, parcel.getBaseCharges(), 0.01);
		}
	}

	
	
	// equivalence partitioning
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "parcelChargeInvalidParams")
	public void testParcelChargeInvalid(int weight, int distance) {
		Parcel parcel = new Parcel(weight, distance);
		parcel.calculateBaseCharges();
	}
	
	private Object[] parcelChargeInvalidParams() {
		return new Object[] {
			new Object[] {-500, 5},
			new Object[] {500, -5},
			new Object[] {1500, -5},
			new Object[] {2500, -5},
			new Object[] {4000, -5},
			new Object[] {5500, -5}
		};
	}
	
	//equivalence partitioning
	@Test
	@Parameters(method = "DocChargeValidParam")
	public void testDocChargeValid(int weight, int distance, double expectedresult) {
		Document doc = new Document(weight,distance);
		doc.calculateBaseCharges();
		double result = doc.getBaseCharges();
		assertEquals(expectedresult, result, 0.01);
	}
	
	private Object[] DocChargeValidParam(){
		
		return new Object[] {
			new Object[] {150,0,3},
			new Object[] {150,35,3},
			new Object[] {650,5,4},
			new Object[] {650,20,5},
			new Object[] {650,35,6},
			new Object[] {2000,5,6},
			new Object[] {2000,20,8},
			new Object[] {2000,35,10},
			new Object[] {4000,5,12},
			new Object[] {4000,20,18},
			new Object[] {4000,35,25},
			new Object[] {6000,5,25},
			new Object[] {6000,20,30},
			new Object[] {6000,35,35},
		};
	}
	// equivalence partitioning
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method = "DocChargeInvalidParam")
	public void testDocChargeInvalid(int weight, int distance) {
		Document doc = new Document(weight,distance);
		doc.calculateBaseCharges();
	}
	
	private Object[] DocChargeInvalidParam(){
		
		return new Object[] {
			new Object[] {-150,0},
			new Object[] {150,-5},
			new Object[] {650,-5},
			new Object[] {2000,-5},
			new Object[] {4000,-5},
			new Object[] {6000,-5,},
		};
	}
	
}
