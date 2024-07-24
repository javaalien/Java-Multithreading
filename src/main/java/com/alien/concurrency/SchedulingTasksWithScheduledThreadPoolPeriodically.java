package com.alien.concurrency;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulingTasksWithScheduledThreadPoolPeriodically {

	public static void main(String[] args) {

		System.out.println("Thread main started");

		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

		// Create a task
		Runnable task1 = () -> {
			System.out.println("Executing the task1 at: " + new Date());
		};

		scheduledExecutorService.scheduleAtFixedRate(task1, 0, 2, TimeUnit.SECONDS);

		System.out.println("Thread main finished");

	}

}
