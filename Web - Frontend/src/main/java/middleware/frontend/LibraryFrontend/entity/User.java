package middleware.frontend.LibraryFrontend.entity;

import java.sql.Date;

public class User {
    private String name;
    private String email;
    private String address;
    private String nic;
    private Date dob;

    public void setName(String name) {
        this.name = name;
    }

    public void setNIC(String name) {
        this.nic = name;
    }

    public void setAddress(String name) {
        this.address = name;
    }

    public void setEmail(String name) {
        this.email = name;
    }

    public void setDOB(Date dob) {
        this.dob = dob;
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

}
