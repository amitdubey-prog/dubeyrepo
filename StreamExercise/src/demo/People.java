package demo;

import java.time.LocalDate;

public class People {
	
	private String name ;
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	private String email ;
	private String Phone ;
	private LocalDate dob;
	private Gender	gender;
	public People(String name, String email, String phone, LocalDate dob, Gender gender) {
		super();
		this.name = name;
		this.email = email;
		Phone = phone;
		this.dob = dob;
		this.gender = gender;
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
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public LocalDate getDob() {
		return dob;
	}
	
	@Override
	public String toString() {
		return "People [name=" + name + ", email=" + email + ", Phone=" + Phone + ", dob=" + dob + ", gender=" + gender
				+ "]";
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
enum Gender{
	
	MALE,FEMALE
}
}
