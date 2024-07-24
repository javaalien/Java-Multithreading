package com.alien.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Let’s understand both CountDownLatch and CyclicBarrier concepts using an example.

public class CollectingDataFromDifferentFiles {

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch count = new CountDownLatch(2);

		Runnable mergeJob = () -> {
			System.out.println("\n");
			System.out.println("Merging Data Into A Final File");
			System.out.println("Task Performed By:" + Thread.currentThread().getName() + "\n\n");
			count.countDown();
		};

		CyclicBarrier firstFiveFileBarrier = new CyclicBarrier(3, mergeJob);
		CyclicBarrier endBarrier = new CyclicBarrier(3, mergeJob);

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		executorService.submit(() -> {
			try {
				for (int i = 1; i <= 10; i++) {
					System.out.println(Thread.currentThread().getName() + " Getting Data From File:" + i);

					if (i == 5) {
						firstFiveFileBarrier.await();
					}
				}
				endBarrier.await();
			} catch (InterruptedException | BrokenBarrierException exception) {
				System.out.println(Thread.currentThread().getName() + "...." + exception.getClass().getName());
			}
		});

		executorService.submit(() -> {
			try {
				for (int i = 11; i <= 20; i++) {
					System.out.println(Thread.currentThread().getName() + " Getting Data From File:" + i);

					if (i == 15) {
						firstFiveFileBarrier.await();
					}
				}
				endBarrier.await();
			} catch (InterruptedException | BrokenBarrierException exception) {
				System.out.println(Thread.currentThread().getName() + "...." + exception.getClass().getName());
			}
		});

		executorService.submit(() -> {
			try {
				for (int i = 21; i <= 30; i++) {
					System.out.println(Thread.currentThread().getName() + " Getting Data From File:" + i);

					if (i == 25) {
						firstFiveFileBarrier.await();
					}
				}
				endBarrier.await();
			} catch (InterruptedException | BrokenBarrierException exception) {
				System.out.println(Thread.currentThread().getName() + "...." + exception.getClass().getName());
			}
		});
		count.await();
		executorService.shutdown();
	}
}
