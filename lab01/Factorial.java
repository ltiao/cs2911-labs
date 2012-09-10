package lab01;

import java.math.BigInteger;

public class Factorial {

	static int factorial_int ( int n ) {
		return n < 2 ? 1 : n*factorial_int(n-1);
	}
	
	static double factorial_double ( int n ) {
		return n < 2 ? 1 : n*factorial_double(n-1);
	}
	
	static BigInteger factorial_bigInteger ( int n ) {
		return n < 2 ? BigInteger.ONE : BigInteger.valueOf(n).multiply(factorial_bigInteger(n-1));
	}
	
	public static void main (String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(factorial_int(n));
		System.out.println(factorial_double(n));
		System.out.println(factorial_bigInteger(n));
/*
		for (int i = 1 ; i <= Integer.parseInt(args[0]) ; i++) {
			System.out.println(i+"!=");
			System.out.println(factorial_int(i)+" (Integer)");
			System.out.println(factorial_double(i)+" (Double)");			
			System.out.println(factorial_bigInteger(i)+" (BigInteger)");			
		}
*/
	}
}