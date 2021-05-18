package demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import demo.People.Gender;

public class Person {

	public static void main(String[] args) {

		List<String> human = List.of("Amit", "Amit", "sumit", "Ramesh");
		System.out.println("Printing Duplicate List element using Lambda");
		human.forEach(name -> System.out.println(name));

		System.out.println();
		System.out.println("Printing Duplicate List element using Methid Refrene");
		human.forEach(System.out::println);
		System.out.println();
		System.out.println("Printing  List element using using stream without Duplicate");
		human.stream().collect(Collectors.toSet()).forEach(name -> System.out.println(name.toUpperCase()));
		System.out.println();

		// People people = new People("Amit", "amitdubey866@gmail.com", "7276502163",
		// LocalDate.of(1990, 02, 10));

		List<People> people = List.of(
				new People("Amit", "amitdubey866@gmail.com", "7276502163", LocalDate.of(1990, 02, 10), Gender.MALE),
				new People("Amit", "ajitdubey866@gmail.com", "1234567", LocalDate.of(1981, 02, 10), Gender.MALE),
				new People("Rahul", "Rahuldubey866@gmail.com", "222222", LocalDate.of(1992, 02, 10), Gender.MALE),
				new People("Pallavi", "pdubey866@gmail.com", "7276", LocalDate.of(1997, 02, 10), Gender.FEMALE),
				new People("Priya", "priyadubey866@gmail.com", "11111111", LocalDate.of(1993, 02, 10), Gender.FEMALE),
				new People("Rani", "Ranidubey866@gmail.com", "78888888", LocalDate.of(1996, 02, 10), Gender.FEMALE),
				new People("Ramesh", "rameshdubey866@gmail.com", "799999999", LocalDate.of(2000, 02, 10), Gender.MALE));

		// people.forEach(name -> System.out.println(name));

		people.stream()
				.filter(name -> name.getName().equalsIgnoreCase("Amit")
						&& name.getEmail().equalsIgnoreCase("amitdubey866@gmail.com"))
				// .filter(name -> name.getGender().equals(Gender.MALE))
				.collect(Collectors.toList()).forEach(name -> System.out.println(name));

		System.out.println();

		System.out.println("Gropup By DOB and uses 'mapping' to convert Lsit<Person> to List<String>");

		// boolean allMatch = people.stream().anyMatch(name ->
		// name.getName().equalsIgnoreCase("Amit"));
		// System.out.println(allMatch);

		Map<LocalDate, List<String>> groupBydob = people.stream().collect(
				Collectors.groupingBy(People::getDob, Collectors.mapping(People::getName, Collectors.toList())));

		System.out.println(groupBydob);
		System.out.println();
		Map<String, Long> counting = people.stream()
				.collect(Collectors.groupingBy(People::getName, Collectors.counting()));
		System.out.println(counting);
		System.out.println();

		Map<Gender, Long> countingGender = people.stream()
				.collect(Collectors.groupingBy(People::getGender, Collectors.counting()));
		System.out.println(countingGender);
		System.out.println();
		// Accumulate names into a List
		List<String> list = people.stream().map(People::getName).collect(Collectors.toList());
		System.out.println(list);

		// Accumulate names into a TreeSet
		Set<String> set = people.stream().map(People::getName).collect(Collectors.toCollection(TreeSet::new));
		System.out.println(set);

		// Compute sum of salaries of employee
		List<Employee> employee = List.of(new Employee(1, "Amit", 2000, 20, "amitdubey866@gmail.com ", "IT"),
				new Employee(2, "Ajit", 1100, 27, "ajitdubey@gmail.com ", "IT"),
				new Employee(3, "Pragati", 2200, 18, "pragati@gmail.com ", "HR"),
				new Employee(4, "Reshma", 3300, 25, "reshma@gmail.com ", "HR"));

		int total = employee.stream().collect(Collectors.summingInt(Employee::getSalary));
		System.out.println(total);

		// Group employees by department
		Map<String, List<Employee>> byDept = employee.stream().collect(Collectors.groupingBy(Employee::getDept));
		System.out.println(byDept);
		System.out.println("Limit 2 and age >=20 print only");

		employee.stream().filter(emp -> emp.getAge() >= 20).limit(2).collect(Collectors.toList())
				.forEach(emp -> System.out.println(emp));

		System.out.println("for i");

		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}

		System.out.println("exclusive");

		IntStream.range(0, 10).forEach(System.out::println);

		System.out.println("inclusive");

		IntStream.rangeClosed(0, 10).forEach(System.out::println);

		IntStream.range(0, people.size()).forEach(index -> {
			People person = people.get(index);
			System.out.println(person);
		});

		IntStream.iterate(0, operand -> operand + 1).filter(number -> number % 2 == 0).limit(20)
				.forEach(System.out::println);
		System.out.println("print minimum number");
		final List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
		int min = numbers.stream().min(Comparator.naturalOrder()).get();

		System.out.println(min);

		final Predicate<Employee> Employeesalary = emp -> emp.getSalary() >= 2000;
		employee.stream().filter(Employeesalary).collect(Collectors.toList()).forEach(System.out::println);

		// transform from one data type to another

		employee.stream().map(EmployeeDTO::map).collect(Collectors.toList()).forEach(System.out::println);
		Double avg = employee.stream().mapToDouble(Employee::getSalary).average().orElse(0);
		System.out.println("average salary of employee : " + avg);
		final Predicate<Integer> numbergreaterthan50 = a -> a > 50;
		Integer greaterthan50 = numbers.stream().filter(numbergreaterthan50).findAny().get();
		System.out.println("Number greater than 50 : " + greaterthan50);

		numbers.stream().filter(numbergreaterthan50).collect(Collectors.toList()).forEach(System.out::println);
		people.stream().filter(name -> name.getGender().equals(Gender.FEMALE)).collect(Collectors.toList())
				.forEach(System.out::println);

		double ITminsal = employee.stream().filter(name -> name.getDept().equalsIgnoreCase("IT"))
				.mapToDouble(Employee::getSalary).min().orElse(0);
		System.out.println("IT deartment employee mininum salary  : " + ITminsal);

		List<String> names = List.of("John", "John", "Mariam", "Alex", "Mohammado", "Mohammado", "Vincent", "Alex",
				"Alex");

		Map<String, Long> counting1 = names.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		counting1.forEach((name, count) -> System.out.println(name + " > " + count));

		Integer[] integers = { 1, 2, 3, 4, 99, 100, 121, 1302, 199 };
		int sum2 = Arrays.stream(integers).reduce(0, Integer::sum);

		System.out.println(sum2);

		List<String> names1 = List.of("anna", "john", "marcos", "helena", "yasmin");

		String joiningBycomma = names1.stream().collect(Collectors.joining(","));

		System.out.println(joiningBycomma);

	}

}
