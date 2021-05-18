package demo;

public class Employee {

	private  Integer id;
	private String name ;
	private Integer salary;
	private int age;
	private String emailId;
	private String dept;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Employee(Integer id, String name, Integer salary, int age, String emailId, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.emailId = emailId;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + ", emailId=" + emailId
				+ ", dept=" + dept + "]";
	}
	
	
	
}
