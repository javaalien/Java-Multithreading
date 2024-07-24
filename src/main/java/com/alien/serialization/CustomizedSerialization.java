package com.alien.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Account implements Serializable {

	String username = "java";
	transient String password = "alien";

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		String encryptPWD = "1234" + password;
		oos.writeObject(encryptPWD);
	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
		String ePwd = (String) ois.readObject();

		password = ePwd.substring(4);
	}
}

public class CustomizedSerialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Account acc1 = new Account();
		
		System.out.println("Before Custom Serialization :");
		
		System.out.println(acc1.username + "----->" + acc1.password);

		FileOutputStream fos = new FileOutputStream("custom.ser");

		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(acc1);

		
		FileInputStream fis = new FileInputStream("custom.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Account acc2 = (Account) ois.readObject();
		System.out.println("\nAfter Custom Serialization :");
		System.out.println(acc2.username + "----->" + acc2.password);

	}
}
