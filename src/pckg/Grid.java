package pckg;

// creates a grid of boxes. 
// the grid is dimensions*dimensions
// in (number,number) the Box is holding the cheese thus the value is true. 
// Otherwise it is not holding the cheese thus the value is false. 

public class Grid{
	
	public static Box[][] createGrid(int dimension, int number){
		Box[][] grid = new Box[dimension][dimension];
		for (int i = 0; i<dimension; i++) {
			for (int j = 0; j<dimension; j++) {
			    grid [i][j]= new Box (false);
			}
		}
		grid [number] [number] = new Box (true);
		return grid;

	}
	
}

// this is a box. A box can contain a cheese or not have a cheese.
// if a box has a cheese it will be given true. Otherwise it contains the value false.
class Box {
	boolean cheese;
  public Box (boolean cheese) {
	  this.cheese = cheese;
  }
}
