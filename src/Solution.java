import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Solution {

    private static Scanner in;
    private static PrintWriter out;

    public static void main(String[] args) {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        int T = readInt();

        for (int x = 1; x <= T; x++) {

            int output = 0;

            out.println("Case #" + x + ": " + output);
        }
        out.flush();
    }

    // Utility

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

    /**
     * Prints s.
     * Warning: May be slow!
     */
    private static void out(Object s) {
        System.out.println(s);
    }

    /**
     * Checks if a given long is a palindrome by reversing it.
     */
    private static boolean isPalindrome(long l) {
        long num = l;
        long reverse = 0;
        while (num > 0) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        if (reverse == l) {
            return true;
        } else {
            return false;
        }
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
     * Inserts the char at the specified index in a String. Warning: Very slow!
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
