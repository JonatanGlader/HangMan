package HM;

import java.util.Arrays;

public class GuessWord {

	public char[] wordToGuess;
	char[] guessedWord;
	
	public GuessWord(String word)
	{
		wordToGuess = word.toCharArray();
		guessedWord = new char[wordToGuess.length];
		
		for(int i = 0; i < wordToGuess.length; i++)
		{
			guessedWord[i] = '-';
		}
		System.out.println("\n\n\nGuess the Word: \n");
		System.out.println(guessedWord);
	}
	
	public void printWord()
	{
		System.out.println(guessedWord);
	}
	
	public boolean tryWith(char input)
	{
		for (int i = 0; i < wordToGuess.length; i++)
		{
			if(wordToGuess[i] == input)
			{
				guessedWord[i] = input;
			}
		}
			System.out.println(guessedWord);
		if(Arrays.toString(wordToGuess).contains(Arrays.toString(guessedWord)))
		{
			System.out.print("You have guessed the word! Word was: ");
			System.out.println(guessedWord);
			return true;			
		}		
		else
			return false;
	}
	
}
