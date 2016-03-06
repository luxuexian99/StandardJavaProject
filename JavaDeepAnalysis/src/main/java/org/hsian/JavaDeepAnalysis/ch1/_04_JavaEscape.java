package org.hsian.JavaDeepAnalysis.ch1;

/**
 * Java转义
 */
public class _04_JavaEscape {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//char c1 = '\u0027';//等价于 char c1 = ''';
		//char c2 = '\u005c';//等价于 char c2 = '\';
		//String s1 = "\u0022";//等价于 String s1 = """;
		//char c3 = '\400';
		//char c4 = '\28';
		
		//以上都是错误的。
		//对于第7、第8行用的是八进制转义，八进制数字只能0~7，范围是0~255故，不正确。
		
		_04_JavaEscape e = new _04_JavaEscape();
		e.testEscape2();
		e.testEscape3();
	}
	
	/**
	 * 三种方式的转义
	 */
	public void testEscape2() {
		// 字符A的3种表示方式：
		char c1 = 'A';
		char c2 = '\u0041'; // Unicode表示方式
		char c3 = '\101';   //
		
		//双引号的3种表示方式：
		char e1 = '\"';
		char e2 = '\u0022';
		char e3 = '\042';
		
		//
		System.out.println("c1 = " + c1); // c1 = A
		System.out.println("c2 = " + c2); // c2 = A
		System.out.println("c3 = " + c3); // c3 = A
		System.out.println("c1 == c2 && c2 == c3: "
				                   + (c1 == c2 && c2 == c3));  // c1 == c2 && c2 == c3: true
		
		//
		System.out.println("e1 = " + e1); // e1 = "
		System.out.println("e2 = " + e2); // e2 = "
		System.out.println("e3 = " + e3); // e3 = "
		System.out.println("e1 == e2 && e2 == c3: " + (e1 == e2 && e2 == e3)); // e1 == e2 && e2 == c3: true

	}
	
	/**
	 * 这个例子说明：
	 *  Unicode字符的转义时机很早,
	 *  在编译器将程序解析成各种字符之前,
	 *  就先将Unicode转义字符转换成其他字符；即使注释也没有用。
	 */
	public void testEscape3() {
		//char c1 = '\\u000a';
		//char c1 = '  相当于：在‘之后键入了一个换行符；
		//';
		
		//char c2 = '\\u000d';
		//char c2 = '  相当于：在‘之后键入了一个回车符；
		//		';
		
		
		//所以换行符与回车符的转义最好不用Unicode转义；
		char c1 = '\n';  //换行
		char c2 = '\12'; //换行
		char c3 = '\r';  //回车
		char c4 = '\15'; //回车
		
	}
}