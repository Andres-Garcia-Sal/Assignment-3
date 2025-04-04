import java.util.*;

public class PatientManager{
	private static User loginUser;
	private static Patient currentPatient;
	private static ArrayList<Patient> allPatients;
	private Scanner sc = new Scanner(System.in);

	public PatientManager(User userNew, ArrayList<String[]> patientData) {
		this.loginUser = userNew;
		this.allPatients = new ArrayList<>();
		
		for(String[] patientInfo: patientData) {
			 if (patientInfo.length >= 6) {
	                String id = patientInfo[0];
	                String username = patientInfo[1];
	                String password = patientInfo[2];
	                String name = patientInfo[3];
	                String email = patientInfo[4];
	                String treatment = patientInfo[5];
	                allPatients.add(new Patient(id, username, password, name, email, treatment));
	            }
		}
		sortById();
	}
	
	 public ArrayList<Patient> getPatients() {
	        return allPatients;
	    }
	 
	 public Patient getPatientById(String id) {
	        for (Patient patient : allPatients) {
	            if (patient.getID().equals(id)) {
	                return patient;
	            }
	        }
	        return null; // Patient not found
	    }

	public static void displayUserProfile() {
		System.out.printf("Information about user: %s",loginUser.printProfile());
	}

	public void managePatients(){
		int selection=0;
		if(loginUser instanceof Patient){
			currentPatient = (Patient)loginUser;
		}
		do {
			System.out.println("Select an option:\n1:View your user information.\n2:Look up a patient(Available to staff only).\n3:Edit selected patient. (If you are a patient, you can edit your information here.)\n Otherwise, press any other key to return to the previous menu.");
			try {
				selection = sc.nextInt();
			} catch (Exception InputMismatchException) {
				return;
			} finally {
				switch (selection) {
					case 1:
						displayUserProfile();
						break;
					case 2:
						if(loginUser instanceof Patient){
							System.out.println("Patients are denied access to this funtion.");
							break;
						}
						while(true){
							System.out.println("Input the id of the patient to look up.");
							if(sc.hasNextInt()){
								int patientSearchResultIdx = binarySearch(sc.nextInt());
								if(patientSearchResultIdx==-1){
									System.out.println("Patient not found. Try again.");
									continue;
								} else {
									currentPatient = allPatients.get(patientSearchResultIdx);
									break;
								}
							}
							break;
						}
						break;
					case 3:
						EditPatientLoop:
						while(true){
							System.out.println("Input what information you wish to edit. Valid options are 'password', 'name', 'email', 'treatment_notes'. Input 'SaveAndExit' if you wish to exit this menu.");
							switch (sc.next()) {
								case "SaveAndExit":
								
									break EditPatientLoop;
								case "password":
									System.out.println("Input the new password. To indicate the end of your password, press the Enter key.");
									currentPatient.setPassword(sc.nextLine());
									break;
								case "email":
									System.out.println("Input the new email.");
									currentPatient.setEmail(sc.next());
									break;
								case "name":
								System.out.println("Input the new name. To indicate the end of your input, press the Enter key.");
								currentPatient.setName(sc.nextLine());
								break;
								case "treatment_notes":
								System.out.println("Input the new treatment notes. To indicate the end of your input, press the Enter key.");
								currentPatient.setPassword(sc.nextLine());
									break;
								default:
									System.out.println("Invalid input. Try again.");
									break;
							}
						}
						break;
					default:
						return;
				}
			}
		} while (true);
	}
	private static int binarySearch(int id){
		int low = 0;
		int high = allPatients.size()-1;
		int mid;
		while(low<=high){
			mid = (low+high)/2;
			if(Integer.parseInt(allPatients.get(mid).getID())==id){
				return mid;
			} else if (Integer.parseInt(allPatients.get(mid).getID())>id){
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		return -1;
		}

		private static void sortById(){
			for(int i = 0; i < allPatients.size()-1; i++){
				for(int j = 0; j < allPatients.size()-i-1; j++){
					if(Integer.parseInt(allPatients.get(j).getID())>Integer.parseInt(allPatients.get(j+1).getID())){
						Collections.swap(allPatients, j, j+1);
					}
				}
			}
		}

	
	//Note, dont forget to include the report method/class in here or in sepereate class for that function to output
	

}
