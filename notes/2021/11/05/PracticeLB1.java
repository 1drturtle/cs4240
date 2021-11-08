import java.util.ArrayList;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/*
 * Useful hints:
 * You can use the static service class Arrays if you wish.  
 * It's java.util.Arrays.   It can be handy.
 * Arrays has a static service method for sorting
 *
 * to split as in python, use .split("\\s+") on the string you wish
 * to split on whitespace
 *
 * Collections.sort() will sort an arraylist in place.
 * 
 * DO NOT COMPARE DOUBLES FOR EQUALITY!!!
 * Use the function closeEnough I have provided for free.  It will
 * work nicely here.  Just use closeEnough(a, b) instead of a == b.
 */
public class PracticeLB1
{
    /**
     * This is our tolerance for fuzziness in checking equality of doubles.
     */
    public static final double TINY = 1e-6;
    /** 
     * Da main
     */
    public static void main(String[] args)
    {   
        //use this for any test code.  You WANT to write test code.
        System.out.println("Test -> prepareAnagram");
        System.out.println(prepareAnagram("Mississippi").equals("iiiimppssss"));
        System.out.println("Test -> initially");
        System.out.println(initially("Eat my shorts").equals("EMS"));
        System.out.println("Test -> isAFactorial");
        System.out.println(isAFactorial(BigInteger.valueOf(720)));
        System.out.println(isAFactorial(BigInteger.valueOf(5040)));
        System.out.println(!isAFactorial(BigInteger.valueOf(59)));
        System.out.println("Test -> trimmedMean");
        ArrayList<Double> nums = new ArrayList<>();
        nums.add(4.0);
        nums.add(30.0);
        nums.add(100.0);
        nums.add(-3.0);
        nums.add(7.0);
        ArrayList<Double> nums_one = new ArrayList<>(nums);
        System.out.println(closeEnough(trimmedMean(nums_one, 2), 7.0));
        ArrayList<Double> nums_two = new ArrayList<>(nums);
        System.out.println(closeEnough(trimmedMean(nums_two, 1), 13.6666667));
        System.out.println("Test -> charFreq");
        ArrayList<Double> charTest = new ArrayList<Double>(Collections.nCopies(26, 0.0));
        System.out.println(charFreq("").equals(charTest));
        charTest.set(0, 3.0);
        System.out.println(charFreq("aaa").equals(charTest));
        charTest.set(25, 1.0);
        System.out.println(charFreq("aaaz").equals(charTest));
        System.out.println("Test -> factorialDigit");
        System.out.println(factorialDigit(10, 8) == 2);
        System.out.println(factorialDigit(10_000, 9) == 3282);

    }   
    /**
     * free function to compare doubles for near equality.
     * @param a one double to be compared
     * @param b another double to be compared
     * @return true if Math.abs(a - b) &lt; 1e-6.
     */
    public static boolean closeEnough(double a, double b)
    {
        return Math.abs(a - b) < TINY;
    }
	/**
	* This lower-cases a string of letters, and returns a new string
    * with its characters sorted in alphabetical order 
    * @param s a string
    * @return a string containing the letters of s in alphabetical 
    * order.
	*/
	public static String prepareAnagram(String s)
	{
        char[] x = s.toLowerCase().toCharArray();
        Arrays.sort(x);
        return new String(x);
	}

	/**
    * This takes a string consisting of letters and returns a string containing
    * all of the first letters of the words in the string in upper-case with
    * its characters sorted in alphabetical order 
    * @param s a string
    * @return a string containing the first letters of S in upper-case
	*/
	public static String initially(String s)
	{
        s = s.toUpperCase();

        String[] split = s.split("\\s+"); // same as python default split.
        
        String out = "";

        for (String word : split) {
            out += word.charAt(0);
        }

        return out;
	}

    public static BigInteger factorial(int num) {
        BigInteger out = BigInteger.valueOf(1);

        for (long x = 2; x <= num; x++) {
            out = out.multiply(BigInteger.valueOf(x));
        }

        return out;
    }

    /**
     * This tests to see if a BigInteger is the factorial of some positive integer.
     * @param b a BigInteger
     * @return true if b is the factorial of some nonnegative integer n.
     */
    public static boolean isAFactorial(BigInteger b)
    {
        int n = 1;

        while (factorial(n).compareTo(b) < 0)
        {
            n += 1;
        }

        return factorial(n).equals(b);
    }
    /**
     * This lops the largest and smallest entries off an ArrayList of doubles
     * and, averages the rest, and returns that average.
     * @param a is an ArrayList of Doubles
     * @param trimmed is an even nonnegative integer.  As a precondition,
     * 2*timmmed &lt; a.size().  This is the total number of entries to be
     * trimmed off.
     * @return the mean of the values in the array list with the 
     * smallest trimmed/2 and largest trimmed/2 elements removed.
     */
	public static double trimmedMean(ArrayList<Double> a, int trimmed)
	{
        Collections.sort(a);

        int x = trimmed;
        while (x > 0)
        {
            x -= 1;
            a.remove(0);
            a.remove(a.size() - 1);
        }
    
        double total = 0;
        for (double d : a) {
            total += d;
        }

        return total / a.size();
	}
    /**
     * This creates a letter-frequency table for a string in the form of an
     * ArrayList.  Note that the letter frequencies are relative to the number
     * of <em>alphabetical</em> characters. All non-alpha characters are ignored.
     * @param s is a string
     * @return The relative frequency of each letter in the alphabet
     * in an array list of Doubles, where the frequency for 'a' is stored at
     * entry 0, 'b' is stored at entry 1, usw.  This should be case insensitive.
     * The relative frequency should ignore all non-alpha characters.
     */
    public static ArrayList<Double> charFreq(String s)
    {
        s = s.toLowerCase();
        ArrayList<Double> list = new ArrayList<Double>(Collections.nCopies(26, 0.0));
        for (char c : s.toCharArray())
        {
            int codePoint = Character.valueOf(c);
            if (codePoint <= 122 && codePoint >= 97) // >= a, <= z
            {
                codePoint -= 97; // lowercase A code is 97, making all letters 0-25
                list.set(codePoint, list.get(codePoint) + 1);
            }
        }

        return list;
    }
    /**
     * This finds the number of times a specified digit
     * appears in decimal representation of n!
     * This should work for 10000!.
     * @param n is a nonnegative integer
     * @return the number of times the digit <code>digit</code>
     * appears in the decimal representation of n!
     */
    public static int factorialDigit(int n, int digit)
    {
        BigInteger f = factorial(n);
        int occurences = (int) f.toString()
                                .codePoints()
                                .filter(ch -> ch == Integer.toString(digit).codePointAt(0))
                                .count();
        return occurences;
    }
}
