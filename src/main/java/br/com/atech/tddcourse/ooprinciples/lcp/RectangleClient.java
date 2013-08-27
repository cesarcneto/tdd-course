package br.com.atech.tddcourse.ooprinciples.lcp;

public class RectangleClient {

	/*
	 * Thus, we might conclude that the model is now self consistent, and correct. However, this
	 * conclusion would be amiss. A model that is self consistent is not necessarily consistent with
	 * all its users! The function works just fine for a Rectangle, but declares an assertion error
	 * if passed a Square. So here is the real problem: Was the programmer who wrote that function
	 * justified in assuming that changing the width of a Rectangle leaves its height unchanged?
	 */
	public void setup(final Rectangle r) {
		r.setHeight(5);
		r.setWidth(4);

		assert r.getHeight() * r.getWidth() == 20;
	}

}
