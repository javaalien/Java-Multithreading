package com.alien.concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class CallableExample implements Callable {

	public Object call() throws Exception {

		Random generator = new Random();
		int randomNumber = generator.nextInt(5);

		Thread.sleep(randomNumber * 1000);

		return randomNumber;
	}
}

public class CallableFutureTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		FutureTask[] randomNumberTasks = new FutureTask[5];

		for (int i = 0; i < 5; i++) {

			Callable callable = new CallableExample();
			randomNumberTasks[i] = new FutureTask(callable);
			Thread t = new Thread(randomNumberTasks[i]);

			t.start();
		}

		for (int i = 0; i < 5; i++) {
			System.out.println(randomNumberTasks[i].get());
		}
	}
}
