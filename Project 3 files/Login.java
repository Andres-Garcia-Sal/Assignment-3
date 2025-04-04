import java.io.*;
import java.util.*;

public class Login {
	private ArrayList<String[]> insertData = new ArrayList<>();
	private ArrayList<Patient> patientList = new ArrayList<>();
	private ArrayList<MedicalStaff> staffList = new ArrayList<>();
	
	public void activeLogIn(String patientPath, String staffPath, char loginType) {
		boolean isTrue = false;
		Scanner scnr = new Scanner(System.in);
		
		while(loginType != 'P' && loginType != 'S') {
			System.out.print("Error, input invalid. Try Again: ");
			loginType = scnr.next().charAt(0);
			System.out.println();
			scnr.nextLine();
		}
		
		boolean loggedIn = false;
		
		while (!loggedIn) { 
	            System.out.print("Please enter Username: ");
	            String username = scnr.nextLine();
	            System.out.print("Please enter Password: ");
	            String password = scnr.nextLine();
	            System.out.println();

	            if (loginType == 'P') {
	                ArrayList<String[]> dataP = loadData(patientPath, loginType);
	                if (validLogin(dataP, username, password)) {
	                    System.out.println("Login Successful");
	                    loggedIn = true; // Set to true to exit loop
	                } else {
	                    System.out.println("Error: login invalid. Try again.");
	                    System.out.println();
	                }
	            } else if (loginType == 'S') {
	                ArrayList<String[]> dataP = loadData(staffPath, loginType);
	                if (validLogin(dataP, username, password)) {
	                    System.out.println("Login Successful");
	                    loggedIn = true; // Set to true to exit loop
	                } else {
	                    System.out.println("Error: login invalid. Try again.");
	                    System.out.println();
	                }
	            }
	        }
		
	}
	
	public boolean validLogin(ArrayList<String[]> dataP, String userName, String password) {
		boolean istrue = false;
		for(String[] user : dataP) {
			if(user[1].equals(userName) && user[2].equals(password)) {
				istrue = true;
				break;
			}
		}
		return istrue;
	}

	
	public ArrayList<String[]> loadData(String filePath, char loginType) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] values = line.split(",");
                insertData.add(values);
                addDataToList(values, loginType);
            }
        } catch (IOException e) {
            e.printStackTrace();  // Handle the exception, could log or throw as needed
        } finally {
            try {
                if (br != null) {
                    br.close();  // Ensure the BufferedReader is closed
                }
            } catch (IOException e) {
                e.printStackTrace();  // Handle the exception during close
            }
        }
        return insertData;
    }
	
	public void addDataToList(String[] values, char userType) {
        if (userType == 'P') {
            // Create a new Patient object and add to the patientList
            Patient patient = new Patient(values[0], values[1], values[2], values[3], values[4], values[5]);
            patientList.add(patient);
        } else if (userType == 'S') {
            // Create a new MedicalStaff object and add to the staffList
            MedicalStaff staff = new MedicalStaff(values[0], values[1], values[2], values[3], values[4], values[5]);
            staffList.add(staff);
        }
   }
}
