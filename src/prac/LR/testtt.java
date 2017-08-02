package prac.LR;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class testtt {
//	public static void main(String[] args) {
//
//		testtt t = new testtt();
//		t.test01();
//
////		System.out.println(t.ten2x(13, 2));
//	}

	public String ten2x(int input, int base) {
		String toReturn = "";

		do {
			toReturn = (input % base) + toReturn;
			input = input / base;
		} while (input > 0);

		return toReturn;

	}

	@Test
	public void test01() {
		String expected = "1101";
		String actual = this.ten2x(13, 2);

		assertTrue("", expected.equals(actual));
	}

}
