import java.io.*;
import java.util.*;

public class Patient extends User {
	private String treatment;
	
	public Patient(String ID, String userName, String password, String name, String email, String treatment) {
		// TODO Auto-generated constructor stub
		super(ID, userName, password, name, email);
		this.treatment = treatment;
	}
	
	public String getTreatment() {
		return treatment;
	}
	
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	
	@Override
	public String printProfile() {
		return ID + "," + userName + "," + password + "," + name + "," + email + "," + treatment ;
	}
	
	public String outInfo() {
		return "ID of Patient: " + ID + "\nUserName: " + userName + "\nPassword: " + password + "\nName: " + name + "\nEmail: " + email + "\nNotes on Treatment: " + treatment;
	}
	
}