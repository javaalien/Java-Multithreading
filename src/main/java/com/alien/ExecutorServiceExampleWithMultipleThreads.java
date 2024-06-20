package com.alien;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//ExecutorService example with multiple threads and tasks

public class ExecutorServiceExampleWithMultipleThreads {

	public static void main(String[] args) {

		System.out.println("Thread main started");

		// Create a task
		Runnable task1 = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("[" + Thread.currentThread().getName() + "] " + "Message " + i);
			}
		};

		// Create a task
		Runnable task2 = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("[" + Thread.currentThread().getName() + "] " + "Message " + i);
			}
		};

		// Create a task
		Runnable task3 = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("[" + Thread.currentThread().getName() + "] " + "Message " + i);
			}
		};

		// Create a task
		Runnable task4 = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("[" + Thread.currentThread().getName() + "] " + "Message " + i);
			}
		};

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.execute(task1);
		executorService.execute(task2);
		executorService.execute(task3);
		executorService.execute(task4);

		System.out.println("Thread main finished");

		executorService.shutdown();

	}
}
