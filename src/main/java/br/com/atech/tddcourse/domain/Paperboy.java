package br.com.atech.tddcourse.domain;

public class Paperboy {

	public Payment askCustomerForOrderPayment(final Customer customer, final Order order) {

		final int payment = order.getTotal(); // “I want my two dollars!”
		final Wallet theWallet = customer.getWallet();
		if (theWallet.getTotalMoney() > payment) {
			theWallet.subtractMoney(payment);
		} else {
			throw new IllegalStateException("Sorry Paperboy, you will need to comeback later...");
		}

		return new Payment(payment, customer);
	}
}
