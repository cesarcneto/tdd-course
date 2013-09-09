package br.com.atech.tddcourse.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class Fibonacci2Test {

	private Fibonacci2 fibonacci;

	@Before
	public void testSetup() {
		fibonacci = new Fibonacci2();
	}

	@Test
	// o - Cenário 1: Fibonacci de 1 = 1
	public void testFibonacciDe1() {
		assertThat("Fibonacci de ", fibonacci.of(1), equalTo(1));
	}

	@Test
	// o - Cenário 2: Fibonacci de 2 = 1
	public void testFibonacciDe2() {
		assertThat("Fibonacci de ", fibonacci.of(2), equalTo(1));
	}

	@Test
	// o - Cenário 3: Fibonacci de 3 = 2
	public void testFibonacciDe3() {
		assertThat("Fibonacci de ", fibonacci.of(3), equalTo(2));
	}

	@Test
	// x - Cenário 4: Fibonacci de 4 = 3
	public void testFibonacciDe4() {
		assertThat("Fibonacci de ", fibonacci.of(4), equalTo(3));
	}

	@Test(expected = IllegalArgumentException.class)
	// x - Cenário 5: Fibonacci de menor que 0 = Argurmento Inválido
	public void testFibonacciDeValorMenorQue0() {
		fibonacci.of(-1);
	}

}
