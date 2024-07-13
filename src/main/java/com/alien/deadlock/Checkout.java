package com.alien.deadlock;

public class Checkout {

	static Product product;

	public synchronized void processPayment() {
		System.out.println(Thread.currentThread().getName() + " Started payment process");

		try {

			System.out.println(
					Thread.currentThread().getName() + " Taking some time to verify payment with partner bank");
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " Completed the payment now need to modify the stock");

		product.modifyStock();
	}
}
