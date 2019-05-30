package wordCount;

import java.util.*;

public class Main
{
	private static String removePunctuation(String phrase)
	{
		return phrase.replaceAll("[[\\.\\?\\!\\,\\;\\:\\{\\}\\(\\)\\']]", "");
	}

	private static void wordCount()
	{
		// Create a new instance of the WordCount phrase and assign it to the "phrase" variable
		WordCount phrase = new WordCount();

		// Remove punctuation and returns a string assigned to a new variable cleanPhrase
		String cleanPhrase = removePunctuation(phrase.getPhrase());

		// Create an array of words based off of the cleanPhrase variable
	}

	public static void main(String[] args)
	{
		wordCount();
	}
}