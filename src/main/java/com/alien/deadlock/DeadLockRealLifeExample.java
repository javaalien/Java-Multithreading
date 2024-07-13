package com.alien.deadlock;

public class DeadLockRealLifeExample {

	public static void main(String[] args) {

		Product product = new Product();
		Checkout checkout = new Checkout();

		Product.checkout = checkout;
		Checkout.product = product;

		Thread customerOneThread = new Thread(new CustomerOne(product, checkout), "CustomerOneThread");

		Thread customerTwoThread = new Thread(new CustomerTwo(product, checkout), "CustomerTwoThread");

		customerOneThread.start();
		customerTwoThread.start();

	}
}
