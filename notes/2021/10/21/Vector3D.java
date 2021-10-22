/**
 * This is a class of 3D immutable vectors with
 * integer coefficients.
 */
public class Vector3D implements IVector3D
{
    //initialize in a static block
    /**
     * A {@link Vector3D} with a value of (1, 0, 0).
     */
    public static final Vector3D I = new Vector3D(1, 0, 0);
    /**
     * A {@link Vector3D} with a value of (0, 1, 0).
     */
    public static final Vector3D J = new Vector3D(0, 1, 0);
    /**
     * A {@link Vector3D} with a value of (0, 0, 1).
     */
    public static final Vector3D K = new Vector3D(0, 0, 1);

    /**
     * The a coefficient of I.
     */
    public final int a;
    /**
     * The b coefficient of J.
     */
    public final int b;
    /**
     * The c coefficient of K.
     */
    public final int c;

    /**
     * Returns a {@link Vector3D} with the specified coefficients.
     * @param a coefficient of I
     * @param b coefficient of J
     * @param c coefficient of K
     */
    public Vector3D(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    /**
     * Returns a {@link Vector3D} with a value of (0, 0, 0)
     */
    public Vector3D()
    {
        this(0, 0, 0);
    }

    /**
     * Returns the dot product of this and that.
     * @param that The {@link Vector3D} to multiply with.
     * @return {@link Vector3D} with the dot product of this and that.
     */
    public int dot(Vector3D that)
    {
        return a*that.a + b*that.b + c*that.c;
    }
    
    /**
     * The cross-product of the two {@link Vector3D}.
     * @param that The {@link Vector3D} to use.
     * @return the {@link Vector3D} containing the cross product of this and that.
     */
    public Vector3D cross(Vector3D that)
    {
        return new Vector3D(b*that.c - c*that.b, c*that.a-a*that.c, a*that.b-b*that.a);
    }

    /**
     * The current Vector3D multiplied by a scalar.
     * @param scalar a integer we are scalar multiplying this vector by
     * @return The Vector3D containing this multiplied by scalar.
     */
    public Vector3D scalarMultiply(int scalar)
    {
        return new Vector3D(a*scalar, b*scalar, c*scalar);
    }
    /**
     * The sum of this vector and that.
     * @param that The {@link Vector3D} to add.
     * @return this + that
     */
    public Vector3D add(Vector3D that)
    {
        return new Vector3D(a+that.a, b+that.b, c+that.c);
    }
    /**
     * Subtracts that vector from this.
     * @param that The {@link Vector3D} to subtract.
     * @return this - that
     */
    public Vector3D subtract(Vector3D that)
    {
        return new Vector3D(a-that.a, b-that.b, c-that.c);
    }
    /**
     * The magnitude of the vector from all three axises.
     * @return the length of this vector
     */
    public double magnitude()
    {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
    }
    /**
     * The angle between this vector and that.
     * @param that another vector
     * @return the angle between this and that in radians in [0,π]
     */
    public double angleBetween(Vector3D that)
    {
        // dot product over product of magnitudes
        double dotp = this.dot(that);
        double mags = this.magnitude() * that.magnitude();
        // arc-cos of result to get radians
        double deg = Math.acos(dotp/mags);
        return deg;
    }
    /**
     * String value of the Vector.
     * @return A string representation of the form ai + bj + ck.
     */
    @Override 
    public String toString()
    {
        return String.format("%di%+dj%+dk", a, b, c);
    }

    /**
     * Checks if two {@link Vector3D} equal each other by comparing their A, B, and C.
     */
    @Override 
    public boolean equals(Object o)
    {
        if (o == this) {
            return true;
        } else if (!(o instanceof Vector3D)) {
            return false;
        }
        Vector3D other = (Vector3D) o;
        return other.a == a && other.b == b && other.c == c;
    }

    // Main Function.
    public static void main(String[] args) {
        Vector3D x = new Vector3D(1, 0, 0);
        Vector3D y = new Vector3D(0, 1, 0);
        System.out.printf("%s dot product %s = %d\n", x, y, x.dot(y));
        System.out.printf("%s cross %s = %s\n", x, y, x.cross(y));
        System.out.printf("%s * 2 = %s\n", x, x.scalarMultiply(2));
        System.out.printf("%s + %s = %s\n", x, y, x.add(y));
        System.out.printf("%s - %s = %s\n", x, y, x.subtract(y));
        System.out.printf("%s magnitude = %s\n", x, x.magnitude());
        System.out.printf("angle between %s and %s = %s (90 deg = 1.58 radians)\n", x, y, x.angleBetween(y));
        System.out.printf("%s != %s = %s\n", x, y, !x.equals(y));
    }
}