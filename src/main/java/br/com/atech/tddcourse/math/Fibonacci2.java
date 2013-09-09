package br.com.atech.tddcourse.math;

public class Fibonacci2 {

	public int of(int i) {

		if (i < 0) {
			throw new IllegalArgumentException();
		}

		if (i == 0) {
			return 0;
		}

		if (i <= 2) {
			return 1;
		}

		return of(i - 2) + of(i - 1);
	}

}
