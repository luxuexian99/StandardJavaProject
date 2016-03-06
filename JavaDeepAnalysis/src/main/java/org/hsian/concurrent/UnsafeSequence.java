package org.hsian.concurrent;

import net.jcip.annotations.NotThreadSafe;

/**
 * 线程不安全的程序.
 *
 * Created by Hsian on 16/2/23.
 *
 * @author Hsian
 * @since 1.0, 16/2/23
 */
@NotThreadSafe
public class UnsafeSequence {
	private int value;

	/** 获取序列 */
	public int getNext() {
		return value++;
	}
}
