package org.hsian.concurrent;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Created by Hsian on 16/2/23.
 *
 * @author Hsian
 * @since 1.0, 16/2/23
 */
@ThreadSafe
public class Sequence {
	@GuardedBy("this")
	private int value;

	public synchronized int getNext() {
		return value++;
	}
}
