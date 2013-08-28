package br.com.atech.tddcourse.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
		for (final int[] theCase : cases) {
			assertThat("fibonacci of", fib.of(theCase[0]), is(theCase[1]));
			assertThat("fibonacci of", fib.of(theCase[0]), equalTo(theCase[1]));
		}
	}

}
