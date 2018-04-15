package me.practice.algo.string;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FindWordsinEachSentence {
	
	public List<Integer> find(String word, String text) {
		List<Integer> sentenceNumber = new ArrayList<>();
		int count = 1;
		BreakIterator breakIterator = BreakIterator.getSentenceInstance(Locale.US);
		breakIterator.setText(text);
		int start = breakIterator.first();
		for(int end = breakIterator.next(); end != BreakIterator.DONE; start = end, end = breakIterator.next()) {
			if(text.substring(start, end).contains(word))
				sentenceNumber.add(count);
			++count;
		}
		return sentenceNumber;
	}
	
	public List<Integer> find(String word, File file) throws FileNotFoundException {
		try (Scanner s = new Scanner(file)) {
			StringBuilder sb = new StringBuilder();
			while(s.hasNextLine()) 
				sb.append(s.nextLine());
			return this.find(word, sb.toString());
		}
	}
	
	public static void main(String[] args) {
		FindWordsinEachSentence obj = new FindWordsinEachSentence();
		String word = "test";
		String sentence = "This is a test. This is a T.L.A. test. Now with a Dr. in it.";
		List<Integer> sentenceNumber = obj.find(word, sentence);
		
		System.out.print(String.format("Word [%s] is present in line numbers : ", word));
		for(Integer num : sentenceNumber)
			System.out.print(num + ", ");
	}
}
