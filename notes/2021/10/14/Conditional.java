public class Conditional
{
    /**
     * This computes the positive part of a number
     * @param x the number we are computing the positive  part of
     * @return x if x &gt; 0 and 0 otherwise.
     */
    public static double positivePart(double x)
    {
        return x > 0 ? x : 0;
    }
    /**
     * This computes the negative part of a number
     * @param x the number we are computing the negative  part of
     * @return -x if x &lt; 0 and 0 otherwise.
     */
    public static double negativePart(double x)
    {
        return x < 0 ? -x : 0;
    }
    /**
     * Use this to check sufficient closeness of floating-point numbers
     */
    public static boolean closeEnough(double x, double y)
    {
        return Math.abs(x - y) < 1e-6;
    }
    /**
     * This implements a stepwise defined function
     * @param x the argument of this function
     * @return 4 - x*x if x &lt; -2, 0 if |x| &lt;= 2 and x - 2 otherwise
     */
    public static double mathCheese(double x)
    {
        if (x < -2) {
            return 4 - (x * x);
        } else if (x <= 2) {
            return Math.abs(x);
        } else {
            return x - 2;
        }
    }
    /**
     * This checks if an alphabetical string is in the
     * first half of the alphabet.
     * @param s the String to be checked; this string must contain
     * only alphabetical characters and this check is case-insensitive
     * @return true if the s starts with a-m and false otherwise.
     */
    public static boolean isInFirstHalfOfAlphabet(String s)
    {
        return s.compareTo("n") < 0;
    }
    /**
     * This assigns a letter grade on a ten-point scale
     * @param score a final average of grades
     * @return "A" if the score is 90 or above, "B" if the score is 
     * 80 or above, etc.  IF the score is under 60, return "F"
     */
    public static String assignLetterGrade(int score)
    {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        }
        return "F";
    }
    /**
     * This implements +/- grading.  The grade of F gets no +- modifier.
     * @return "+" if the second digit of the grade is 8 or higher,
     * a "-" if the second digit of the grade is 2 or lower, and
     * a "" otherwise.  Special note: any score of 98 or higher is an A+;
     * an average can exceed 100.
     */
    public static String assignPlusMinus(int score)
    {
        if (score < 60) {
            return "";
        }
        else if (score >= 98) {
            return "+";
        } else if (score % 10 >= 8) {
            return "+";
        } else if (score % 10 <= 2) {
            return "-";
        } else {
            return "";
        }
    }
    /**
     * This assigns the full grade
     * @param score the final average
     * @return a +- grade for the average
     */
    public static String assignGrade(int score)
    {
        return String.format("%s%s", assignLetterGrade(score), assignPlusMinus(score));
    }
    public static void main(String[] args)
    {
        //test your functions in here.  Example
        System.out.println("Testing positivePart:");
        double x = 5;
        System.out.printf("Case x = %s: %s\n",  x,  closeEnough(5, positivePart(x)));
        x = 0;
        System.out.printf("Case x = %s: %s\n",  x,  closeEnough(0, positivePart(x)));
        x = -5;
        System.out.printf("Case x = %s: %s\n",  x,  closeEnough(0, positivePart(x)));
        System.out.println("Testing negativePart:");
        double y = 5;
        System.out.printf("Case y = %s: %s\n",  y,  closeEnough(0, negativePart(y)));
        y = 0;
        System.out.printf("Case y = %s: %s\n",  y,  closeEnough(0, negativePart(y)));
        y = -5;
        System.out.printf("Case y = %s: %s\n",  y,  closeEnough(5, negativePart(y)));
        System.out.println("Testing mathCheese:");
        // 4 - x*x (x < -2)
        double z = -3;
        System.out.printf("Case z = %s: %s\n",  z,  closeEnough(-5, mathCheese(z)));
        z = 2;
        System.out.printf("Case z = %s: %s\n",  z,  closeEnough(2, mathCheese(z)));
        z = 3;
        System.out.printf("Case z = %s: %s\n",  z,  closeEnough(1, mathCheese(z)));
        System.out.println("Testing isInFirstHalfOfAlphabet:");
        String test = "abcxyz";
        System.out.printf("Case test = %s: %s\n", test, isInFirstHalfOfAlphabet(test)); 
        test = "aaaaaaa";
        System.out.printf("Case test = %s: %s\n", test, isInFirstHalfOfAlphabet(test));
        test = "mmmmmmmn";
        System.out.printf("Case test = %s: %s\n", test, isInFirstHalfOfAlphabet(test)); 
        System.out.println("Testing assignGrade:");
        int score = 100;
        System.out.printf("Case score = %s: %s\n", score, assignGrade(score).equals("A+")); 
        score = 59;
        System.out.printf("Case score = %s: %s\n", score, assignGrade(score).equals("F")); 
        score = 78;
        System.out.printf("Case score = %s: %s\n", score, assignGrade(score).equals("C+")); 
        score = 82;
        System.out.printf("Case score = %s: %s\n", score, assignGrade(score).equals("B-"));
    }
}
