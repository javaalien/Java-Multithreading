package com.alien.serialization;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Doctor implements Externalizable {

	private String name;
	private int age;

	public Doctor() {
		super();
	}

	public Doctor(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeObject(age);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
		age = (int) in.readObject();
	}
}

public class ExternalizationExample {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		File f = new File("external.txt");

		Doctor doc = new Doctor("Mr. Alien", 100);

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));

		out.writeObject(doc);

		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));

		Doctor d1 = (Doctor) in.readObject();

		System.out.println("After De externalization Name: " + d1.getName() + " and age is:" + d1.getAge());

	}
}
