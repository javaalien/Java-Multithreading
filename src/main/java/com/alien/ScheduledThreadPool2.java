package com.alien;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool2 {

	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

		CountDownLatch count = new CountDownLatch(2);

		Runnable runnableJob = () -> {
			System.out.println("Started Execution On:" + LocalDateTime.now());
			for (int i = 0; i < 5; i++) {
				System.out.println("Hello World : " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}

			System.out.println("Completed Execution On:" + LocalDateTime.now());
			count.countDown();
			System.out.println("\n");
		};

		executorService.scheduleAtFixedRate(runnableJob, 5, 5, TimeUnit.SECONDS);
		count.await();
		executorService.shutdown();
	}

}
