import java.util.Stack;
import java.util.Scanner;

public class Palindrome {
	static String input;
		
	public static void GetUserInput() {
	        System.out.println("Please enter word or sentence: ");
	        Scanner kb = new Scanner(System.in);
	        input = kb.nextLine().replaceAll("[^a-zA-Z]+",""); //REMOVES ALL SPECIAL CHARACTERS
	        //KEEP DIGITS? ADD [ .replaceAll("[^a-zA-Z0-9]+","") ]
	}
	
	public static void EvaluateInput() {
		  input = input.replaceAll("\\s+","").toLowerCase(); //REMOVES ALL SPACES AND CONVERTS ALL CHARACTERS TO LOWERCASE
	  
		  Stack<Character> stack = new Stack<Character>();

	        for (int i = 0; i < input.length(); i++) { //INSERTION METHOD
	            stack.push(input.charAt(i)); 
	        }
	        if(input.length()==0) {
	        	System.out.println("You entered an Empty String!");
			}

	        String reverseInput = "";

	        while (!stack.isEmpty()) { //METHOD TO REVERSE input and make it equal to reverseInput
	            reverseInput += stack.pop();
	        }
	        
	        //System.out.println(reverseInput); //Tester

	        if (input.equals(reverseInput))
	            System.out.println("This is a Palindrome.");
	        else
	            System.out.println("Sorry, This is not a palindrome.");
		  
		  try { //Pauses the code execution for 1.5 second so user can see results clearly. [PROGRAM CLARITY FEATURE]
              Thread.sleep(1500); 
          } catch (InterruptedException e) {}
          
		  Palindrome.RestartProgram();
		
	}
	
	public static void RestartProgram() {
		Scanner keyboard = new Scanner(System.in);
		char answer = '\0'; // makes answer equal to null.
		System.out.println("\nWould you like to try another string? Enter Y for Yes or N for No: ");
		answer = (keyboard.next()).toUpperCase().charAt(0);
		while(answer != 'Y' && answer != 'N') {
    		System.out.println("Sorry. Invalid Entry. (Restart?) Please enter Y for Yes or N for No: ");
    		answer = (keyboard.next()).toUpperCase().charAt(0);
    	}
    	if(answer == 'Y') {
    		Palindrome.GetUserInput();
    		Palindrome.EvaluateInput();
    	} else if (answer == 'N') {
    		System.out.println("Thanks for using this Program! Goodbye!");
    		keyboard.close();
    		System.exit(0);
    	  }
    }
}

	