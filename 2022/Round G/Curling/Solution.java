import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Solution {

    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);

        int T = readInt();

        for (int x = 1; x <= T; x++) {
            // Read input
            int[] R = readIntArr();
            int diskRadius = R[0];
            int houseRadius = R[1];
            // Read stone locations and save their distance from the center of the house
            // Also save the closest stone for each team to determine the winner
            HashSet<Double> team1Stones = new HashSet<>();
            double team1Closest = houseRadius + diskRadius + 1;
            for (int i = readInt(); i > 0; i--) {
                int[] in = readIntArr();
                double dist = distanceFromOrigin(in[0], in[1]);
                if (dist <= houseRadius + diskRadius)
                    team1Stones.add(dist);
                if (distanceFromOrigin(in[0], in[1]) < team1Closest)
                    team1Closest = dist;
            }
            HashSet<Double> team2Stones = new HashSet<>();
            double team2Closest = houseRadius + diskRadius + 1;
            for (int i = readInt(); i > 0; i--) {
                int[] in = readIntArr();
                double dist = distanceFromOrigin(in[0], in[1]);
                if (dist <= houseRadius + diskRadius)
                    team2Stones.add(dist);
                if (dist < team2Closest)
                    team2Closest = dist;
            }
            // Make sure the winner is team1 (swap if necessary)
            int winner = 0; // Store the original order
            if (team2Closest < team1Closest) {
                winner = 1;
                team1Stones = team2Stones; // No need to swap - team1Stones is not required
                double tempClosest = team1Closest;
                team1Closest = team2Closest;
                team2Closest = tempClosest;
            }
            // Count score for winner
            int score = 0;
            for (double d : team1Stones)
                if (d < team2Closest)
                    score++;
            // Output
            int team1;
            int team2;
            if (winner == 0) {
                team1 = score;
                team2 = 0;
            } else {
                team1 = 0;
                team2 = score;
            }
            out("Case #" + x + ": " + team1 + " " + team2);
        }
    }

    private static double distanceFromOrigin(int x, int y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
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
