package com.alien.deadlock;

public class CustomerTwo implements Runnable {

	Product product;
	Checkout checkout;

	public CustomerTwo(Product product, Checkout checkout) {
		this.product = product;
		this.checkout = checkout;
	}

	@Override
	public void run() {
		checkout.processPayment();
	}
}
