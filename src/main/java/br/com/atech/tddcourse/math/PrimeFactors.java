package br.com.atech.tddcourse.math;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

	public static PrimeFactors generate(final int num) {
		return new PrimeFactors(num);
	}

	private final int num;

	private List<Integer> primeFactors;

	private PrimeFactors(final int num) {
		this.num = num;
	}

	private List<Integer> generateFactors() {
		int n = num;
		final List<Integer> primes = new ArrayList<Integer>();

		for (int candidate = 2; n > 1; candidate++) {
			for (; n % candidate == 0; n /= candidate) {
				primes.add(candidate);
			}
		}
		return primes;
	}

	public List<Integer> get() {
		if (primeFactors == null) {
			primeFactors = generateFactors();
		}
		return primeFactors;
	}

}
