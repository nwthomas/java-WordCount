package wordCount;

import java.util.*;
import java.io.*;

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
		String cleanPhrase = removePunctuation(phrase.getPhrase().toLowerCase());

		// Create an array of words based off of the cleanPhrase variable
		String[] wordsArr = cleanPhrase.split(" +");

		// Loop over phrase and tally up words using a new HashMap to store values
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>(); // Calls constructor
		for (String word : wordsArr)
		{
			if (!wordMap.containsKey(word))
			{
				wordMap.put(word, 1);
			}
			else
			{
				wordMap.put(word, (wordMap.get(word) + 1));
			}
		}

		// Sort HashMap into array from biggest to smallest

		// Bring the top 50 words to the screen from biggest on down
	}

	public static void main(String[] args)
	{
		wordCount();
	}
}