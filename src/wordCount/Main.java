package wordCount;

import java.util.*; // Gives me the Collections/sorts
import java.io.*; // Gives me the .toLowerCase() method

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

		// STRETCH GOAL
		// Method call to sort the top 50 words from the HashMap alphabetically
		// Create new ArrayList
		ArrayList<HashMap.Entry<String, Integer>> top50Words = new ArrayList<HashMap.Entry<String, Integer>>();
		for (int i = 0; i < 50; i++)
		{
			top50Words.add(sortedMap.get(i));
		}

		Collections.sort(top50Words, new Comparator<Map.Entry<String, Integer>>()
		{
			public int compare (HashMap.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2)
			{
				return o2.getKey().compareTo(o1.getKey());
			}
		});

		System.out.println("The top 50 words ordered alphabetically are:");
		for (int i = 0; i < 50; i++)
		{
			System.out.println(top50Words.get(i).getKey());
		}


		// print only the key values to the screen
	}

	public static void main(String[] args)
	{
		wordCount();
	}
}