package com.alien.visibility;

public class VisibilityProblem {

	private static int counter = 10;

	public static void main(String[] args) {
		Thread readingThread = new Thread(() -> {
			while (true) {
				if (counter == 11) {
					System.out.println("Counter: " + counter);
					break;
				}
			}
		});

		Thread modifyingThread = new Thread(() -> {
			System.out.print("Modifying Counter from " + counter);
			counter++;
			System.out.println(" To " + counter);
		});
		readingThread.start();
		modifyingThread.start();
	}
}
