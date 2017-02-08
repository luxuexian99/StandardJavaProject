package org.hsian.JavaDeepAnalysis.ch1;

/**
 * 转换
 */
public class _05_Convertion {

	public static void main(String[] args) {
		int2Byte();
		byte2Char();
		conversion();
	}

	
	/**
	 * 
	 */
	public static void int2Byte() {
		byte b = 1;
		char c = 1;
		short s = 1;
		int i = 1;
//		byte bb = i;
//		char cc = i;
//		short ss = i;
		
		short s3 = (short)300;
		
//		byte eb = 128; // compile error
	}
	
	/**
	 * 隐式转换与强制转换。
	 */
	public static void conversion() {
		//以下三个为隐式的转换，编译器可以自己处理。
		byte b = -23;
		short s = 60;
		char c = '中';
		
		//以下需要转换运算符
		b = (byte)c;
		c = (char)b;
		s = (short)c;
		c = (char)s;
		b = (byte)-b;
		s = (short)(s + b);
		b = (byte)(b + 1);
		b += 1;	//正确，相当于b = (byte)(b + 1);
	}
	
	/**
	 * 扩展收缩转换
	 */
	public static void byte2Char() {
		// byte 变量值非负
		byte b = 10;// byte是由符号类型；
		char c = (char)b;// char是无符号类型；
		int i = c;
		System.out.println(i);
		// 输出所有经过扩展收缩转换后，值的改变byte。
		int num = 0;
		for(int a = Byte.MIN_VALUE; a <= Byte.MAX_VALUE; a++) {
			b = (byte)a;
			c = (char)b;
			i = c;
			if(b != i) {
				System.out.print("[b=" + b + ", i=" + i + "]");
				if(++num % 4 ==0) {
					System.out.println();
				} else {
					System.out.print(", ");
				}
			}
		}
		System.out.println("值改变的byte个数：" + num);
	}
}
