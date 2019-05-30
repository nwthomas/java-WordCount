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
		ArrayList<HashMap.Entry<String, Integer>> sortedMap = new ArrayList<HashMap.Entry<String, Integer>>();
		sortedMap.addAll(wordMap.entrySet());

		Collections.sort(sortedMap, new Comparator<Map.Entry<String, Integer>>()
		{
			public int compare (HashMap.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2)
			{
				return o2.getValue().compareTo(o1.getValue());
			}
		});


		// Bring the top 50 words to the screen from biggest on down
		for (int i = 0; i < 50; i++)
		{
			System.out.println("The #" + (i + 1) + " most common word was \"" + sortedMap.get(i).getKey() + ".\" It occured " + sortedMap.get(i).getValue() + " times.");
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		wordCount();
	}
}