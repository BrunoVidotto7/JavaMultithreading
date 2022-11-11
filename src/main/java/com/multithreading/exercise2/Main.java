package com.multithreading.exercise2;

import java.math.BigInteger;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		ComplexCalculation calculation =  new ComplexCalculation();
		BigInteger calculateResult = calculation.calculateResult(new BigInteger("10"), new BigInteger("2"), new BigInteger("4"), new BigInteger("4"));
		
		System.out.println(calculateResult);
		
	}
}
