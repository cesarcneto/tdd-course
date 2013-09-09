package br.com.atech.tddcourse.domain;

public class Paperboy {

	public Receipt askCustomerForOrderPayment(final Customer customer, //
			final Order order) {
		final int payment = order.getTotal(); // “I want my two dollars!”
		return new Receipt(customer.getPaymentFor(payment), customer);
	}
}
