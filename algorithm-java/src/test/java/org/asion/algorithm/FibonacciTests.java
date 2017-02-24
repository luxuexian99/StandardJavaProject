package org.asion.algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Asion.
 * @since 2017/2/9.
 */
public class FibonacciTests {

    @Test
    public void test() {
        Fibonacci fibonacci = new Fibonacci();
        // 断言
        assertThat(fibonacci.fibonacci(10)).isEqualTo(55);
        assertThat(fibonacci.fibonacci(8)).isEqualTo(21);

        int n = 0;
        while (n < 40) {
            System.out.print(fibonacci.fibonacci(n) + " ");
            n++;
        }
    }
}
