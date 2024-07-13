package com.alien.visibility;

public class FullVisibilityGuarantee {

	private static int rollNo;
	private static String name = "";
	private volatile static int marks;

	public static void main(String[] args) {

		Thread studentThread = new Thread(() -> {
			while (true) {
				if (marks > 90) {
					System.out.println("Congratulation  " + rollNo + "_" + name + " you got " + marks + " marks ");
					System.out.println("Congratulation You've Passes The Exam!");
					break;
				}
			}
		});

		Thread teacherThread = new Thread(() -> {
			name = name + "Chandresh";
			rollNo = rollNo + 101;
			marks = marks + 92;

			System.out.println("Student " + rollNo + "_" + name + " got " + marks + " marks out of 100");
		});

		studentThread.start();
		teacherThread.start();

	}
}
