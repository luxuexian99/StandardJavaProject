/**
 * 
 */
package org.hsian.jvm.ch1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author Hsian
 *
 */
public class HeapOOM {
	
	static class OOMObject{}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true) {
			list.add(new OOMObject());
		}
	}

}
