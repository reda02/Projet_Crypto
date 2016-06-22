package com.crypto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Frequencies {
	HashMap<Character, Double> frequenceLetter = new HashMap<Character, Double>();
	List<Entry<Character, Double>> list;


	public Frequencies() {
		frequenceLetter.put(' ', 16.024);
		frequenceLetter.put('A', 7.636);
		frequenceLetter.put('B', 0.901);
		frequenceLetter.put('C', 3.260);
		frequenceLetter.put('D', 3.669);
		frequenceLetter.put('E', 14.715);
		frequenceLetter.put('F', 1.066);
		frequenceLetter.put('G', 0.866);
		frequenceLetter.put('H', 0.737);
		frequenceLetter.put('I', 7.529);
		frequenceLetter.put('J', 0.545);
		frequenceLetter.put('K', 0.049);
		frequenceLetter.put('L', 5.456);
		frequenceLetter.put('M', 2.968);
		frequenceLetter.put('N', 7.095);
		frequenceLetter.put('O', 5.378);
		frequenceLetter.put('P', 3.021);
		frequenceLetter.put('Q', 1.362);
		frequenceLetter.put('R', 6.553);
		frequenceLetter.put('S', 7.948);
		frequenceLetter.put('T', 7.244);
		frequenceLetter.put('U', 6.311);
		frequenceLetter.put('V', 1.628);
		frequenceLetter.put('W', 0.114);
		frequenceLetter.put('X', 0.387);
		frequenceLetter.put('Y', 0.308);
		frequenceLetter.put('Z', 0.136);

		list = new ArrayList<Entry<Character, Double>>(
				frequenceLetter.entrySet());
	}
	public HashMap<Character, Double> getFrequenceLetter() {
		return frequenceLetter;
	}

	public void print() {
		System.out.println(frequenceLetter);
	}

	public List<Entry<Character, Double>> getList() {
		return list;
	}

	public void printSorted() {
		Collections.sort(list, new ComparatorNew());
		System.out.println(list);
	}

	public class ComparatorNew implements Comparator<Entry<Character, Double>> {
		@Override
		public int compare(Entry<Character, Double> arg0,
				Entry<Character, Double> arg1) {
			return arg1.getValue().compareTo(arg0.getValue());
		}
	}
}
