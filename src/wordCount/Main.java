package wordCount;

import java.util.*;

public class Main
{
	private static void wordCount()
	{
		WordCount phrase = new WordCount();
		System.out.println(phrase.getPhrase());
	}

	public static void main(String[] args)
	{
		wordCount();
	}
}