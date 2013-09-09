package br.com.atech.tddcourse.domain;

public class Customer {
	private String firstName;
	private String lastName;
	private Wallet myWallet;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public float getPaymentFor(int payment) {
		if (myWallet.getTotalMoney() > payment) {
			return myWallet.subtractMoney(payment);
		} else {
			throw new IllegalStateException(
					"Sorry Paperboy, you will need to comeback later...");
		}
	}
}
