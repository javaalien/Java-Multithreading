package com.alien.visibility;

import java.util.concurrent.atomic.AtomicInteger;

public class VisibilityProblemSolved {

	static AtomicInteger counter = new AtomicInteger(10);

	public static void main(String[] args) {
		Thread readingThread = new Thread(() -> {
			while (true) {
				if (counter.get() == 11) {
					System.out.println("Counter: " + counter.get());
					break;
				}
			}
		});

		Thread modifyingThread = new Thread(() -> {
			System.out.print("Modifying Counter from " + counter.get());
			System.out.println(" To " + counter.incrementAndGet()); // incrementAndGet() is equal to prefix increment.
		});

		readingThread.start();
		modifyingThread.start();
	}
}
