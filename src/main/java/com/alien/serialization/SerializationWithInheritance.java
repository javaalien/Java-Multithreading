package com.alien.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
	int id;
	String name;

	Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

class Employee extends Person {
	String company;
	int salary;

	public Employee(int id, String name, String company, int salary) {
		super(id, name);
		this.company = company;
		this.salary = salary;
	}
}

public class SerializationWithInheritance {

	public static void main(String[] args) {

		try {

			Employee emp1 = new Employee(211, "Alien", "Engineering", 50000);

			FileOutputStream fout = new FileOutputStream("employee.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(emp1);

			out.flush();
			out.close();
			System.out.println("Successfully Employee Object Sent to USA\n\n");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.txt"));
			System.out.println("Employee Object coming from INDIA Please Wait....");
			Thread.sleep(2000);

			Employee emp2 = (Employee) in.readObject();

			System.out.println("Successfully Employee Object Received");
			System.out.println(emp2.id + " " + emp2.name + " " + emp2.company + " " + emp2.salary);

			in.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
