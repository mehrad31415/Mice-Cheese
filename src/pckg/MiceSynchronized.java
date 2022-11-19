package pckg;
// mice synchronised version
import java.lang.System;
import java.util.concurrent.Semaphore;

public class MiceSynchronized implements Runnable{
	int startRow;
	int endRow;
	static boolean hasCheese = false;
	static int sharedCounter = 0;
	// the same as mice but with a semaphore.
	static Semaphore semaphore = new Semaphore(1);
	public MiceSynchronized (int startRow, int endRow) {
		this.startRow = startRow;
		this.endRow = endRow;
	}

    public void run() {
    	// here i indicates the location of cheese. This means (2,2) is where the cheese is located. 
    	// for some reason if I created the grid outside of the class like what I did with mice it would give an exception.
    	int i = 2;
    	Box[][] g = Grid.createGrid(8,i);
    	long startTime = System.currentTimeMillis();
    	try {
        	for (int j = startRow; j<endRow;j++) {
        		for (int k = 0; k<g[0].length;k++) {
        			Thread.sleep(100);
        			// acquiring and releasing the semaphore.
        			semaphore.acquire();
        			sharedCounter++;
        			semaphore.release();
        			if (g[j][k].cheese) {
        				Mice.hasCheese = true;
        				long endTime = System.currentTimeMillis();
        				long timeInterval = endTime - startTime;
        	    		String[][] s = Display.show(g);
        	    		Display.printBoard(s);
        		    	System.out.println("cheese at row = " + i + " column = " + i);
        				System.out.println(timeInterval);
        				System.out.println(sharedCounter);
        				return;
        				}
            		}
				}
       		}
        catch (Exception e) {
        }
    }

}


       	
