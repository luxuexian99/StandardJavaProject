package org.hsian.concurrent;

/**
 * 学习Volatile
 *
 * Created by Hsian on 16/3/8.
 *
 * @author Hsian
 * @since 1.0, 16/3/8
 */
public class Volatile extends Thread {

	private volatile int[] arr = {1, 2, 3, 4, 5};

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	@Override
	public void run() {
		super.run();
		System.out.println("Thread " + Thread.currentThread().getName());
		int[] tArr = {1, 2, 3, 4, 5, 6};

		setArr(tArr);

		for (int i : tArr) {
			System.out.print(i);
		}
	}

	public static void main(String[] args) {
		Volatile v = new Volatile();
		v.start();

		Volatile v2 = new Volatile();
		v2.start();
	}
}
