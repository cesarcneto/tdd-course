package br.com.atech.tddcourse.math;

import static org.hamcrest.core.IsEqual.equalTo;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PrimeFactorsTest {

	private static List<Integer> listOf(final Integer... n) {
		return Arrays.asList(n);
	}

	@Test
	public void testPrimeFactors1() {
		final PrimeFactors primes = PrimeFactors.generate(1);
		Assert.assertThat("expected prime factors list", primes.get(), equalTo(listOf()));
	}

	@Test
	public void testPrimeFactors12() {
		final PrimeFactors primes = PrimeFactors.generate(12);
		Assert.assertThat("expected prime factors list", primes.get(), equalTo(listOf(2, 2, 3)));
	}

	@Test
	public void testPrimeFactors2() {
		final PrimeFactors primes = PrimeFactors.generate(2);
		Assert.assertThat("expected prime factors list", primes.get(), equalTo(listOf(2)));
	}

	@Test
	public void testPrimeFactors3() {
		final PrimeFactors primes = PrimeFactors.generate(3);
		Assert.assertThat("expected prime factors list", primes.get(), equalTo(listOf(3)));
	}

	@Test
	public void testPrimeFactors4() {
		final PrimeFactors primes = PrimeFactors.generate(4);
		Assert.assertThat("expected prime factors list", primes.get(), equalTo(listOf(2, 2)));
	}

	@Test
	public void testPrimeFactors6() {
		final PrimeFactors primes = PrimeFactors.generate(6);
		Assert.assertThat("expected prime factors list", primes.get(), equalTo(listOf(2, 3)));
	}

	@Test
	public void testPrimeFactors8() {
		final PrimeFactors primes = PrimeFactors.generate(8);
		Assert.assertThat("expected prime factors list", primes.get(), equalTo(listOf(2, 2, 2)));
	}

	@Test
	public void testPrimeFactors9() {
		final PrimeFactors primes = PrimeFactors.generate(9);
		Assert.assertThat("expected prime factors list", primes.get(), equalTo(listOf(3, 3)));
	}

}
