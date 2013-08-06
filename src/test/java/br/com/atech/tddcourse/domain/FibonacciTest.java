package br.com.atech.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {

	private Fibonacci fib;

	@Before
	public void setup() {
		fib = new Fibonacci();
	}

	@Test
	public void testFibonacci() {
		final int cases[][] = { { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 } };
		for (final int[] case1 : cases) {
			assertEquals(case1[1], fib.of(case1[0]));
		}
	}

}
