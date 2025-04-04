import java.util.*;
import java.io.*;
public class Driver {
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		boolean isTrue = true;
		
		String patientPath = "patient.csv";
		String staffPath = "medicalstaff.csv";
		Login act = new Login();
		
		System.out.println("Medical login System");
		System.out.print("Is this a Patient or Staff Member? [P] or [S]: ");
		char loginType = scnr.next().charAt(0);
		System.out.println();
		
		act.activeLogIn(patientPath, staffPath, loginType);
		
		while(isTrue) {
			System.out.println("***Main Menu***");
			System.out.println("1. Print Profile");
			
			if(loginType == 'P') {
				System.out.println("2.Edit my Information");
			}
			else if(loginType == 'S') {
				System.out.println("2. Search for Patient");
				System.out.println("3.Edit current Patient");
				System.out.println("4. Create Report");
			}
			System.out.println("5. Log Off");
			System.out.print("Select an option: ");
			
			int option = scnr.nextInt();
			System.out.println();
			
			switch(option) {
			case 1:
				PatientManager.displayUserProfile();
				break;
			case 2:
				/*identify if either an instance of patient or staff
				 * if patient, ask which part except of Id and username to be changed
				 * if staff, ask user to search for a specific patient
				 */
			case 3:
				/*
				 * if choosen, staff are allowed to edit patient info
				 * else, invalide due to patient not being allowed to edit in this section
				 */
			case 4:
				/*
				 * Ask user for which type of report to see, three options, being ID,
				 * name, or email(alphabetical order)
				 */
				
			case 5:
				isTrue = false;
				System.out.println("Thank you for using, logging off");
				break;
			default:
				System.out.println("Error, Please Try again: ");
				System.out.println();
				
			}
		}
		
		
		
	}
}
