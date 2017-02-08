/**
 * 
 */
package org.hsian.jvm.ch1;

/**
 * 
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author Hsian
 *
 */
public class StackOverflowError {

    static int times = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
//		List<OOMObject> list = new ArrayList<OOMObject>();
//		while(true) {
//			list.add(new OOMObject());
//		}

        new StackOverflowError().testStackOverflowError();

	}

    public void testStackOverflowError() {
        System.out.println("调用自己" + times);
        times++;
        testStackOverflowError();
    }

}
