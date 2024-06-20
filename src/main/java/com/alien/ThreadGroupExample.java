package com.alien;

//Java provides a convenient way to group multiple threads in a single object ThreadGroup

public class ThreadGroupExample {

	public static void main(String[] args) {

		final Runnable r1 = () -> {
			System.out.println("Runnable One");
		};

		final Runnable r2 = () -> {
			System.out.println("Runnable Two");
		};

		final Runnable r3 = () -> {
			System.out.println("Runnable Three");
		};

		final Runnable r4 = () -> {
			System.out.println("Runnable Four");
		};

		final ThreadGroup threadGroup = new ThreadGroup("Alien-Thread");

		final Thread thread1 = new Thread(threadGroup, r1, "ThreadOne");
		thread1.start();

		final Thread thread2 = new Thread(threadGroup, r2, "ThreadTwo");
		thread2.start();
		
		final Thread thread3 = new Thread(threadGroup, r3, "ThreadThree");
        thread3.start();
        
        final Thread thread4 = new Thread(threadGroup, r4, "ThreadFour");
        thread4.start();
        
        System.out.println("Thread group name :: " + threadGroup.getName());

        threadGroup.list();
	}

}
