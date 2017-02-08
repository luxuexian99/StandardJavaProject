package org.hsian.JavaDeepAnalysis;

import java.util.Scanner;

/**
 * Created by Hsian on 15/7/22.
 */
public class Loops {

    public static void main(String[] args) {
        int[][] inputArray = systemIn();
        cLoops(inputArray);
    }

    public static int[][] systemIn() {
        // inputs.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[][] inputArray = new int[n][3];
        int i = 0;
        while (i < n) {
            int j = 0;
            while (j < 3) {
                int input = sc.nextInt();
                inputArray[i][j] = input;
                j++;
            }
            i++;
        }
        return inputArray;
    }

    public static void cLoops(int[][] values) {
        for (int i = 0; i < values.length; i++) {
            calculate(values[i]);
            System.out.println();
        }
    }

    private static void calculate(int[] value) {
        int a = value[0];
        int b = value[1];
        int n = value[2];

        int result = 0;

        for (int i = n; i > 0; i--) {
            result += calculate(b, n - i);
            System.out.print(result + a + " ");
        }
    }

    private static int calculate(int b, int n) {
        return (int)(Math.pow(2, n) * b);
    }
}
