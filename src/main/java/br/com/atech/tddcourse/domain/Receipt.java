package br.com.atech.tddcourse.domain;

public class Receipt {

	private final float value;
	private final Customer customer;

	public Receipt(final float value, final Customer customer) {
		this.value = value;
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public float getValue() {
		return value;
	}

}
