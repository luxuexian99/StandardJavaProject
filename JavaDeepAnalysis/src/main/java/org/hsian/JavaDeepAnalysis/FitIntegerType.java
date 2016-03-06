package org.hsian.JavaDeepAnalysis;

import java.util.Scanner;

/**
 * Created by Hsian on 15/7/21.
 */
public class FitIntegerType {

    private static final String _STR = " can be fitted in:\n";
    private static final String OVER_STR = " can't be fitted anywhere.";
    private static final String BYTE_STR = "* byte\n";
    private static final String SHORT_STR = "* short\n";
    private static final String INT_STR = "* int\n";
    private static final String LONG_STR = "* long";

    public static void main(String[] args) {
        fitIntegerType(systemIn());
    }

    /**
     * The first line will contain an integer T, which denotes the number of inputs that will follow.
     * Each of the next T lines will contain an integer n. The number can be arbitrarily large or small!
     * @return
     */
    public static String[] systemIn() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] inArr = new String[n];
        int i = 0;
        while (i < n) {
            String input = sc.nextLine();
            inArr[i] = input.trim();
            i++;
        }
        return inArr;
    }

    /**
     * fit Integer type.
     * @param inputs input arrays.
     */
    public static void fitIntegerType(String[] inputs) {

        for (String input : inputs) {

            Long value = null;
            try {
                value = Long.valueOf(input);
            } catch (Exception e) {}

            if (null == value) {
                System.out.println(input + OVER_STR);
                continue;
            }

            StringBuilder sb = new StringBuilder(input).append(_STR);

            if (fitByte(value)) {
                sb.append(BYTE_STR);
            }

            if (fitShort(value)) {
                sb.append(SHORT_STR);
            }

            if (fitInt(value)) {
                sb.append(INT_STR);
            }

            if (fitLong(value)) {
                sb.append(LONG_STR);
            }
            System.out.println(sb.toString());
        }
    }

    private static boolean fitByte(Long value) {
        return (value >= Byte.MIN_VALUE && value <= Byte.MAX_VALUE);
    }

    private static boolean fitShort(Long value) {
        return (value >= Short.MIN_VALUE && value <= Short.MAX_VALUE);
    }

    private static boolean fitInt(Long value) {
        return (value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE);
    }

    private static boolean fitLong(Long value) {
        return (value >= Long.MIN_VALUE && value <= Long.MAX_VALUE);
    }
}
