package com.alien.concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

	static int counter = 0;

	public static void main(String[] args) {

		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

		Runnable runnableJob = () -> {
			System.out.println("Started Execution On:" + LocalDateTime.now());
			System.out.println("Hello World " + counter++);
			System.out.println("Completed Execution On:" + LocalDateTime.now());
			System.out.println("\n");
		};
		scheduledExecutorService.scheduleAtFixedRate(runnableJob, 5, 5, TimeUnit.SECONDS);
	}
}
