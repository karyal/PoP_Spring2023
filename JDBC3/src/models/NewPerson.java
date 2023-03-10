package models;

public class NewPerson {
	private int pid;
	private String name;
	private String address;
	private String email;

	public NewPerson() {
		this.pid = 0;
		this.name = "";
		this.address = "";
		this.email= "";
	}

	public NewPerson(int pid, String name, String address, String email) {
		this.pid = pid;
		this.name = name;
		this.address = address;
		this.email= email;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "NewPerson [pid=" + pid + ", name=" + name + ", address=" + address + ", email=" + email + "]";
	}	
}