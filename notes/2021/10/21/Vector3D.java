/*
 * This is a class of 3D immutable vectors with
 * integer coefficients.
 */
public class Vector3D implements IVector3D
{
    //initialize in a static block
    public static final Vector3D I = new Vector3D(1, 0, 0);
    public static final Vector3D J = new Vector3D(0, 1, 0);
    public static final Vector3D K = new Vector3D(0, 0, 1);

    public final int a;
    public final int b;
    public final int c;

    /*
     * @param a coefficient of I
     * @param b coefficient of J
     * @param c coefficient of K
     * This makes ai + bj + ck
     */
    public Vector3D(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**
     * This makes the zero vector
     */
    public Vector3D()
    {
        this(0, 0, 0);
    }

    /**
     * @param that another IVector3D
     * @return  the dot product of this vector and that.
     */
    public int dot(Vector3D that)
    {
        return a*that.a + b*that.b + c*that.c;
    }
    /**
     * @param that another IVector3D
     * @return the cross product of this vector and that.
     */
    public Vector3D cross(Vector3D that)
    {
        return new Vector3D(b*that.c - c*that.b, c*that.a-a*that.c, a*that.b-b*that.a);
    }
    /**
     * @param scalar a integer we are scalar multiplying this vector by
     * @return  the that*this
     */
    public Vector3D scalarMultiply(int scalar)
    {
        return new Vector3D(a*scalar, b*scalar, c*scalar);
    }
    /**
     * @param scalar a integer we are scalar multiplying this vector by
     * @return this + that
     */
    public Vector3D add(Vector3D that)
    {
        return new Vector3D(a+that.a, b+that.b, c+that.c);
    }
    /**
     * @param scalar a integer we are scalar multiplying this vector by
     * @return this - that
     */
    public Vector3D subtract(Vector3D that)
    {
        return new Vector3D(a-that.a, b-that.b, c-that.c);
    }
    /**
     * @return the length of this vector
     */
    public double magnitude()
    {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
    }
    /**
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
     * @return A string representation of the form ai + bj + ck.
     * Make sure you have negative terms not looking like crap.
     */
    @Override 

    public String toString()
    {
        return String.format("%di%+dj%+dk", a, b, c);
    }
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