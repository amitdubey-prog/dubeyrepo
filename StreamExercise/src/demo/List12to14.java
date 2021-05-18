package demo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import demo.People.Gender;

public class List12to14 {

	public static void main(String[] args) {
		
		List<People> people = List.of(
				new People("Amit", "amitdubey866@gmail.com", "7276502163", LocalDate.of(1990, 02, 10), Gender.MALE),
				new People("Amit", "ajitdubey866@gmail.com", "1234567", LocalDate.of(1981, 02, 10), Gender.MALE),
				new People("Rahul", "Rahuldubey866@gmail.com", "222222", LocalDate.of(1992, 02, 10), Gender.MALE),
				new People("Pallavi", "pdubey866@gmail.com", "7276", LocalDate.of(1997, 02, 10), Gender.FEMALE),
				new People("Priya", "priyadubey866@gmail.com", "11111111", LocalDate.of(1993, 02, 10), Gender.FEMALE),
				new People("Rani", "Ranidubey866@gmail.com", "78888888", LocalDate.of(1996, 02, 10), Gender.FEMALE),
				new People("Ramesh", "rameshdubey866@gmail.com", "799999999", LocalDate.of(2000, 02, 10), Gender.MALE));

		
		List<Employee> employee = List.of(new Employee(1, "Amit", 2000, 20, "amitdubey866@gmail.com ", "IT"),
				new Employee(2, "Ajit", 1100, 27, "ajitdubey@gmail.com ", "IT"),
				new Employee(3, "Pragati", 2200, 18, "pragati@gmail.com ", "HR"),
				new Employee(4, "Reshma", 3300, 25, "reshma@gmail.com ", "HR"));
		
		
		people.stream()
			.map(People::getEmail)
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		

		
		System.out.println(
				employee.stream()
			.filter(emp -> {
				System.out.println("filter Employee : " + emp);
				return emp.getSalary() >=2000;
			})
			
			.map(emp -> {
				
				System.out.println("Map Employee : " + emp);
				return emp.getSalary();
				
			})
			.map(salary -> {
	              System.out.println("mapping salary " + salary);
	              return salary + (salary * .14);
	            })
			 .collect(Collectors.toList())
			);
	}

}
