package com.multithreading.exercise1;

import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		List<Runnable> tasks = Arrays.asList(new Runnable() {
			@Override
			public void run() {
				System.out.println("Running");
			}
		});
		MultiExecutor thread = new MultiExecutor(tasks);
		thread.executeAll();
	}
	
}
