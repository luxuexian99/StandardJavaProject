package org.hsian.JavaDeepAnalysis.ch1;

/**
 * 歧义的调用
 */
public class _05_AmbiguousInvocation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		short s = 60;
		/*
		 * 编译错误：
		 * _05_AmbiguousInvocation.java:10: 错误: 无法将类 _05_AmbiguousInvocation中的方法 print应用到给定类型;
		 * print(60);
		 * ^
  		 * 需要: short
  		 * 找到: int
  		 * 原因: 无法通过方法调用转换将实际参数int转换为short
		 * 1 个错误
		 */
//		print(60);

		print(s);
	}

	/**
	 * 歧义的调用
	 * @param value
	 */
	public static void print(short value) {
		System.out.println(value);
	}
	
	/**
	 * 
	 * @param value
	 *
	public static void print(long value) {
		System.out.println(value);
	}*/
	
}
