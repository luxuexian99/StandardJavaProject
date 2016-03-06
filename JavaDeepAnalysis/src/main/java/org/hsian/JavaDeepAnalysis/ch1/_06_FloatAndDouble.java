package org.hsian.JavaDeepAnalysis.ch1;

import java.math.BigDecimal;

/**
 * 扑朔迷离-浮点类型的种种悬疑
 *
 * @author Hsian
 */
public class _06_FloatAndDouble {

//	private static final Logger logger = Logger.getLogger(_06_FloatAndDouble.class);

    public static void main(String[] args) {
        //
        System.out.println("-----------------------------------------------------------------------------------");
        // 测试浮点计算
        floatSum();
        System.out.println("-----------------------------------------------------------------------------------");
        // 浮点数的存储
        floatStorage();
        System.out.println("-----------------------------------------------------------------------------------");
        // 浮点数的存储
        floatStorage2();
        System.out.println("-----------------------------------------------------------------------------------");
        //
        magnitude();
        System.out.println("-----------------------------------------------------------------------------------");
        integral2Float();
        System.out.println("-----------------------------------------------------------------------------------");
        float2Integral();
        System.out.println("-----------------------------------------------------------------------------------");
    }

    /**
     * java中浮点的计算精度会有丢失
     */
    public static void floatSum() {
        double d1 = 0.1;
        double d2 = 0.2;

        if (d1 + d2 == 0.3) {
            System.out.println("0.1 + 0.2 = 0.3");
        } else {
            System.out.println("意外发生了！0.1 + 0.2不等于0.3！");
            System.out.println("0.1 + 0.2 = " + (d1 + d2));
        }
    }

    /**
     * 用BigDecimal存储精度也会丢失，这是二进制表示不完所有浮点数的缘故。
     * 很多浮点类型的值，只是近似的存储。
     */
    public static void floatStorage() {
        System.out.println("使用BigDecimal存储的浮点类型值！");
        for (int i = 1; i < 9; i++) {
            double d = Double.parseDouble("0." + i);
            System.out.println("Double.parseDouble(\"0.\" + " + i + "): " + d);
            BigDecimal bd = new BigDecimal(d);
            System.out.println("---------new BigDecimal(" + d + "): " + bd);
            BigDecimal bd1 = new BigDecimal("0.1");
            System.out.println("---------new BigDecimal(" + d + "): " + bd1);
        }
    }

    /**
     * 0.0001~0.9999之间可以使用二进制来准确表示的小数有。
     */
    public static void floatStorage2() {
        int limit = 9999;
        int length = String.valueOf(limit).length();
        System.out.println("0.0001~0.9999之间可以使用二进制来准确表示的小数有：");

        for (int i = 1; i <= limit; i++) {
            int num0 = length - String.valueOf(i).length();
            StringBuilder value = new StringBuilder("0.");
            for (int j = 1; j <= num0; j++) {
                value.append("0");
            }
            value.append(i);
            BigDecimal db = new BigDecimal(Double.parseDouble(value.toString()));

            if (db.scale() <= length) {
                System.out.println(db);
            }
        }
    }

    /**
     * 数量级差别很大的浮点数运算会有很大的误区。
     */
    public static void magnitude() {
        float f1 = 30000;
        float f2 = f1 + 1;
        System.out.println("f1=" + f1 + ", f2=" + f2);

        if (f1 < f2) {
            System.out.println("f1 < f2成立");
        } else {
            System.out.println("意外发生了，f1 < f2不成立！");
        }
        float f3 = 30000000;
        float f4 = f3 + 1;
        System.out.println("f3=" + f3 + ", f4=" + f4);
        if (f3 < f4) {
            System.out.println("f3 < f4成立");
        } else {
            System.out.println("意外发生了，f3 < f4不成立！");
        }
    }

    /**
     * 整形到浮点类型的转换
     */
    public static void integral2Float() {
        int intPositive = 987654321;  // 很大的int正数
        int intNegative = -987654321; // 很大的int负数
        long longPositive = 1234567890123456789L;  // 很大的long正数
        long longNegative = -1234567890123456789L; // 很大的long负数

        // int类型转换成浮点类型。
        float fPositive = intPositive;
        float fNegative = intNegative;
        double dPositive = intPositive;
        double dNegative = intNegative;

        System.out.println("很大的int正数:" + intPositive);
        System.out.println("很大的int负数:" + intNegative);
        System.out.println("很大的int正数转成float:" + fPositive);
        System.out.println("很大的int负数转成float:" + fNegative);
        System.out.println("很大的int正数转成double:" + dPositive);
        System.out.println("很大的int负数转成double:" + dNegative);

        // long类型转换成浮点类型。
        fPositive = longPositive;
        fNegative = longNegative;
        dPositive = longPositive;
        dNegative = longNegative;

        System.out.println("很大的long正数:" + longPositive);
        System.out.println("很大的long负数:" + longNegative);
        System.out.println("很大的long正数转成float:" + fPositive);
        System.out.println("很大的long负数转成float:" + fNegative);
        System.out.println("很大的long正数转成double:" + dPositive);
        System.out.println("很大的long负数转成double:" + dNegative);

    }

    /**
     * 浮点类型转换成整形
     */
    public static void float2Integral() {
        double d = Double.NaN; // NaN
        System.out.println("(long)NaN=" + (long) d);
        System.out.println("(int)NaN=" + (int) d);
        d = 3e30; // 很大的一个浮点正数值
        System.out.println("(long)3e30=" + (long) d);
        System.out.println("(int)3e30=" + (int) d);
        d = -8e28;
        System.out.println("(long)-8e28=" + (long) d);
        System.out.println("(int)-8e28=" + (int) d);
        d = Double.POSITIVE_INFINITY; // 正无穷
        System.out.println("(long)infinity=" + (long) d);
        System.out.println("(int)infinity=" + (int) d);
        d = Double.NEGATIVE_INFINITY; // 负无穷
        System.out.println("(long)-infinity=" + (long) d);
        System.out.println("(int)-infinity=" + (int) d);
        d = -12345678.6; // 在int类型的取值范围内
        System.out.println("(long)-12345678.6=" + (long) d);
        System.out.println("(int)-12345678.6=" + (int) d);
        System.out.println("(byte)-12345678.6=" + (byte) d);
        System.out.println("(int)(char)-12345678.6=" + (int)(char) d);
        System.out.println("(short)-12345678.6=" + (short) d);
    }

}

