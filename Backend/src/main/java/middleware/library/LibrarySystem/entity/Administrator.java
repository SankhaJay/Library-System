package middleware.library.LibrarySystem.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="newadmin")
public class Administrator {
	
	public Administrator() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
    @GeneratedValue
    private int aId;
    @Column(length=11)
    private String nic;
    private String name;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private String address;
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
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
	public Administrator(int aId, String nic, String name, String email, Date dob, String address) {
		super();
		this.aId = aId;
		this.nic = nic;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	@Override
	public String toString() {
		return "Administrator [aId=" + aId + ", nic=" + nic + ", name=" + name + ", email=" + email + ", dob=" + dob
				+ ", address=" + address + "]";
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

}
