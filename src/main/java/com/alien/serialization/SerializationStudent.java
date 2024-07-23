package com.alien.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {
	int id;
	String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

class Persist {
	public static void persist() {
		try {
			Student s1 = new Student(211, "Alien");
			FileOutputStream fout = new FileOutputStream("file.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(s1);
			out.flush();
			out.close();
			System.out.println("Successfully Student Object Serialized");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class Depersist {
	public static void depersist() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.txt"));
			Student s = (Student) in.readObject();
			System.out.println("Successfully Student Object DeSerialized");
			System.out.println(s.id + " " + s.name);
			in.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

public class SerializationStudent {

	public static void main(String[] args) throws InterruptedException {

		Persist.persist();

		System.out.println("DeSerializing wait.....");
		Thread.sleep(2000);

		Depersist.depersist();
	}
}