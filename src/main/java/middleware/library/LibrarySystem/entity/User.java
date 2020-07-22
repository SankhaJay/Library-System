package middleware.library.LibrarySystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    public User() {}

    public User(String nic, String name, int age, String address, int usr_id) {
        super();
        this.usr_id = usr_id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "User [usr_id=" + usr_id + ", name=" + name + ", age=" + age + ", address=" + address + ", nic="
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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
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
    private String nic;
    @GeneratedValue
    private int usr_id;
    private String name;
    private int age;
    private String address;

}
