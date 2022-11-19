package pckg;
// this experiment is for one mouse.
import java.util.Scanner;
public class TestChaseCheeseOneMice {

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
    	
    	// creating one mouse object.
		Mice obj1 = new Mice(0, 8);
		
		// creating thread.
		Thread t1 = new Thread(obj1);

		// starting the thread.
		t1.start();
		
	}
}
