import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Solution {

    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);

        int T = readInt();

        for (int x = 1; x <= T; x++) {
            // Read input
            int[] info = readIntArr();
            int numParticipants = info[0];
            int numDays = info[1];
            int johnId = info[2];
            int[][] steps = new int[numParticipants][numDays];
            for (int i = 0; i < steps.length; i++) {
                steps[i] = readIntArr();
            }
            // Compare all participants for each day
            int output = 0;
            for (int i = 0; i < numDays; i++) {
				int maxDiff = 0;
                for (int j = 0; j < numParticipants; j++) {
                    int difference = steps[j][i] - steps[johnId-1][i];
					maxDiff = Math.max(maxDiff, difference);
                }
				output += maxDiff;
            }
            out("Case #" + x + ": " + output);
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

    private static void out(Object s) {
        System.out.println(s);
    }

    /**
     * Removes the char at the spcified index from a String. Warning: Very slow!
     */
    private static String removeChar(String s, int index) {
        String result = "";
        for (int i = 0; i < s.length(); i++)
            if (i != index)
                result += s.charAt(i);
        return result;
    }

    /**
     * Removes the char at the spcified index from a String. Warning: Very slow!
     */
    private static String setChar(String s, int index, char c) {
        String result = "";
        for (int i = 0; i < s.length(); i++)
            if (i != index)
                result += s.charAt(i);
        return result;
    }

    /**
     * Inserts the char at the spcified index in a String. Warning: Very slow!
     */
    private static String insertChar(String s, int index, char c) {
        String result = "";
        for (int i = 0; i < s.length(); i++)
            if (i != index)
                result += s.charAt(i);
            else {
                result += c;
                result += s.charAt(i);
            }
        return result;
    }

}
