import java.io.*;
import java.util.*;

public class MedicalStaff extends User{
	private String department;

	public MedicalStaff(String ID, String userName, String password, String name, String email, String department) {
		// TODO Auto-generated constructor stub
		super(ID, userName, password, name, email);
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	@Override
	public String printProfile() {
		return ID + "," + userName + "," + password + "," + name + "," + email + "," + department ;
	}
	
	public String outInfo() {
		return "ID of Patient: " + ID + "\nUserName: " + userName + "\nPassword: " + password + "\nName: " + name + "\nEmail: " + email + "\nDepartment location: " + department;
	}
	
	}

