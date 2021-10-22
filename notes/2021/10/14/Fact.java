import java.math.BigInteger;

public class Fact 
{
    public static BigInteger factorial(int n)
    {
        if (n < 0)
        {
            throw new IllegalArgumentException("n must be greater than or equal to 0.");
        }
        if (n == 0 || n == 1)
        {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }

    public static int atom(int... nums) {
        int out = 0;

        for (int x : nums) {
            out += x;
        }

        return out;
    }

    public static void main(String[] args)
    {
        System.out.println(Fact.factorial(100));
        System.out.println(Fact.factorial(3));
        System.out.println(atom(1, 2, 3));
    }
}
