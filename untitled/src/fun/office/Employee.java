package fun.office;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


import static org.fun.office.Gender.*;
import static org.fun.office.Department.*;

public class Employee {

	int id;
	String firstName;
	String lastName;
	Gender gender;
	LocalDate dateOfJoining;
	Department department;

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public Department getDepartment() {
		return department;
	}

	public Employee(){}

	public Employee(int id, String firstName, String lastName, Gender gender, LocalDate dateOfJoining, Department department) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfJoining = dateOfJoining;
		this.department = department;
	}

	@Override
	public String toString() {
		return  getFullName();
	}

	public String getYearsInADPText(){
		Period p = Period.between(dateOfJoining,LocalDate.now());
		return p.getYears() + "." + p.getMonths() + " years";
	}

	public double getYearsInADP(){
		Period p = Period.between(dateOfJoining,LocalDate.now());
		return p.getYears() + p.getMonths()/12d;
	}

	public String fullDetails() {
		return id +
				": " + firstName + ' ' + lastName +
				" (" + gender +
				"), JoinedOn: " + dateOfJoining +
				", Department: " + department;
	}

	public static List<Employee> getEmployees() {
		List<Employee> members = new ArrayList<>();
		Employee travolta = new Employee(10001, "John", "Travolta", MALE, LocalDate.of(2001, 4, 2), Technology);
		members.add(travolta);
		members.add(travolta);
		members.add(new Employee(10002, "Tom", "Cruise", MALE, LocalDate.of(2002, 3, 14), Admin));
		members.add(new Employee(10003, "Brad", "Pitt", MALE, LocalDate.of(2003, 4, 25), Finance));
		members.add(new Employee(10004, "Tom", "Hanks", MALE, LocalDate.of(2004, 7, 18), HR));
		members.add(new Employee(10005, "Will", "Smith", MALE, LocalDate.of(2005, 10, 3), Admin));
		members.add(new Employee(10020, "Julia", "Roberts", FEMALE, LocalDate.of(2009, 6, 2), Finance));
		members.add(new Employee(10021, "Angelina", "Jolie", FEMALE, LocalDate.of(2012, 6, 30), BPO));
		members.add(new Employee(10022, "Meg ", "Ryan", FEMALE, LocalDate.of(2014, 7, 7), Technology));
		return members;
	}

}
