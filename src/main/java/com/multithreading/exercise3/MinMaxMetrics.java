package com.multithreading.exercise3;

public class MinMaxMetrics {

	// Add all necessary member variables
	private volatile long min;
	private volatile long max;

	/**
	 * Initializes all member variables
	 */
	public MinMaxMetrics() {
		max = Long.MAX_VALUE;
		min = Long.MIN_VALUE;
	}

	/**
	 * Adds a new sample to our metrics.
	 */
	public void addSample(long newSample) {
		synchronized (this) {
			this.min = Math.min(newSample, this.min);
			this.max = Math.max(newSample, this.max);
		}
	}

	/**
	 * Returns the smallest sample we've seen so far.
	 */
	public long getMin() {
		return this.min;
	}

	/**
	 * Returns the biggest sample we've seen so far.
	 */
	public long getMax() {
		return this.max;
	}
}