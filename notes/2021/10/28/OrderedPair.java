import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

public class OrderedPair implements Comparator<OrderedPair>
{
    private final int x;
    private final int y;

    public OrderedPair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compare(OrderedPair o1, OrderedPair o2)
    {
        if (o1.x == o2.x)
        {
            return o1.y - o2.y;
        }
        return o1.x - o2.x;
    }

    @Override
    public String toString()
    {
        return String.format("(%s, %s)", x, y);
    }

    public static void main(String[] args)
    {
        OrderedPair op = new OrderedPair(3, 3);
        var pairs = new ArrayList<OrderedPair>();

        pairs.add(new OrderedPair(1, 2));
        pairs.add(new OrderedPair(2, 1));
        pairs.add(new OrderedPair(4, 5));
        pairs.add(new OrderedPair(2, 2));
        pairs.add(new OrderedPair(-3, 200));
        pairs.add(new OrderedPair(0, 0));

        System.out.println(pairs);

        Collections.sort(pairs, op);

        System.out.println(pairs);
    }
}
