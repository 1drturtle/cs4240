import java.util.ArrayList;
import java.util.Iterator;
public class StupidSet<T> implements Iterable<T>
{
    private ArrayList<T> elements;
    /**
     * @param items is an array list of items to
     * put in our StupidSet without duplicates
     */
    public StupidSet(ArrayList<T> items)
    {
        this();
        for (T item : items) {
            if (!elements.contains(item)) {
                elements.add(item);
            }
        }
    }
    /**
     * This makes an empty StupidSet
     */
    public StupidSet()
    {
        this.elements = new ArrayList<>();
    }
    /**
     * This adds a new item to our StupidSet and returns
     * <code>false</code> if the item is already present.
     * @param newItem the new item we are adding
     * @return false if the new item is not added and
     * <code>true</code> otherwise.s
     */
    public boolean add(T newItem)
    {
        if (elements.contains(newItem)) {
            return false;
        } else {
            elements.add(newItem);
            return true;
        }
    }    
    /**
     * This checks for the presence of <code> item</code>
     * in this StupidSet.
     * @param item the new item we are checking for
     * @return false if the item is not present
     * <code>true</code> otherwise.
     */
    public boolean contains(T newItem)
    {
        return elements.contains(newItem);
    }    
    /**
     * This checks to see if <code>other</code> is
     * a subset of this StupidSet.
     * @param item a Stupidset
     * @return <code>true</code> if every element of 
     * <code>other</code> belongs to this StupidSet
     * and <code>false</code> otherwise.
     */
    public boolean containsAll(StupidSet<T> other)
    {
        for (T item : other) {
            if (!elements.contains(item))
            {
                return false;
            }
        }
        return true;
    }    
    /**
     * This removes <code>item</code> if it is present
     * @param item the item we are trying to remove
     * @return false if the item is not present
     * <code>true</code> if the item got removed.
     */
    public boolean remove(T item)
    {
        if (!elements.contains(item)) {
            return false;
        }
        elements.remove(item);
        return true;
    }    
    /**
     * This adds all items in moreStuff to this StupidSet
     * @param moreStuff a StupidSet
     * @return <code>true</code> if at least one item
     * is added
     */
    public boolean addAll(StupidSet<T> moreStuff)
    {
        boolean didAdd = false;
        for (T toAdd : moreStuff) {
            if (this.add(toAdd)) {
                didAdd = true;
            }
        }
        return didAdd;
    }
    /**
     * This makes a Python-list style representation of 
     * our StupidSet.
     * @return a representation of the form
     * <pre>[one, two, three .... last]</pre>
     */
    public String toString()
    {
        ArrayList<String> words = new ArrayList<>();
        for (T item : elements) {
            words.add(item.toString());
        }

        return words.toString();
    }

    public int size() 
    {
        return elements.size();
    }

    @Override
    public Iterator<T> iterator() 
    { 
        return elements.iterator();
    }
    
    public static void main(String[] args)
    {
        StupidSet<String> set = new StupidSet<>();
        StupidSet<String> compare = new StupidSet<>();
        compare.add("world");
        set.add("hello");
        set.add("hello");
        set.add("world");
        assert set.size() == 2;
        assert set.contains("hello") == true;
        assert set.containsAll(compare) == true;
        assert set.remove("third string") == false;
    }
}
