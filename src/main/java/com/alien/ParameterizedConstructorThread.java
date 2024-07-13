package com.alien;

class EchoThread implements Runnable {

	private String message;

	EchoThread(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		System.out.println("Echo: " + message);
	}
}

public class ParameterizedConstructorThread {

	public static void main(String[] args) {
		new Thread(new EchoThread("Hello New Echo Thread")).start();
	}
}
