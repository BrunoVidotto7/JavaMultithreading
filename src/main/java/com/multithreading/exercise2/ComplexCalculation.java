package com.multithreading.exercise2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ComplexCalculation {
	public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2)
			throws InterruptedException {
		BigInteger result;

		PowerCalculatingThread thread1 = new PowerCalculatingThread(base1, power1);
		PowerCalculatingThread thread2 = new PowerCalculatingThread(base2, power2);

		List<PowerCalculatingThread> threads = new ArrayList<>();

		threads.add(thread1);
		threads.add(thread2);

		for (Thread thread : threads) {
			thread.setDaemon(true);
			thread.start();
		}

		for (Thread thread : threads) {
			thread.join();
		}

		result = thread1.getResult().add(thread2.getResult());

		return result;
	}
	private static class PowerCalculatingThread extends Thread {
		private BigInteger result = BigInteger.ONE;
		private BigInteger base;
		private BigInteger power;

		public PowerCalculatingThread(BigInteger base, BigInteger power) {
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {
			for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
				result = result.multiply(base);
			}
		}

		public BigInteger getResult() {
			return result;
		}
	}
}
