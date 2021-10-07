public class Point 
{
    private final int x; // final means not re-assignable
    private final int y;

    public Point(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }

    public Point() // method name overloading
    {
        this(0, 0); // Calls sibling constructor above
    }

    public double distanceTo(Point q) {
        return Math.hypot(x - q.x, y - q.y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point reflectionAcrossX()
    {
        return new Point(x, -y);
    }

    public Point reflectionAcrossY()
    {
        return new Point(-x, y);
    }

    public Point reflectionAcrossYX()
    {
        return new Point(y, x);
    }

    @Override
    public String toString() {
        return String.format("<Point x=%s, y=%s>", x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Point p = (Point) obj;
        return p.x == x && p.y == y;

    }

    public static void main(String[] args) {
        Point p = new Point(3, 4);
        Point q = new Point();
        System.out.println(p.distanceTo(q));
    }
}
