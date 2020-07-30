package middleware.frontend.LibraryFrontend.entity;


import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class User {
    private String name;
    private String email;
    private String address;
    private String nic;
    private String dob;
    private int usr_id;

    public void setName(String name) {
        this.name = name;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setAddress(String name) {
        this.address = name;
    }

    public void setEmail(String name) {
        this.email = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setUsr_id(int id) {
        this.usr_id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getNic() {
        return this.nic;
    }

    public String getEmail() {
        return this.email;
    }

    public String getDob() { return this.dob; }

    public int getUsr_id() { return this.usr_id; }

}
