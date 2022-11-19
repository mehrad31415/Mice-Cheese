package pckg;
//mice unsynchronised version

import java.lang.System;

public class Mice implements Runnable {
	// each mice has its own startRow and endRow.
	private int startRow;
	private int endRow;
	// the variables hasCheese and sharedCounter are for the class.
	// That is if one mice has the cheese hasCheese value will turn true. In a way
	// this is to notify other mice.
	static boolean hasCheese = false;

	// the sharedCounter counts the total number of boxes which has been opened.
	// This is a shared value.
	static int sharedCounter = 0;
	static Box[][] g;

	// constructor mice which each mouse has a startRow and endRow.
	public Mice(int startRow, int endRow) {
		this.startRow = startRow;
		this.endRow = endRow;

	}

	// when thread.Start() is called this run method will start running
	// We overwrite the already defined run method.
	public void run() {
		// start time of the process.
		long startTime = System.currentTimeMillis();
		// catching exceptions.
		// searching through the whole board.
		for (int j = startRow; j < endRow; j++) {
			for (int k = 0; k < g[0].length; k++) {
				// opening each box and checking whether its true or false takes 100 ms.
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// by checking each box by a mouse the sharedCounter is added by one.
				Mice.sharedCounter++;

				// if one mouse finds the cheese then we finish the process.
				// we evaluate the timeInterval which is finish time - start time

				if (g[j][k].cheese) {
					Mice.hasCheese = true;
					long endTime = System.currentTimeMillis();
					long timeInterval = endTime - startTime;

					System.out.println(timeInterval);
					System.out.println(sharedCounter);
					return;
				}
			}

		}
	}

}
