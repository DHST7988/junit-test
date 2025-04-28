package Assignment;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public class DeliveryExpert {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//initialize deliveryStaff list
		
		Scanner input = new Scanner (System.in);
		String menuLoop = "y";
		while (menuLoop.equals("y")) {
			boolean validNameEntered = false;
			boolean found = false;
			Client client = new Client();
			String name = null;
			do {
			    name = mainMenu();
			    try {
			    	found = client.searchClient(name);
			    	validNameEntered = true;
			    }catch (IllegalArgumentException iae) {
			    	System.out.println("Error. Please re-input the data again ");
			    }
			} while (!validNameEntered);

			if (!found)
			{   
				System.out.println();
				System.out.println("Client not found");
				System.out.println();
				System.out.println("Register new client");
				System.out.print("Client's address: ");
				String address =  input.nextLine();
				System.out.print("Client's Phone Number: ");
				String number =  input.nextLine();

				try{
		            client.register(name, address, number);
		        }
		        catch (IOException ex){
		            System.out.println("Error. Please re-input the data again ");
		        }
			}

			System.out.print("Enter item type (document/parcel): ");
			String item = input.nextLine();
			
			//To get the weight of the item
			System.out.print("Enter " + item +"'s weight (gram)(rounded to integer): ");
			int weight = input.nextInt();
			
			System.out.print("Enter delivery distance (km)(rounded to integer): ");
			int distance = input.nextInt();
			String skip = input.nextLine();
			
			//To determine the delivery date
			System.out.print("Enter delivery date (2022-03-12): ");
			String date = input.nextLine();
			boolean sameDayDelivery = false;
			if (date.equals(currentDate()))
				sameDayDelivery = true;
			
			//To determine the insurance
			System.out.print("With insurance? (y/n): ");
	    	char insuranceInput = input.nextLine().toLowerCase().charAt(0);
	    	boolean insurance = false;
	    	if (insuranceInput == 'y')
	    		insurance = true;
	    	
			switch (item.toLowerCase()) {
			case "document":
				Document doc = new Document(weight, distance);
		
				doc.calculateBaseCharges();
				doc.calculateAdditionalCharges(sameDayDelivery, insurance);
				doc.calculateTotalCharges();
				
			    // Display delivery notes
				doc.printDeliveryNote();
				doc.sendEmail();
				break;
			
			case "parcel":
				Parcel par = new Parcel(weight, distance);
				par.calculateBaseCharges();
				par.calculateAdditionalCharges(sameDayDelivery, insurance);
				par.calculateTotalCharges();
				
				// Display delivery notes
				par.printDeliveryNote();
				par.sendEmail();
				break;
				
			default:
				System.out.println("Invalid input! Please re-enter the item name! ");
				System.out.println("Please make sure the name consist of alphabets only and without space");
				break;
			}
			menuLoop = returnMenu();
		}
		System.out.println("Thanks for using the system");		
	}
	
	public static String currentDate(){
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		String strDate = dateFormat.format(date);
		return strDate;
	}
	
	public static String mainMenu() {
		Scanner input = new Scanner (System.in);
		System.out.println("--------------Welcome to DeliveryExpert---------------");
		System.out.print("Please enter the client name: ");
		String name = input.nextLine();
		return name;
	}
	
	public static String returnMenu() {
		System.out.print("Do you wish to return to main menu? (y/n): ");
		Scanner input = new Scanner (System.in);
		String choice = input.nextLine();
		choice.toLowerCase();
		return choice;
	}

}
