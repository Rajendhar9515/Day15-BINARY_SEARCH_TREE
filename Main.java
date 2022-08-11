package com.bridgelabz.hash_table;

public class Main {

	public static void main(String[] args) {
		HashTable<String, Integer> map = new HashTable<>();
		String message = "Paranoids are not paranoid because they are paranoid but "
				+ "because they keep putting themselves deliberately into paranoid avoidable situations";

		String[] messageArray = message.toLowerCase().split(" ");

		for (String word : messageArray) {
			Integer value = map.get(word);

			if (value == null)
				value = 1;
			else
				value = value + 1;
			map.add(word, value);
		}
		System.out.println(map.size());
		map.remove("avoidable");
		System.out.println(map.size());
	}
}