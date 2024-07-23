package com.alien.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dog implements Serializable {

	int i = 10;
	int j = 20;

	void bark() {
		System.out.println("Dog is barking after eating " + i + " Leg piece");
	}
}

public class SerializationExample {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

		Dog dog1 = new Dog();
		FileOutputStream fos = new FileOutputStream("dog.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(dog1);
		oos.flush();
		oos.close();
		System.out.println("successfully Dog Object Serialized");

		System.out.println("DeSerializing wait.....");
		Thread.sleep(2000);

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("dog.txt"));
		Dog dog2 = (Dog) in.readObject();
		System.out.println("successfully Dog Object DeSerialized");
		System.out.println(dog2.i + " " + dog2.j);
		dog2.bark();
		in.close();
	}
}
