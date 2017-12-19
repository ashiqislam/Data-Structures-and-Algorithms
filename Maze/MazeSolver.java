import java.util.Stack;

/**
 * 
 * @author Ashiq Islam
 * Professor Wei
 * Data Structures and Algorithms
 * 
 */

public class MazeSolver {
	
	final char START = 'S';
	final char EXIT = 'E';
	final char PATH = 'P';
	final char BLOCKED = 'X';
	final char VISITED = '.';
	

public void Validate(char[][] maze, boolean check) { //Finds/Creates Path by replacing P with "."
	for (int row = 0; row < maze.length; row++) { // Nested for loop to iterate through 2D Maze - Validate
		for (int col = 0; col < maze[row].length; col++) {
			 if ((maze[row][col] == START) || (maze[row][col] == EXIT) || (maze[row][col] == PATH)
					 || (maze[row][col] == VISITED) || (maze[row][col] == BLOCKED)) { 
				 check = true;
			 } else if ((maze[row][col] != START) || (maze[row][col] != EXIT) || (maze[row][col] != PATH)
					 || (maze[row][col] != VISITED) || (maze[row][col] != BLOCKED)) {
				 check = false;
				 System.out.println("NO VALID PATH FOUND! PLEASE TRY AGAIN!");
				System.exit(0);
			 }
		}
	}
}


public void CreatePath(char[][] maze, Stack<Character> s1) { //Finds/Creates Path by replacing P with "."
	for (int row = 0; row < maze.length; row++) {// Nested for loop to iterate through 2D Maze - CreatesPath
		for (int col = 0; col < maze[row].length; col++)
			{
			 if (maze[row][col] == PATH) {
				 s1.push(maze[row][col] = VISITED);
			 }			
		}
	}
}

	public void DisplayMaze(char[][] maze, Stack<Character> s1) {
		
		for (int row = 0; row < maze.length; row++) { //Nested for loop to iterate through 2D Maze - Prints Maze
			for (int col = 0; col < maze[row].length; col++)
				{
				s1 = new Stack<Character>(); //Creates new Stack object
					s1.push(maze[row][col]); //pushes char elements into Stack
					
					System.out.print(s1);
				}
			System.out.println(); //Skips line after printing each row
			}
		}
}
