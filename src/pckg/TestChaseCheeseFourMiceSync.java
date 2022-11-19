package pckg;
// this experiment is for four mice and synchronised.

public class TestChaseCheeseFourMiceSync {

	public static void main(String[] args) {
		
		// creating the objects.
		MiceSynchronized obj1 = new MiceSynchronized(0, 2);
		MiceSynchronized obj2 = new MiceSynchronized(2, 4);
		MiceSynchronized obj3 = new MiceSynchronized(4, 6);
		MiceSynchronized obj4 = new MiceSynchronized(6, 8);
		
		
		// creating threads.
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		Thread t3 = new Thread(obj3);
		Thread t4 = new Thread(obj4);


		// starting the threads.
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		
		// if one mouse has the cheese interrupt all threads.
		if (Mice.hasCheese) {
			t1.interrupt();
			t2.interrupt();
			t3.interrupt();
			t4.interrupt();

		}
		
	}
}
