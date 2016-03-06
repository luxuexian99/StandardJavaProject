package org.hsian.JavaDeepAnalysis.ch1;

/**
 * Unicode字符集
 */
public class _03_ValidIdentifier {
	public static void main(String[] args) {
		int startNumber = 0;
		int partNumber = 0;
		
		for(int i = 0x0000; i < 0x10ffff; i++) {
			if(Character.isJavaIdentifierStart(i)) {
				startNumber++;
			}
			if(Character.isJavaIdentifierPart(i)) {
				partNumber++;
			}
		}
		System.out.println("Unicode字符集个数：" + (0x10ffff + 1));
		System.out.println("可以作为标示符首字符的字符集个数：" + (startNumber));
		System.out.println("可以作为标示符一部分的字符集个数：" + (partNumber));
		
		System.out.println("两者相差个数：" + (partNumber + startNumber));
		
	}
}