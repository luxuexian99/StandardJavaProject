package org.hsian.thinkinjava.util;

/**
 * 对于生成者，它有一个指向下一个元素的方法。
 * @param <T>
 * Created by Hsian on 15/7/13.
 */
public interface Generator<T> {
    T next();
}
