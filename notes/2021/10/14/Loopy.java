import java.util.ArrayList;

import java.math.BigInteger;
public class Loopy
{
    public static void test(String testName, Object functionOutput, Object expectedOutput) {
        String functionOutputString = functionOutput.toString();
        if (functionOutputString.length() >= 15) {
            functionOutputString = "[redacted due to length]";
        }
        // Objects.equals(functionOutput, expectedOutput);
        System.out.printf("\tCase %s = %s: %s", testName, functionOutputString, functionOutput.equals(expectedOutput) + "\n");
    }

    public static void main(String[] args)
    {
        //test your stuff here.
        System.out.println("Test -> tableOfSquares");
        
        String table_test = """
        |     x      |       y        |
        |------------|----------------|
        |    1.0     |      1.0       |
        |    2.0     |      4.0       |
        |    3.0     |      9.0       |
        |    4.0     |      16.0      |
        |    5.0     |      25.0      |
        |    6.0     |      36.0      |
        |    7.0     |      49.0      |
        """;
        Loopy.test("table_test", tableOfSquares(1, 8, 1), table_test);

        System.out.println("Test -> firstHalf");

        ArrayList<String> emails = new ArrayList<String>();
        emails.add("hello@gmail.com");
        emails.add("zabc@gmail.com");
        ArrayList<String> output = new ArrayList<>();
        output.add("hello");
        Loopy.test("email_one", firstHalf(emails), output);
        emails.add("beta@alpha");
        output.add("beta");
        Loopy.test("email_two", firstHalf(emails), output);

        System.out.println("Test -> isInFirstHalfOfAlphabet");


        System.out.println("Test -> firstHalfInPlace");

        ArrayList<String> emails_two = new ArrayList<>(emails);
        firstHalfInPlace(emails_two);
        Loopy.test("emailsInPlace_two", emails_two, output);

        System.out.println("Test -> permutations");
        Loopy.test("permutations_one", permutations(4, 2), BigInteger.valueOf(6));
        Loopy.test("permutations_two", permutations(52, 5), BigInteger.valueOf(2598960));

        System.out.println("Test -> choose");
        Loopy.test("choose_one", choose(1_000, 3), BigInteger.valueOf(166167000));
        Loopy.test("choose_two", choose(52, 5), BigInteger.valueOf(2_598_960));

    }

    public static String centerString (int width, String s) {
        return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    /**
     * produce a table of values for the square function starting
     * at start, ending before end, and whhich increments the x-value
     * by increment. Return this in a string.
     */
    public static String tableOfSquares(double start, double end, double increment)
    {
        String out = String.format("|%s|%s|", Loopy.centerString(12, "x"), Loopy.centerString(16, "y"));
        out += "\n|------------|----------------|\n";
        for (double i = start; i < end; i += increment) {
            out += String.format("|%s|%s|", Loopy.centerString(12, Double.toString(i)), Loopy.centerString(16, Double.toString(Math.pow(i, 2)))) + "\n";
        }
        return out;
    }

    /**
     * This checks if an alphabetical string is in the
     * first half of the alphabeet.
     * @param s the String to be checked; this string must contain
     * only alphabetical characters and this check is case-insensitive
     * @return true if the s starts with a-m and false otherwise.
     */
    public static boolean isInFirstHalfOfAlphabet(String s)
    {
        return Character.getNumericValue(s.charAt(0)) < 23;
    }

    /**
     * @param roster a list of email names
     * @return an ArrayList of names in the first half of the alphabet, case insensitive
     */
    public static ArrayList<String> firstHalf(ArrayList<String> roster)
    {
        ArrayList<String> names = new ArrayList<>();
        for (String email : roster) {
            String[] split = email.split("@");
            String name = split[0];
            if (isInFirstHalfOfAlphabet(name)) {
                names.add(name);
            }
        }
        return names;
    }

    /**
     * @param roster a list of email names
     * This has the side-effect of filtering in all elements in the
     * first half of the alphabet, case insensitive.
     */
    public static void firstHalfInPlace(ArrayList<String> roster)
    {
        for (int i = 0; i < roster.size(); i++) {
            String email = roster.get(i);
            String[] split = email.split("@");
            String name = split[0];
            roster.set(i, name);
            if (!isInFirstHalfOfAlphabet(name)) {
                roster.remove(i);
                i--; // size changes, so should the index.
            }
        }
    }
    /**
     * @param n the size of the population
     * @param k the size of the sample
     * @return the number of ordered samples of size k 
     * in the population. This is n(n-1)(n-2).....  (n-k+1).
     */
    public static BigInteger permutations(int n, int k)
    {
        if (n == k || k == 0) {
            return BigInteger.ONE;
        }
        if (n == 1) {
            return BigInteger.valueOf(n);
        }
        return permutations(n - 1, k - 1).add(permutations(n - 1, k));
    }

    /**
     * @param n the size of the population
     * @param k the size of the sample
     * @return the number of ordered samples of size k 
     * in the population. This is 
     * n(n-1)(n-2).....  (n-k+1)/k!.
     * Be smart:  the product  of any k consecutive integers
     * is divisible by k.  You should be able to compute
     * choose(1_000_000_000, 3).  hint: ZIPPER
     */
    public static BigInteger choose(int n, int k)
    {
        BigInteger out = BigInteger.valueOf(n);

        for (int i = 1; i <= k; i++) {
            out = out.divide(BigInteger.valueOf(i));
            if (i != k) {
                out = out.multiply(BigInteger.valueOf(n - i));
            }
        }
        return out;
    }
}
