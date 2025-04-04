import java.io.*;
import java.util.*;

public abstract class User {
	protected String ID;
	protected String userName;
	protected String password;
	protected String name;
	protected String email;

	public User(String ID, String userName, String password, String name, String email) {
		// TODO Auto-generated constructor stub
		this.ID = ID;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public abstract String printProfile();
	

}