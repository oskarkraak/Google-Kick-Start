/*
 * This will only solve Test Set 1 for two reasons:
 * 1.	The numbers in Test Set 2 can go up to 10^12, whereas an int can only store numbers up to 2^31 (~ 10^9).
 * 		A larger data type would have to be used.
 * 2.	This algorithm is too slow for such large values.
 * 		It could be optimized or a more efficient algorithm could be developed.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Solution {

	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = readInt();

		for (int i = 0; i < n; i++) {
			int interesting = 0;
			int[] input = readIntArr();
			int min = input[0];
			int max = input[1];
			// Loop through the range min-max
			for (int a = min; a <= max; a++) {
				String num = Integer.toString(a);
				long digitSum = 0;
				long digitProduct = 1;
				// Compute digit sum and digit product
				for (int j = 0; j < num.length(); j++) {
					digitSum += Integer.parseInt(num.substring(j, j + 1));
					digitProduct *= Integer.parseInt(num.substring(j, j + 1));
				}
				if (digitProduct % digitSum == 0) {
					interesting++;
				}
			}
			out("Case #" + (i + 1) + ": " + interesting);
		}

	}

	private static void out(Object s) {
		System.out.println(s);
	}

	/**
	 * Reads one line, separates words
	 */
	private static String[] readWords() {
		return readLine().split(" ");
	}

	/**
	 * Reads one line of integers, separates them
	 */
	private static int[] readIntArr() {
		return toIntArr(readWords());
	}

	/**
	 * Converts a String[] to an int[]
	 */
	private static int[] toIntArr(String[] s) {
		int[] intArr = new int[s.length];
		for (int i = 0; i < s.length; i++)
			intArr[i] = Integer.parseInt(s[i]);
		return intArr;
	}

	/**
	 * Reads a single integer and advances to the next line
	 */
	private static int readInt() {
		int i = in.nextInt();
		in.nextLine();
		return i;
	}

	/**
	 * Reads the next line
	 */
	private static String readLine() {
		return in.nextLine();
	}

}
