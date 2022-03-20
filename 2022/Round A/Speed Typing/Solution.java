/*
 * This solution solves Test Sets 1 and 2.
 * This algorithm has a linear runtime, which seems to be sufficient.
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

		// How many chars have to be removed?

		for (int i = 0; i < n; i++) {
			boolean finished = false;
			String out = "Case #" + (i + 1) + ": ";
			int output = 0;
			// Read input as char arrays
			ArrayList<Character> I = new ArrayList<>();
			for (Character c: readLine().toCharArray()) {
				I.add(c);
			}
			ArrayList<Character> P = new ArrayList<>();
			for (Character c: readLine().toCharArray()) {
				P.add(c);
			}
			// Compare I and P
			for (int j = 0; j < I.size(); j++) {
				if (P.size() < I.size() || P.isEmpty()) {
					out += "IMPOSSIBLE";
					finished = true;
					break;
				}
				if (I.get(j) != P.get(j)) {
					P.remove(j);
					j--;
					output++;
				}
				// Remove leftover chars during last iteration
				if (j == I.size() - 1) {
					while (I.size() < P.size()) {
						P.remove(P.size()-1);
						output++;
					}
				}
			}

			if (!finished)
				out += output;
			System.out.println(out);
		}
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
