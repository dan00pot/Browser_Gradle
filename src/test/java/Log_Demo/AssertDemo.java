package Log_Demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssertDemo {

	@Test
	public void AccountAssertionsTest() {

		String account_one = "200";
		String account_two = "200";
		String account_three = "300";
		String account_four = null;
		String account_five = account_one;

		// assertTrue
		// checking if a condition is true
		assertTrue(account_one == account_two);

		// assertFalse
		// checking if a condition is true
		assertFalse(account_one == account_three);

		// assertFalse
		// checking if a condition is false
		assertFalse(account_one == account_three);

		// assertNull
		// checking if an object is null
		assertNull(account_four);

		// assertNotNull
		// checking if an object is not null
		assertNotNull(account_three);

		// assertEquals
		// checking if two objects are equal
		// assertEquals(account_one, account_three);

		// assertSame
		// checking if two objects references point the same object
		assertSame(account_one, account_five);

		// assertNotSame
		// checking if two objects references don't point the same object
		assertNotSame(account_one, account_four);

		// assertArrayEquals
		// checking if two arrays are the equal
	}
}
