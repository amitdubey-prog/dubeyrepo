package demo;

public class EmployeeDTO {

	private  Integer id;
	private String name ;
	private int age;
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public EmployeeDTO(Integer id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	
	public static EmployeeDTO map(Employee employee) {
	    return new EmployeeDTO(employee.getId(), employee.getName(), employee.getAge());
	  }
}
