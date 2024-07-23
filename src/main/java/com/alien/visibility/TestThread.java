package com.alien.visibility;

public class TestThread {

	public static void main(String[] args) {

		Runnable r1 = () -> {
			System.out.println("inside thread");
		};

		Thread t1 = new Thread(r1);
		t1.start();

		new Thread(() -> {
			System.out.println("threads");
		}).start();

	}
}
