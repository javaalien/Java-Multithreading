package com.alien.deadlock;

public class CustomerOne implements Runnable {

	Product product;
	Checkout checkout;

	public CustomerOne(Product product, Checkout checkout) {
		this.product = product;
		this.checkout = checkout;
	}

	@Override
	public void run() {
		product.confirmPurchase();
	}

}
