import java.util.*;

public class PatientManager{
	private User loginUser;
	private Patient currentP;
	private ArrayList<Patient> allPatients;

	public PatientManager(User userNew, ArrayList<Patient> patient) {
		this.loginUser = userNew;
		this.allPatients = patient;
		
		if(loginUser instanceof Patient) {
			this.currentP = (Patient) loginUser;
		}
	}
	
	public static void currentProfile() {
		
	}
	
	//Note, dont forget to include the report method/class for it to be overrriden/saved onto csv file
	

}
