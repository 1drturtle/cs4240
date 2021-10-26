public class Rectangle implements Shape
{
    private double height;
    private double width;

    public Rectangle(double height, double width) 
    {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area()
    {
        return width * height;
    }

    @Override
    public double perimeter()
    {
        return width * 2 + height * 2;
    }

    @Override
    public double diameter()
    {
        return Math.hypot(width, height);
    }

    public int numSides()
    {
        return 4;
    }

}
