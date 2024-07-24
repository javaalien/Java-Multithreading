package com.alien.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample2 implements Callable<String> {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Callable<String> myCallable = new ExecutorServiceExample2();

		Future<String> future = executorService.submit(myCallable);

		try {

			String result = future.get();
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}

	@Override
	public String call() throws Exception {

		return "Task Completed";
	}
}