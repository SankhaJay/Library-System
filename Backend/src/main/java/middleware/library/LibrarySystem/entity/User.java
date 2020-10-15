package middleware.library.LibrarySystem.entity;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "user")
public class User {	

    public User() {}

    public User(int id,String nic, String name, Date dob, String address, String email) {
        super();
        this.usr_id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.nic = nic;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [usr_id=" + usr_id + ", name=" + name + ", age=" + dob + ", address=" + address + ", nic="
                + nic + "]";
    }

    public int getUsr_id() {
        return usr_id;
    }
    public void setUsr_id(int emp_id) {
        this.usr_id = emp_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getNic() {
        return nic;
    }
    public void setNic(String nic) {
        this.nic = nic;
    }

    @Id
    @GeneratedValue
    private int usr_id;
    @Column(length=11)
    private String nic;
    private String name;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private String address;

}
