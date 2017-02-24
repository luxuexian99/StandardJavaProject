package org.asion.algorithm;

/**
 * @author Asion.
 * @since 2017/2/9.
 */
class Fibonacci {

    int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            // an= a(n-1) + a(n-2) (n>=2）
            return fibonacci(n-1) + fibonacci(n-2);// (n>=2）
        }
    }

}
