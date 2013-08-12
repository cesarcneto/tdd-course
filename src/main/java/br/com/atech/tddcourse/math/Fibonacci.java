package br.com.atech.tddcourse.math;

public class Fibonacci {

	public int of(final int n) {
		if (n == 0) {
			return 0;
		}

		if (n <= 2) {
			return 1;
		}

		return of(n - 1) + of(n - 2);
	}

}
