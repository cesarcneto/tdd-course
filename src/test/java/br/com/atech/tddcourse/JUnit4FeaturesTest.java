package br.com.atech.tddcourse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.IsCollectionContaining.hasItem;
import static org.junit.matchers.IsCollectionContaining.hasItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Condition;
import org.junit.Test;

public class JUnit4FeaturesTest {

	@Test
	public void assertThat2() {
		final String str = "test";
		assertThat(str, equalTo("test"));
		assertThat(str, not(equalTo("anotherTest")));
	}

	public Condition<List<Integer>> onlyPositiveNumbersListCondition() {
		final Condition<List<Integer>> onlyPositiveNumbers = new Condition<List<Integer>>() {

			@Override
			public boolean matches(final List<Integer> value) {
				for (final Integer v : value) {
					if (v <= 0) {
						return false;
					}
				}
				return true;
			}
		};
		return onlyPositiveNumbers;
	}

	@Test
	public void testArrays() {
		assertThat(new Integer[]{ 1, 2, 3, 4, 5 }, equalTo(new Integer[]{ 1, 2, 3, 4, 5 }));
		assertThat(new Integer[]{ 1, 2, 3, 4, 5 }, not(new Integer[]{ 1, 2 }));
	}

	@Test
	public void testAssertThat1() {
		final double d = 1.3;
		assertThat(d, is(1.3));
		assertThat(d, is(not(1.4)));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testAssertThat3() {
		final String str = "test";
		assertThat(str, anyOf(is("test"), is("this"), is("that")));
		assertThat(str, not(anyOf(is("tasty"), is("this"), is("that"))));
	}

	@Test
	public void testAssertThatMaps1() {
		final Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);

		assertThat(map, hasKey("one"));
		assertThat(map, hasValue(2));
	}

	@Test
	public void testCollections() {
		assertThat(Arrays.asList(1, 2), hasItem(1));
		assertThat(Arrays.asList(1, 2), hasItems(1, 2));
		assertThat(Arrays.asList(1, 2, 3), not(hasItem(0)));
	}

	@Test
	public void testCollections2() {
		final List<String> myList = new ArrayList<>();
		assertThat(myList).isEmpty();

		final List<Integer> list = Arrays.asList(1, 2, 3);
		assertThat(list).is(onlyPositiveNumbersListCondition());
	}

	@Test
	public void testNumericComparison() {
		assertThat(1, lessThan(2));
		assertThat(2, greaterThan(1));
		assertThat(2, greaterThanOrEqualTo(2));
		assertThat(1, lessThanOrEqualTo(1));
	}

	@Test
	public void testSubstring() {
		assertThat("Hello World", containsString("Hello"));
	}

}
