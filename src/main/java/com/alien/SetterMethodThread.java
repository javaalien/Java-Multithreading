package com.alien;

class SetterThread implements Runnable { // OR extends Thread
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		System.out.println("Echo: " + message); // Echo: Hello New Setter Thread!
	}
}

public class SetterMethodThread {

	public static void main(String[] args) {
		SetterThread set = new SetterThread();
		set.setMessage("Hello new Setter Thread!");
		new Thread(set).start();
	}
}
