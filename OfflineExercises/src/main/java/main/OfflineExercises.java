package main;

import java.util.ArrayList;

public class OfflineExercises {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") → "TTThhheee"
	// multChar("AAbb") → "AAAAAAbbbbbb"
	// multChar("Hi-There") → "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String output = "";
		int length = input.length();
		for (int i = 0; i < length; i++) {
			String sub = input.substring(i, i+1);
			output += sub + sub + sub;
		}
		return output;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") → "evilc"
	// getBert("xxbertfridgebertyy") → "egdirf"
	// getBert("xxBertfridgebERtyy") → "egdirf"
	// getBert("xxbertyy") → ""
	// getBert("xxbeRTyy") → ""

	public String getBert(String input) {
		int length = input.length();
		if (length <= 3) {
			return "";
		}
		int bertCounter = 0;
		String output = "";
		ArrayList<Integer> indices = new ArrayList<>();
		for (int i = 0; i <= length-4; i++) {
			if (input.substring(i, i+4).toUpperCase().equals("BERT")) {
				bertCounter++;
				indices.add(i);
			}
		}
		if (bertCounter != 2) {
			return "";
		} else {
			for (int j = indices.get(1); j >= indices.get(0) + 5 ;j--) {
				output += input.substring(j-1, j);
			}
			return output;
		}
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false
	// evenlySpaced(4, 60, 9) → false

	public boolean evenlySpaced(int a, int b, int c) {
		int subMax = Math.max(a, b);
		int fullMax = Math.max(subMax, c);
		int subMin = Math.min(a, b);
		int fullMin = Math.min(subMin, c);
		int mid;
		if (a != fullMax && a != fullMin) {
			mid = a;
		} else if (c != fullMax && c != fullMin) {
			mid = c;
		} else {
			mid = b;
		}
		if (fullMax - mid == mid - fullMin) {
			return true;
		} else {
			return false;
		}
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) → "Ho"
	// nMid("Chocolate", 3) → "Choate"
	// nMid("Chocolate", 1) → "Choclate"

	public String nMid(String input, int a) {
		int count = (input.length() - a) / 2;
		String output = "";
		output += input.substring(0, count);
		output += input.substring(input.length() - count, input.length());
		return output;
	}

	// Given a string, return true if it ends in "dev". Ignore Case

	// endsDev("ihatedev") → true
	// endsDev("wehateDev") → true
	// endsDev("everoyonehatesdevforreal") → false
	// endsDev("devisnotcool") → false

	public boolean endsDev(String input) {
		if (input.length() <3) {
			return false;
		} else if (input.substring(input.length() - 3, input.length()).toUpperCase().equals("DEV")) {
			return true;
		} else {
			return false;
		}
	}



	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") → 2
	// superBlock("abbCCCddDDDeeEEE") → 3
	// superBlock("") → 0

	public int superBlock(String input) {
		if (input.isEmpty()) {
			return 0;
		} else if (input.length() == 1) {
			return 1;
		} else {
			int counter = 1;
			int record = 0;
			for (int i = 0; i <= input.length() - 2; i++) {
				if (input.substring(i, i+1).equals(input.substring(i+1, i+2))) {
					counter++;
				} else {
					record = counter;
					counter = 1;
				}
			}
			return Math.max(counter, record);
		}
		
	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") → 1
	//amISearch("I am in Amsterdam am I?") → 2
	//amISearch("I have been in Amsterdam") → 0

	public int amISearch(String arg1) {
		if (arg1.length() < 2) {
			return 0;
		} else if (arg1.length() == 2) {
			if (arg1.toUpperCase().equals("AM")) {
				return 1;
			} else {
				return 0;
			}
		} else {
			int counter = 0;
			for (int i = 0; i <= arg1.length() - 2; i++) {
				if (arg1.substring(i, i+2).toUpperCase().equals("AM")) {
					if (i == 0) {
						if (arg1.substring(i+2, i+3).equals(" ")) {
							counter++;
						}
					} else if (i + 2 == arg1.length()) {
						if (arg1.substring(i - 1, i).equals(" ")) {
							counter++;
						}
					} else {
						if (arg1.substring(i+2, i+3).equals(" ") && arg1.substring(i - 1, i).equals(" ")) {
							counter++;
						}
					}
				}
			}
			return counter;
		}
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) → "fizz"
	//fizzBuzz(10) → "buzz"
	//fizzBuzz(15) → "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		String output = "";
		if (arg1 % 3 == 0) {
			output += "fizz";
		}
		if (arg1 % 5 == 0) {
			output += "buzz";
		}
		return output;
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") → 14
	//largest("15 72 80 164") → 11
	//largest("555 72 86 45 10") → 15
	
	public int largest(String arg1) {
		String[] nums = arg1.split(" ");
		ArrayList<Integer> totals = new ArrayList<>();
		for (String n : nums) {
			int total = 0;
			for (int i = 0; i < n.length(); i++) {
				total += (int) n.charAt(i);
			}
			totals.add(total);
		}
		int localTotal = 0;
		int prevTotal = 0;
		int maxTotal = 0;
		for (int j = 0; j < totals.size() - 1; j++) {
			int a = totals.get(j);
			int b = totals.get(j + 1);
			localTotal = Math.max(a, b);
			maxTotal = Math.max(prevTotal, localTotal);
			prevTotal = maxTotal;
		}
		return maxTotal;
	}
	
	
}
