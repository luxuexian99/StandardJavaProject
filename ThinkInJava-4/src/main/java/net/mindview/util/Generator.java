//: net/mindview/util/Generator.java
// A generic interface.
package net.mindview.util;

/**
 * 对于生成者，它有一个指向下一个元素的方法。
 * @param <T>
 */
public interface Generator<T> {
    T next();
} ///:~
