/**
 * Created by jangh on 2019-06-02.
 */
public class Entry<K extends Comparable<K>, V extends Comparable<V>>
{
    // data fields
    private K key;
    private V value;
    private int index;


    // default constructor implementation
    public Entry()
    {
        this(null, null, 0);
    }

    // parameterized constructor implementation
    public Entry(K k, V v, int j)
    {
        key = k;
        value = v;
        index = j;
    }

    // getKey method implementation
    public K getKey()
    {
        return key;
    }

    // getValue method implementation
    public V getValue()
    {
        return value;
    }

    // setKey method implementation
    public void setKey(K k)
    {
        key = k;
    }

    // setValue method implementation
    public void setValue(V v)
    {
        value = v;
    }

    public int getIndex(){
        return index;
    }
    public void setIndex(int j){
        index = j;
    }
    // toString method implementation
    public String toString()
    {
        return "(" + key + ", " + value + ")";
    }
} // end of Entry class