package br.com.atech.tddcourse.ooprinciples.lcp;

public class Square extends Rectangle {

	@Override
	public void setHeight(final int height) {
		super.setHeight(height);
		super.setWidth(height);
	}

	@Override
	public void setWidth(final int width) {
		super.setWidth(width);
		super.setHeight(width);
	}

}
