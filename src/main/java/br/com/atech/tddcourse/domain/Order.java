package br.com.atech.tddcourse.domain;

public class Order {

	private final int total;

	public Order(final int total) {
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

}
