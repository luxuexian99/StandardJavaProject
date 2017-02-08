package org.hsian.JavaDeepAnalysis;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Sample Input

 5
 -150
 150000
 1500000000
 213333333333333333333333333333333333
 -100000000000000
 Sample Output

 -150 can be fitted in:
 * short
 * int
 * long
 150000 can be fitted in:
 * int
 * long
 1500000000 can be fitted in:
 * int
 * long
 213333333333333333333333333333333333 can't be fitted anywhere.
 -100000000000000 can be fitted in:
 * long
 * Created by Hsian on 15/4/15.
 */
public class MyTest {

    public static void main(String[] args) {
        bianJie();
    }

    public static void bianJie() {
        String s = "213333333333333333333333333333333333";
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println("byte min: " + (-2 << 7) + "Byte.MIN_VALUE: " + Byte.MIN_VALUE);
        System.out.println("byte max: " + ((2 << 7) - 1) + "Byte.MAX_VALUE: " +  Byte.MAX_VALUE);
        System.out.println("short min: " + (-2 << 14) + " " + Short.MIN_VALUE);
        System.out.println("short max: " + ((2 << 14) - 1) + " " + Short.MAX_VALUE);
        System.out.println(nf.format(Math.pow(-2, 30)));
        System.out.println(nf.format(Math.pow(2, 30) - 1));
        System.out.println(-2 << 31);
        System.out.println((2 << 31));
        System.out.println((-2 << 63));
        System.out.println((2 << 63));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        //        System.out.println(Long.valueOf(s));
        BigDecimal bigDecimal = new BigDecimal(s);
        System.out.println(bigDecimal);
        try {
            bigDecimal.longValueExact();
        } catch (ArithmeticException e) {
            System.out.println(s + " can't be fitted anywhere.");
        }
    }
}
