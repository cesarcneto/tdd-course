package br.com.atech.tddcourse.domain;

public class Payment {

	private final int value;
	private final Customer customer;

	public Payment(final int value, final Customer customer) {
		this.value = value;
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public int getValue() {
		return value;
	}

}
