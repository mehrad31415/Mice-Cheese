package pckg;
//this experiment is for eight mice.
import java.util.Scanner;
public class TestChaseCheeseEightMice {

	public static void main(String[] args) {
		// we ask the user which place should the cheese be located.
		Scanner scanner = new Scanner(System.in);
		System.out.println("which place do you want to place the cheese (if i entered the cheese would be place at (i,i): ");
		int i = scanner.nextInt();
		// creating the shared grid
		Mice.g = Grid.createGrid(8,i);
		
		// displaying the grid.
		String[][] s = Display.show(Mice.g);
		Display.printBoard(s);
    	System.out.println("cheese at row = " + i + " column = " + i);
    	
    	// creating 8 mice objects.
		Mice obj1 = new Mice(0, 1);
		Mice obj2 = new Mice(1, 2);
		Mice obj3 = new Mice(2, 3);
		Mice obj4 = new Mice(3, 4);
		Mice obj5 = new Mice(4, 5);
		Mice obj6 = new Mice(5, 6);
		Mice obj7 = new Mice(6, 7);
		Mice obj8 = new Mice(7, 8);
		

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
