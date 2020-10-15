package middleware.frontend.LibraryFrontend.entity;

import java.util.Date;

public class Admin {
	private int usr_id;
	private String nic;
	private String name;
	private String email;
	private Date dob;
	private String address;
	public int getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(int usr_id) {
		this.usr_id = usr_id;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Admin [usr_id=" + usr_id + ", nic=" + nic + ", name=" + name + ", email=" + email + ", dob=" + dob
				+ ", address=" + address + "]";
	}
	public Admin(String nic, String name, String email, Date dob, String address) {
		super();
//		this.usr_id = usr_id;
		this.nic = nic;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.address = address;
	}
	
	

}
