public class Circle implements Shape
{
    private double radius;

    public Circle(double radius)
    {
        this.radius = radius;
    }

    @Override
    public double area()
    {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double perimeter()
    {
        return 2 * Math.PI * radius;
    }

    @Override
    public double diameter()
    {
        return 2 * radius;
    }

}
