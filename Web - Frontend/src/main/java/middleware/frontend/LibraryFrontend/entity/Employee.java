package middleware.frontend.LibraryFrontend.entity;

public class Employee {
	
	public Employee(String name, int age, String address, int salary) {
		super();
//		this.emp_id = emp_id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", address=" + address + ", salary="
				+ salary + "]";
	}
	private int emp_id;
	private String name;
	private int age;
	private String address;
	private int salary;
//	private String nic;
//	public String getNic() {
//		return nic;
//	}
//	public void setNic(String nic) {
//		this.nic = nic;
//	}
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

}
