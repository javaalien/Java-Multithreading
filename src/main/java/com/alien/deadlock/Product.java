package com.alien.deadlock;

public class Product {

	static Checkout checkout;

	public synchronized void confirmPurchase() {

		System.out.println(Thread.currentThread().getName() + " Confirming product purchase");

		try {
			System.out.println(Thread.currentThread().getName() + " Went away to another Site");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out
				.println(Thread.currentThread().getName() + " Continuing process and now need to process the payment");

		checkout.processPayment();
	}

	public synchronized void modifyStock() {
		System.out.println(Thread.currentThread().getName() + " Modifying stock in product database.");
	}

}
