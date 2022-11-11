package com.multithreading.exercise3;

public class Main {

	public static void main(String[] args) {
		MinMaxMetrics minMaxMetrics = new MinMaxMetrics();

		Thread thread1 = new Thread(() -> {
			minMaxMetrics.addSample(0000001);
		});

		Thread thread2 = new Thread(() -> {
			minMaxMetrics.addSample(1000000000);
		});
		
		thread1.start();
		thread2.start();
		
		System.out.println(minMaxMetrics.getMax()); 
		System.out.println(minMaxMetrics.getMin());

	}

}
