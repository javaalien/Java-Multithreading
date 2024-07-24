package com.alien.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//ExecutorService Interface Examples

public class ExecutorServiceExample {

	public static void main(String[] args) {

		System.out.println("Thread main started");

		// Create a task
		Runnable task = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("[" + Thread.currentThread().getName() + "] " + "Message " + i);
			}
		};

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(task);
		executorService.shutdown();

		System.out.println("Thread main finished");

	}

}
