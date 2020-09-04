package HM;

import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		
		boolean isWordGuessed = false;
		ArrayList<String> lettersUsed = new ArrayList<>();
		Scanner reader = new Scanner(System.in);		
		String word = ""; //this is the word to be guessed!
		String guess = "";
		int wrongGuesses = 0;
		
		word = selectMode(reader); //selects the word from either a random list, or a own word
		GuessWord guessWord = new GuessWord(word);
				
		while (!isWordGuessed) //starts the game
		{
			System.out.println("you have tried with: " +lettersUsed);
			guess = reader.nextLine().toLowerCase();
			System.out.println("\n\n\n\n\n");
			if (guess.length() > 1) //if user inputs more than just a letter
			{
				System.out.println("You have entered: " + guess + ". Please enter a single letter");
				guessWord.printWord();
			}
			else if (lettersUsed.contains(guess)) //if the user has already entered the letter
			{
				System.out.println("You have already entered: " + guess + ". Please enter another single letter");
				guessWord.printWord();
			}
			else if (word.contains(guess)) //checks if the word contains the letter
			{
				isWordGuessed = guessWord.tryWith(guess.charAt(0));
				lettersUsed.add(guess);
			}
			else //if the word doesn't contain letter, it adds it to the list of letters used
			{
				lettersUsed.add(guess);
				wrongGuesses++;
				DrawMan.draw(wrongGuesses);
				guessWord.printWord();
			}	
			
			if (wrongGuesses == 8)
			{
				isWordGuessed = true;
				System.out.println("the man is hanging! Sorry, you lost. The word was: " + word);
			}
		}
		
		reader.close();
	}
	
	private static String selectMode(Scanner reader)
	{
		System.out.println("Please select a mode");
		System.out.println(" [1]-Guess a random word");
		System.out.println(" [2]-Type your own word to guess");
		boolean b = false;
		int choice = 0;
		String word ="";
		
		while (b == false)
		{
			try
			{
				choice = Integer.parseInt(reader.nextLine());
				if(choice == 1)
				{
					System.out.println("You have chosen to guess a random word!");
					word = RandomWord.getWord();
					System.out.println("Random word is set");
					b=true;
				}
				else if(choice == 2)
				{
					System.out.println("You have chosen to enter your own word!");
					System.out.println("Please enter a word");
					word = reader.nextLine();
					System.out.println("Word is set to: " + word);
					b=true;
				}
				else
					b=false;
			}
			catch (NumberFormatException e)
			{
				b = false;
				System.out.println("please enter 1 or 2");
				System.out.println(" [1]-Guess a random word");
				System.out.println(" [2]-Type your own word to guess");
			}
		}
		return word;
	}

}
