package org.hsian.jvm.ch1;

/**
 * org.hsian.jvm.ch1
 * Created by Hsian on 14-11-12.
 */
public class ByteTest {

    public static void main(String[] args) {
        int a = -6;
        for(int i = 0; i < 32; i++) {
            int t = (a & 0x80000000>>>i)>>>(31 - i);
            System.out.print(t);
        }
    }
}
