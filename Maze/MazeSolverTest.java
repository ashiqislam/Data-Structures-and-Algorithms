import java.util.*;

/**
 * 
 * @author Ashiq Hoque
 * Professor Wei
 * Data Structures and Algorithms
 * 
 * 	Maze Solver
 * 
 * 			Test Case
 * 	X X X X X X X X X X X X X
 *	      X       X X X X   X
 * 	X X 	  X         X   X
 * 	X X   X X   X   X   X   X
 * 	X X     X       X   X   X
 * 	X X   X X X X X
 * 	X X X X X X X X X X X X X
 */

public class MazeSolverTest {
	
	public static void main (String[] args) {
	
	MazeSolver test = new MazeSolver();
	Stack<Character> s1 = new Stack<Character>();
	boolean check = true;
	
	char[][] maze = 
		{ {'X','X','X','X','X','X','X','X','X','X','X','X','X'},
		  {'S','P','P','X','P','P','P','X','X','X','X','P','X'},
		  {'X','X','P','P','P','X','P','P','P','P','X','P','X'},
		  {'X','X','P','X','X','X','X','P','X','P','X','P','X'},
		  {'X','X','P','P','P','X','P','P','X','P','P','P','X'},
		  {'X','X','P','P','X','X','X','X','X','P','P','P','E'},
		  {'X','X','X','X','X','X','X','X','X','X','X','X','X'}
		};
	
	test.Validate(maze, check);
	test.CreatePath(maze,s1);
	test.DisplayMaze(maze,s1);
	System.out.println("\nSUCCESS!!! VALID PATH FOUND!");
	
	}
}
