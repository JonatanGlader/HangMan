package HM;
import java.util.Random;

public class RandomWord {

	public static String[] words = {"java", "hangman", "statement", "random", "string"};
	
	public static String getWord()
	{
		Random randomizer = new Random();
		String s = "";
		s = words[randomizer.nextInt(words.length)];
		return s;
	}
	
}
