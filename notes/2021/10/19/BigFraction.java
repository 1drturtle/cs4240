import java.math.BigInteger;

/**
 * Class used to represent a fraction using two BigIntegers.
 */
public class BigFraction
{
    /**
     * BigFraction with a value of 0/1.
     */
    public final static BigFraction ZERO = new BigFraction();
    /**
     * BigFraction with a value of 1/1.
     */
    public final static BigFraction ONE = BigFraction.valueOf(1, 1);
    /**
     * BigFraction with a value of 1/2.
     */
    public final static BigFraction HALF = BigFraction.valueOf(1, 2);

    private final BigInteger num;
    private final BigInteger denum;

    /**
     * Create a BigFraction from two BigIntegers. Fractions will be simplified based on GCD.
     * @param num The numerator to use for the fraction.
     * @param denum The denominator for the fraction.
     * @throws IllegalArgumentException When a denominator of zero is provided.
     */
    public BigFraction(BigInteger num, BigInteger denum)
    {

        if (denum.compareTo(BigInteger.ZERO) == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }

        if (denum.compareTo(BigInteger.ZERO) < 0) {
            denum = denum.abs();
            num = num.multiply(BigInteger.valueOf(-1));
        }

        BigInteger divisor = denum.gcd(num);
        if (divisor.compareTo(BigInteger.ONE) != 0) {
            num = num.divide(divisor);
            denum = denum.divide(divisor);
        }

        this.num = num;
        this.denum = denum;

    }

    /**
     * Creates a BigFraction with the value of 0/1.
     */
    public BigFraction()
    {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    /**
     * Creates a BigFraction from two longs.
     * @param n The numerator for the fraction.
     * @param d The denominator for the fraction.
     * @return a BigFraction with the specified numerator/denominator.
     */
    public static BigFraction valueOf(long n, long d) {
        return new BigFraction(BigInteger.valueOf(n), BigInteger.valueOf(d));
    }
    
    /**
     * Adds two BigFractions together.
     * @param that The other BigFraction to add.
     * @return A new BigFraction containing the sum of the two BigFractions.
     */
    public BigFraction add(BigFraction that)
    {
        BigInteger top = num.multiply(that.denum).add(denum.multiply(that.num));
        BigInteger bottom = denum.multiply(that.denum);
        return new BigFraction(top, bottom);
    }

    /**
     * Subtract a BigFraction from this BigFraction.
     * @param that The BigFraction that will subtract.
     * @return A new BigFraction with (Current - that) as a value.
     */
    public BigFraction subtract(BigFraction that)
    {
        BigInteger top = num.multiply(that.denum).subtract(denum.multiply(that.num));
        BigInteger bottom = denum.multiply(that.denum);
        return new BigFraction(top, bottom);
    }

    /**
     * Multiply two BigFractions together.
     * @param that The BigFraction to multiply by.
     * @return The BigFraction with the product of that and the current fraction.
     */
    public BigFraction multiply(BigFraction that)
    {
        return new BigFraction(num.multiply(that.num), denum.multiply(that.denum));
    }

    /**
     * Divide the current BigFraction by that
     * @param that The divisor fraction.
     * @return The BigFraction with the value of (this / that).
     */
    public BigFraction divide(BigFraction that)
    {
        return new BigFraction(num.multiply(that.denum), denum.multiply(that.num));
    }

    /**
     * Check if two BigFractions equal each other in value. 
     * Will return false if obj is not a BigFraction.
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj == this)
        {
            return true;
        }
        if (!(obj instanceof BigFraction)) {
            return false;
        }
        BigFraction other = (BigFraction) obj;
        return (this.num.equals(other.num) && this.denum.equals(other.denum));

    }

    /**
     * Returns the BigFraction in forms of <code>numerator/denominator</code>.
     */
    @Override
    public String toString()
    {
        return String.format("%s/%s", this.num, this.denum);
    }

    // public static void main(String[] args)
    // {
    //     System.out.println("Fraction");
    //     BigFraction boo = BigFraction.valueOf(3, 4);
    //     System.out.println(boo);

    //     System.out.println("Negative Denominator");
    //     boo = BigFraction.valueOf(3, -4);
    //     System.out.println(boo);

    //     System.out.println("Simplification from 1000/2000");
    //     boo = BigFraction.valueOf(1000, 2000);
    //     System.out.println(boo);

    //     System.out.println("Addition");
    //     BigFraction x = new BigFraction();
    //     BigFraction y = BigFraction.valueOf(3, 2);
    //     System.out.printf("%s + %s = %s\n", x, y, x.add(y));
        
    //     System.out.println("Multiplication");
    //     x = BigFraction.valueOf(3, 4);
    //     y = BigFraction.valueOf(1, 2);
    //     System.out.printf("%s * %s = %s\n", x, y, x.multiply(y));
        
    //     System.out.println("Division");
    //     y = BigFraction.valueOf(2, 1);
    //     System.out.printf("%s / %s = %s", x, y, x.divide(y));
    // }
}