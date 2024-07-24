package com.alien.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample3 {

	public static void main(String[] args) {

		CountDownLatch cd1 = new CountDownLatch(5);
		CountDownLatch cd2 = new CountDownLatch(5);
		CountDownLatch cd3 = new CountDownLatch(5);
		CountDownLatch cd4 = new CountDownLatch(5);

		ExecutorService es = Executors.newFixedThreadPool(2);

		System.out.println("Starting");

		es.execute(new MyThread(cd1, "A"));
		es.execute(new MyThread(cd2, "B"));
		es.execute(new MyThread(cd3, "C"));
		es.execute(new MyThread(cd4, "D"));

		try {
			cd1.await();
			cd2.await();
			cd3.await();
			cd4.await();

		} catch (Exception e) {
			System.out.println(e);
		}
		es.shutdown();
		System.out.println("Done");
	}
}

class MyThread implements Runnable {

	String name;
	CountDownLatch latch;

	MyThread(CountDownLatch latch, String name) {
		this.name = name;
		this.latch = latch;
		new Thread(this);
	}

	public void run() {

		for (int i = 0; i < 5; i++) {
			System.out.println(name + ": " + i);
			latch.countDown();
		}
	}
}