package middleware.library.LibrarySystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {
    public Employee(){};
    public Employee(int emp_id, String name, int age, String address, int salary) {
        super();
        this.emp_id = emp_id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee [emp_id=" + emp_id + ", name=" + name + ", age=" + age + ", address=" + address + ", salary="
                + salary + "]";
    }
    public int getEmp_id() {
        return emp_id;
    }
    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
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
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Id
    @GeneratedValue
    private int emp_id;
    private String name;
    private int age;
    private String address;
    private int salary;

}