import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

public class OrderedPair implements Comparable<OrderedPair>
{
    private final int x;
    private final int y;

    public OrderedPair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(OrderedPair o) {
        if (x == o.x)
        {
            return y - o.y;
        }
        return x - o.x;
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
        
        pairs.add(new OrderedPair(2, 1));
        pairs.add(new OrderedPair(1, 2));
        pairs.add(new OrderedPair(4, 5));
        pairs.add(new OrderedPair(2, 2));
        pairs.add(new OrderedPair(-3, 200));
        pairs.add(new OrderedPair(0, 0));

        Comparator<OrderedPair> bySum = (a, b) -> {
            int sortValue = (a.x + a.y) - (b.x + b.y);
            if (sortValue == 0) {
                return a.x - b.x;
            }
            return sortValue;
        };

        System.out.println(pairs);

        System.out.println("Sorting ->");
        Collections.sort(pairs);

        System.out.println(pairs);

        System.out.println("Sorting (by sum) ->");
        Collections.sort(pairs, bySum);
        
        System.out.println(pairs);

    }


}
