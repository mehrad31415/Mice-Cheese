package pckg;

// prints the board with the aesthetic look.
public class Display {
	
	// turns a board of Box[][] to String[][] to be able to pass to the printBoard.
	public static String[][] show (Box[][] grid) {
		String[][] newArr = new String[grid.length][grid.length];
		for (int i = 0; i<grid.length; i++) {
			for (int j = 0; j<grid.length;j++) {
				if (grid[i][j].cheese) {
					newArr[i][j]="true";
				} else {
					newArr[i][j]="false";
				}
			}	
		}

		return newArr;
	}
	
	// Method 2 prints the board.
	public static void printBoard(String[][] stringArray) {

		corner(stringArray);

		for (int i = 0; i < stringArray.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < stringArray[i].length; j++) {
				String string = sameWidth(i, j, stringArray);
				System.out.print(string);
				System.out.print(" | ");
			}
			System.out.println("");
			if (i != stringArray.length - 1) {
				between(stringArray);
			}
		}

		corner(stringArray);
	}

	// gets the string with the maximum width inside the array.
	public static int maxWidth(String[][] stringArray) {
		int width = 0;
		for (int i = 0; i < stringArray.length; i++) {
			for (int j = 0; j < stringArray[i].length; j++) {
				if (stringArray[i][j].length() > width) {
					width = stringArray[i][j].length();
				}
			}
		}
		return width;
	}

	// makes all strings inside the array the same width by adding empty spaces.
	// (this will be useful if we enter strings with different width which is not
	// the case in this particular entry)
	public static String sameWidth(int row, int column, String[][] stringArray) {
		final int WIDTH = maxWidth(stringArray);
		String string = stringArray[row][column];
		while (string.length() < WIDTH) {
			string = string + " ";
		}
		return string;
	}

	// creates the dash lines of the up and down corner of the board.
	public static void corner(String[][] stringArray) {
		final int WIDTH = maxWidth(stringArray);
		final int COLUMN = stringArray[0].length;
		System.out.print(" ");
		for (int i = 0; i < COLUMN + 1; i++) {
			for (int j = 0; j < WIDTH + 2; j++) {
				System.out.print("-");
			}
		}
		System.out.println("");
	}

	// creates the separators of each row of the board
	public static void between(String[][] stringArray) {
		final int WIDTH = maxWidth(stringArray);
		final int COLUMN = stringArray[0].length;
		System.out.print("| ");
		for (int i = 0; i < COLUMN; i++) {
			for (int j = 0; j < WIDTH; j++) {
				System.out.print("-");
			}
			System.out.print(" | ");
		}
		System.out.println("");
	}

}