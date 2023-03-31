package models;

public class User {
	int uid;
	String fullname;
	String phone;
	String email;
	String loginname;
	String loginpass;
	String role;
	public User() {
		this.uid = 0;
		this.fullname = "";
		this.phone = "";
		this.email = "";
		this.loginname = "";
		this.loginpass = "";
		this.role = "";
	}
	public User(int uid, String fullname, String phone, String email, String loginname, String loginpass, String role) {
		this.uid = uid;
		this.fullname = fullname;
		this.phone = phone;
		this.email = email;
		this.loginname = loginname;
		this.loginpass = loginpass;
		this.role = role;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpass() {
		return loginpass;
	}
	public void setLoginpass(String loginpass) {
		this.loginpass = loginpass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", fullname=" + fullname + ", phone=" + phone + ", email=" + email + ", loginname="
				+ loginname + ", loginpass=" + loginpass + ", role=" + role + "]";
	}
}
