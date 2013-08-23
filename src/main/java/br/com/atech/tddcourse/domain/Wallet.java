package br.com.atech.tddcourse.domain;

public class Wallet {
	private float value;

	public void addMoney(final float deposit) {
		value += deposit;
	}

	public float getTotalMoney() {
		return value;
	}

	public void setTotalMoney(final float newValue) {
		value = newValue;
	}

	public void subtractMoney(final float debit) {
		value -= debit;
	}
}
