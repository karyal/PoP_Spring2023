package day1.models;

public class User {
	private int uid;
	private String userName;
	private String userPass;
	//Constructors
	public User() {
		this.uid=0;
		this.userName="";
		this.userPass="";
	}
	public User(int uid, String userName, String userPass) {
		this.uid=uid;
		this.userName=userName;
		this.userPass=userPass;
	}
	//Getters
	public int getUID() {
		return this.uid;
	}
	public String getUserName() {
		return this.userName;
	}
	public String getPassword() {
		return this.userPass;
	}
	//Setters
	public void setUID(int uid) {
		this.uid=uid;
	}
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public void setPassword(String userPass) {
		this.userPass=userPass;
	}
	//toString
	public String toString() {
		return this.uid+", "+this.userName+", "+this.userPass;
	}
	
}
