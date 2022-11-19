package pckg;
// this experiment is for four mice.
import java.util.Scanner;
public class TestChaseCheeseFourMice {

	public static void main(String[] args) {
		// we ask the user which place should the cheese be located.
		Scanner scanner = new Scanner(System.in);
		System.out.println("which place do you want to place the cheese (if i entered the cheese would be place at (i,i): ");
		int i = scanner.nextInt();
		// creating the shared grid (it is an 8*8 grid).
		Mice.g = Grid.createGrid(8,i);
		
		// displaying the grid.
		String[][] s = Display.show(Mice.g);
		Display.printBoard(s);
    	System.out.println("cheese at row = " + i + " column = " + i);
    	
    	// creating 4 mice objects.
		Mice obj1 = new Mice(0, 2);
		Mice obj2 = new Mice(2, 4);
		Mice obj3 = new Mice(4, 6);
		Mice obj4 = new Mice(6, 8);

		
		// synchronised version. For use comment the above lines and uncomment the below ones. 
		/*
		MiceSynchronized obj1 = new MiceSynchronized(0, 2);
		MiceSynchronized obj2 = new MiceSynchronized(2, 4);
		MiceSynchronized obj3 = new MiceSynchronized(4, 6);
		MiceSynchronized obj4 = new MiceSynchronized(6, 8);
		*/
		
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
