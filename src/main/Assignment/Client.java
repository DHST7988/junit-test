package Assignment;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

	public void register(String regName, String regAddress,String regNum)throws IOException{
		if (regName == null || regAddress == null || regNum == null ||
				regName.length() == 0 || regAddress.length() == 0 || regNum.length() == 0)
			throw new IllegalArgumentException();
		FileWriter fw = new FileWriter("client.txt", true);
		PrintWriter outputFile = new PrintWriter(fw);
		outputFile.println(regName + ";" + regAddress + ";" + regNum);
		outputFile.close();
    }
	
	public boolean searchClient(String name) throws IOException {
		if (name == null || name.length() == 0)
			throw new IllegalArgumentException();
		
		ArrayList<String[]> linesRead = new ArrayList<>();
		
		Scanner inputStream = null;
		
		try {
			inputStream = new Scanner(new File("client.txt"));
		}
		catch(FileNotFoundException e) {
			System.out.println("Error in opening the file client.txt");
			System.exit(0);
		}
		
		while(inputStream.hasNextLine()) {
			String singleLine = inputStream.nextLine();
			String[] tokens = singleLine.split(";");
			linesRead.add(tokens);
		}
        
		for (String[] strArray:linesRead) {
           if(strArray[0].equals(name)){
        	   return true;
           }
        }
        return false;
	}
}
