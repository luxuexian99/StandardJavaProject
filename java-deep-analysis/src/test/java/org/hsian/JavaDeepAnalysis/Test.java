package org.hsian.JavaDeepAnalysis;

/**
 * Created by Hsian on 16/3/4.
 *
 * @author Hsian
 * @since 1.0, 16/3/4
 */
public class Test {

	@org.junit.Test
	public void testA() {
		int i = 0;
		for (test("A"); test("B") && i < 2; test("C")) {
			System.out.print(i++);
			test("D");
		}
	}

	public boolean test(String value) {
		System.out.print(value);
		return true;
	}

	@org.junit.Test
	public void testS() {
		String str0 = new String("AB");
		changeStr(str0);
		System.out.println(str0); // out: AB
		System.out.println(str0.intern()); // out: AB


		StringBuilder str1 = new StringBuilder("12");
		changeStr1(str1);
		System.out.println(str1); // out: 1234
	}

	private void changeStr(String str0) {
		str0 = str0 + "CD";
	}

	private void changeStr1(StringBuilder str1) {
		str1.append("34");
	}

	@org.junit.Test
	public void testSs() {
		String str0 = "AB";
		String str1 = "AB";
		String str2 = new String("AB");
		String str3 = new String("AB");
		System.out.println(str0 == str1); // out: true
		System.out.println(str0 == str2); // out: false
		System.out.println(str2 == str3); // out: false

		str2.intern();
		System.out.println(str0 == str2); // out: false

		str3 = str3.intern();
		System.out.println(str0 == str3); // out: true


	}

}
