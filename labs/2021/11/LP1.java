import java.util.ArrayList;
import java.util.stream.Collectors;
import java.math.BigInteger;
import java.time.LocalDate;

/**
*  Glorious Lab Practical on Java
*/
public class LP1
{
    /** 
     * This computes  the sum of a list of BigIntegers
     * @param a an array list of BigIntegers
     * @return the sum of the BigIntegers in a
     */
    public static BigInteger sum(ArrayList<BigInteger> a)
    { 
        BigInteger out = BigInteger.ZERO;
        for (BigInteger x : a)
        {
            out = out.add(x);
        }
        return out;
    }   
	/**
	* This plucks out entries of a string at indices divisible by p.
    * in a string.  
    * @param s a string
    * @param p a nonnegative integer.  
    * @return a string that has entries p, 2p, 3p,   etc of the
    * string s.
    *  Examples:
    * aerate("aardwolf" 2) -&gt; "arwl"
    * aerate("bacchanalia" 3) -&gt; "bcni"
    */    
	public static String aerate(String s, int p)
	{
        String out = "";
        for (int i = 0; i < s.length(); i++)
        {
            if (i % p == 0)
            {
                out += s.charAt(i);
            }
        }
        return out;
	}
    /**
     * This makes a string echoy.  See the example
     * @param s is a string
     * @return a string with the nth character repeated n times.  
     * example:  echoy("cowpie") &rarr; coowwwppppiiiiieeeeee
     * if the string passed is empty, return an empty string
     */
    public static String echoy(String s)
    {
        String out = "";
        for (int i = 0; i < s.length(); i++) 
        {
            for (int j = 0; j < (i + 1); j++) // we can't * multiply strings, so for loop it is.
            {
                out += Character.toString(s.charAt(i));
            }
        }
        return out;
    }
    /** 
     * This computes the product of the non-zero elements of
     * a and returns the sum of its digits.
     * @param all an array list
     * @return the sum of the digits in the product of the 
     * non-zero entries in a
     */
    public static int finger(ArrayList<BigInteger> all)  
    {   
        if (all.size() == 0) return 0;

        BigInteger big_total = BigInteger.ONE;
        for (BigInteger x : all)
        {
            if (!x.equals(BigInteger.ZERO))
            {
                big_total = big_total.multiply(x);
            }
        }

        String digits = big_total.toString();
        int sum = 0;
        for (char c : digits.toCharArray())
        {
            sum += Character.getNumericValue(c);
        }

        return sum;
    }   
    /**
     * This filters strings for a specified substring
     * @param al is an array list of strings.
     * @param s is a search string
     * @return an array list of strings containing all those strings
     * in the array list <code>al</code> having <code>s</code> as a substring.
     */
     public static ArrayList<String> pseudoGrep(ArrayList<String> al, String s)
     {
         // its a bit yucky but it works
         ArrayList<String> results = 
            new ArrayList<>(
                al.stream()
                  .filter(x -> x.contains(s))
                  .collect(Collectors.toList())
            );
        
         return results;
     }
    /**
    *  This finds the date n days from today.  If n is negative
    *  find the date -n days ago.
    *  @param n the number of days from today
    *  @return the date n days from today.  
    *  Sample:  10000 days from this lab prac is 29 March 2049.
    *  Today is 11 November 2021
    *  Sample:  10000 days ago is 1994-06-26
    */
    public static LocalDate daysFromNow(int n)
    {
        // doesn't matter what today is if we can get now();
        // good date classes make this easy
        return LocalDate.now().plusDays(n);
    }

    /** 
    *  Here is your testing ground.
    *  @param args command-line arguments. You won't have any.
    */
    public static void main(String[] args)
    {
        System.out.println("- Test -> sum");
        ArrayList<BigInteger> x_list = new ArrayList<>();
        x_list.add(BigInteger.ONE);
        x_list.add(BigInteger.valueOf(10));
        System.out.println(sum(x_list).equals(BigInteger.valueOf(11)));
        x_list.clear();
        System.out.println(sum(x_list).equals(BigInteger.ZERO));
        for (int i = 0; i <= 100; i++) // 0 - 100 inclusive
        {
            x_list.add(BigInteger.valueOf(i));
        }
        System.out.println(sum(x_list).equals(BigInteger.valueOf(5050)));
        
        
        System.out.println("- Test -> aerate");
        System.out.println(aerate("aardwolf", 2).equals("arwl"));
        System.out.println(aerate("bacchanalia", 3).equals("bcni"));
        System.out.println(aerate("s", 3).equals("s"));
        System.out.println(aerate("", 3).equals(""));
        System.out.println(aerate("s", 3).equals("s"));
        System.out.println(aerate("abcdefghij", 4).equals("aei"));

        System.out.println("- Test -> echoy");
        System.out.println(echoy("cowpie").equals("coowwwppppiiiiieeeeee"));
        System.out.println(echoy("abc").equals("abbccc"));
        System.out.println(echoy("123").equals("122333"));
        System.out.println(echoy("").equals(""));


        System.out.println("- Test -> finger");
        ArrayList<BigInteger> f_list = new ArrayList<>();
        f_list.add(BigInteger.valueOf(10));
        f_list.add(BigInteger.valueOf(88));
        System.out.println(finger(f_list) == 16);
        f_list.add(BigInteger.valueOf(23895));
        System.out.println(finger(f_list) == 18);
        f_list.clear();
        System.out.println(finger(f_list) == 0);
        // factorial of 20 == 2432902008176640000
        // sum of digits is 54
        for (int i = 0; i <= 20; i++)
        {
            f_list.add(BigInteger.valueOf(i));
        }
        System.out.println(finger(f_list) == 54);


        System.out.println("- Test -> pseudoGrep");
        ArrayList<String> grep_test = new ArrayList<>();
        grep_test.add("helloabc");
        grep_test.add("abc");
        grep_test.add("hello");
        grep_test.add("");
        System.out.println(pseudoGrep(grep_test, "abc").size() == 2);
        System.out.println(pseudoGrep(grep_test, "hello").size() == 2);
        System.out.println(pseudoGrep(grep_test, "").size() == 4);
        grep_test.clear();
        System.out.println(pseudoGrep(grep_test, "abc").size() == 0);


        System.out.println("- Test -> daysFromNow");
        System.out.println(daysFromNow(0).equals(LocalDate.now()));
        System.out.println(daysFromNow(10_000).equals(LocalDate.of(2049, 03, 29))); 
        System.out.println(daysFromNow(-10_000).equals(LocalDate.of(1994, 06, 26))); 
        System.out.println(daysFromNow(-1).equals(LocalDate.now().minusDays(1)));
        System.out.println(daysFromNow(-365).equals(LocalDate.now().minusDays(365)));
    }
}
