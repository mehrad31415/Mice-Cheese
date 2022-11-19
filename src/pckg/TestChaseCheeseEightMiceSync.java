package pckg;
//this experiment is for eight mice and synchronised.

public class TestChaseCheeseEightMiceSync {

	public static void main(String[] args) {
		
		// creating the objects.
    	MiceSynchronized obj1 = new MiceSynchronized(0, 1);
    	MiceSynchronized obj2 = new MiceSynchronized(1, 2);
    	MiceSynchronized obj3 = new MiceSynchronized(2, 3);
    	MiceSynchronized obj4 = new MiceSynchronized(3, 4);
    	MiceSynchronized obj5 = new MiceSynchronized(4, 5);
    	MiceSynchronized obj6 = new MiceSynchronized(5, 6);
    	MiceSynchronized obj7 = new MiceSynchronized(6, 7);
    	MiceSynchronized obj8 = new MiceSynchronized(7, 8);
		
		
		// creating threads.
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		Thread t3 = new Thread(obj3);
		Thread t4 = new Thread(obj4);
		Thread t5 = new Thread(obj5);
		Thread t6 = new Thread(obj6);
		Thread t7 = new Thread(obj7);
		Thread t8 = new Thread(obj8);

		// starting the threads.
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		
		// if one mouse has the cheese interrupt all threads.
		if (Mice.hasCheese) {
			t1.interrupt();
			t2.interrupt();
			t3.interrupt();
			t4.interrupt();
			t5.interrupt();
			t6.interrupt();
			t7.interrupt();
			t8.interrupt();
		}
		
	}
}
