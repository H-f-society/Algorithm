/*
* @Author: root
* @Date:   2019-09-19 21:26:46
* @Last Modified by:   root
* @Last Modified time: 2019-09-25 21:01:46
*/
import java.util.*;

public class KMP {
	static String[] word = {
		"Computer Data Structures",
		"Introduction to Data Structures",
		"Fundamentals of Data Structures",
		"The design and Analysis of Computer Algorithms",
		"Introduction to Numerical Analysis",
		"Numerical Analysis"
	};
	static String key = "Structures";
	static int[] next = new int[key.length()];

	public static void main(String[] args) {
		Long startTime, endTime;

		getNext(key, next);
		for(int val : next) {
			System.out.print(val + ", ");
		}
		System.out.println();

		// 穷举/
		
		startTime = System.nanoTime();
		System.out.println("穷举: " + isTrue1(word, key));
		endTime = System.nanoTime();
		System.out.println("runTime: " + (endTime - startTime) + "ns");

		// 穷举
		startTime = System.nanoTime();
		System.out.println("穷举: " + isTrue2(word, key));
		endTime = System.nanoTime();
		System.out.println("runTime: " + (endTime - startTime) + "ns");

		// KMP
		startTime = System.nanoTime();
		System.out.println("KMP: " + isKMP(word, key));
		endTime = System.nanoTime();
		System.out.println("runTime: " + (endTime - startTime) + "ns");

		// BoyerMoore
		startTime = System.nanoTime();
		System.out.println("B_M: " + BoyerMoore(word, key));
		endTime = System.nanoTime();
		System.out.println("runTime: " + (endTime - startTime) + "ns");
	}
	public static void getNext(String key, int[] next) {
		int i = 0, j = -1;
		next[0] = -1;
		while(i < key.length() - 1) {
			if(j == -1 || key.charAt(i) == key.charAt(j)) {
				i++;
				j++;
				next[i] = j;
			}else {
				j = next[j];
			}
		}
	}

	public static List<List<String>> isTrue1(String[] word, String key) {
		List<List<String>> result = new ArrayList<>();
		for(String val : word) {
			List<String> list = new ArrayList<>();
			for(int i=0; i<val.length(); i++) {
				int j = 0, k = i;
				while(val.charAt(k) == key.charAt(j)) {
					if(j == key.length() - 1) {
						list.add(val);
						break;
					}
					k++; j++;
				}
			}
			if(!list.isEmpty()) result.add(list);
		}
		return result;
	}
	public static List<List<String>> isTrue2(String[] word, String key) {
		List<List<String>> result = new ArrayList<>();
		for(String val : word) {
			List<String> list = new ArrayList<>();
			int i = 0, j = 0;
			while(i<val.length() && j<key.length()) {
				if(val.charAt(i) == key.charAt(j)) {
					i++;
					j++;
				}else {
					i = i - j + 1;
					j = 0;
				}
				if(j == key.length() - 1)
					list.add(val);
			}
			if(!list.isEmpty()) result.add(list);
		}
		return result;
	}
	public static List<List<String>> isKMP(String[] word, String key) {
		List<List<String>> result = new ArrayList<>();
		for(String val : word) {
			List<String> list = new ArrayList<>();
			int i = 0, j = 0;
			while(i<val.length() && j<key.length()) {
				if(j == -1 || val.charAt(i) == key.charAt(j)) {
					i++;
					j++;
				}else {
					j = next[j];
				}
				if(j == key.length() - 1)
					list.add(val);
			}
			if(!list.isEmpty()) result.add(list);
		}
		return result;
	}
	public static List<List<String>> BoyerMoore(String[] word, String key) {
		List<List<String>> result = new ArrayList<>();
		for(String val : word) {
			List<String> list = new ArrayList<>();


			if(!list.isEmpty()) result.add(list);
		}
		return result;
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 7e639d274c1ed6a823796ee263f3ef3984b156cf
