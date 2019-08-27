/**
 * Created by jangh on 2019-06-02.
 */
public class FlexiblePriorityQueue<K extends Comparable<K>, V extends Comparable<V>>
{
    // data fields
    private Entry<K, V>[] heap;
    private int numberOfEntries;
    private String currentState;
    private final String MIN_HEAP = "Min Heap";
    private final String MAX_HEAP = "Max Heap";

    // default constructor implementation
    @SuppressWarnings("unchecked")
    public FlexiblePriorityQueue()
    {
        heap = (Entry<K, V>[])new Entry[0];
        numberOfEntries = 0;
        currentState = MIN_HEAP;
    } // end of default constructor


    protected Entry<K,V> validate(Entry<K,V> entry){
        Entry<K,V> locator = (Entry<K,V>) entry;
        int j = locator.getIndex();
        if(j>= heap.length|| heap[j]!= locator){
            throw new IllegalArgumentException("invalid");
        }
        return locator;

    }
//    protected void swap (int i , int j){
//        Entry<K,V> temp = heap.get(i);
//        heap
//    }
    // insert (k, v): Insert the (k, v) entry which is a key(k), value(v) pair to the priority queue.
    @SuppressWarnings("unchecked")
    public void insert(K k, V v)
    {    //make a tempheap with entry and make a new array with it
        Entry<K, V>[] tempHeap = (Entry<K, V>[])new Entry[numberOfEntries + 1];

        for(int i = 0; i < numberOfEntries; i++)
        {
            tempHeap[i] = heap[i];
        }
        heap = tempHeap;

        int count = numberOfEntries;
        int parent = (int) Math.floor((count - 1) / 2);

        if(currentState.equalsIgnoreCase(MIN_HEAP))
        {//when new key k is smaller than it's parents, then swap
            while(count > 0 && k.compareTo(heap[parent].getKey()) < 0)
            {
                heap[count] = heap[parent];
                count = parent;
                parent = (int) Math.floor((count - 1) / 2);
            }
        }

        if(currentState.equalsIgnoreCase(MAX_HEAP))
        {//when new key k is bigger than it swap with parrent.
            while(count > 0 && k.compareTo(heap[parent].getKey()) > 0)
            {
                heap[count] = heap[parent];
                count = parent;
                parent = (int) Math.floor((count - 1) / 2);
            }
        }
        //insert the value at its position
        heap[count] = new Entry<K, V>(k, v, numberOfEntries);
        numberOfEntries++;
    } // end of insert method

    // remove(): removes and returns the entry (a key, value pair) with the smallest or biggest key depending on the current state of the priority queue (either Min or Max).
    public Entry<K, V> removeTop()
    {
        if(isEmpty())
            return null;

        Entry<K, V> topEntry = heap[0];
        heap[0] = heap[numberOfEntries - 1];
        numberOfEntries--;
        heapify(0);

        return topEntry;
    } // end of remove method

//remove entry object e from the priority queue and returns the entry
    //reference https://www.geeksforgeeks.org/insertion-and-deletion-in-heaps/
    //http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/9-BinTree/heap-delete.html

    // private Entry<K, V>[] heap;
    public V remove( int k )
    {
        int parent;
        V r;             // Variable to hold deleted value

        r = heap[k].getValue();             // Save return value
        heap[k] = heap[numberOfEntries - 1];// Replace deleted node with the right most leaf
        numberOfEntries--;// One less node in heap....
        parent = k/2;

      /* =======================================================
	 Filter a[k] up or down depending on the result of:
		a[k] <==> a[k's parent]
         ======================================================= */
        rebuildHeap();

//        if ( k == 1 /* k is root */ || heap[k].getKey().compareTo(heap[parent].getKey())>0 )
//            HeapFilterDown(k);  // Move the node a[k] DOWN the tree
//        else
//            HeapFilterUp(k);    // Move the node a[k] UP the tree

        return r;         // Return deleted value...
    }
    public void replaceKey(K k, K y ){

        for(int i =0; i<numberOfEntries; i++){
            if(k.compareTo(heap[i].getKey() )==0){
                heap[i].setKey(y);
            }
        }
        System.out.println("key has chagned to " + y);
//iterate to find the key and then change it and then rebuild the heap
    }
    public void replaceValue(V v, V w){
        for(int i =0; i<numberOfEntries; i++){
            if(v.compareTo(heap[i].getValue() )==0){
                heap[i].setValue(w);
            }
        }
        System.out.println("key has chagned to " + w);
    }
    // top(): returns the top entry (with the minimum or the maximum key depending on whether it is a Min- or Max-priority queue, without removing the entry.
    public Entry<K, V> top()
    {
        if(numberOfEntries == 0)
            return null;
        else
            return heap[0];
    } // end of top method

    // toggle() transforms a min- to a max-priority queue or vice versa.
    public void toggle()
    {
        if(currentState.equalsIgnoreCase(MIN_HEAP))
            currentState = MAX_HEAP;
        else
            currentState = MIN_HEAP;

        rebuildHeap();
    } // end of toggle method

    // switchToMin(): transforms a max- to a min-priority queue: else leave unchanged.
    public void switchToMin()
    {
        if(currentState.equalsIgnoreCase(MAX_HEAP))
        {
            currentState = MIN_HEAP;
            rebuildHeap();
        }
    } // end of switchToMin method

    // switchToMax(): transforms a min- to a max-priority queue; else leave unchanged.
    public void switchToMax()
    {
        if(currentState.equalsIgnoreCase(MIN_HEAP))
        {
            currentState = MAX_HEAP;
            rebuildHeap();
        }
    } // end of switchToMax method

    // stale (): returns the current state (Min or Max) of the priority queue.
    public String state()
    {
        return currentState;
    } // end of state method

    // isEmpty(): returns true if the priority queue is empty.
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    } // end of isEmpty method

    // size(): returns the current number of entries in the priority queue.
    public int size()
    {
        return numberOfEntries;
    } // end of size method

    // toString method implementation
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < numberOfEntries; i++)
        {
            sb.append(heap[i]);

            if(i < numberOfEntries - 1)
                sb.append(", ");
        }
        sb.append("]" );

        return sb.toString();
    } // end of toString method

    // rebuildHeap method implementation
    private void rebuildHeap()
    {
        for(int i = numberOfEntries / 2 - 1; i >= 0; i--)
        {
            heapify(i);
        }
    } // end of rebuildHeap method

    // heapify method implementation
    private void heapify(int index)
    {
        int current = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        //creating a max heap for the  increasing order // current will be the smallest
        if(currentState.equalsIgnoreCase(MIN_HEAP))
        {
            if(left < numberOfEntries && heap[index].getKey().compareTo(heap[left].getKey()) > 0)
            {
                current = left;
            }
            if(right < numberOfEntries && heap[current].getKey().compareTo(heap[right].getKey()) > 0)
            {
                current = right;
            }

        }
        //creating a max heap for the  increasing order// bigger number will be the current
        if(currentState.equalsIgnoreCase(MAX_HEAP))
        {
            if(left < numberOfEntries && heap[index].getKey().compareTo(heap[left].getKey()) < 0)
            {
                current = left;
            }

            if(right < numberOfEntries && heap[current].getKey().compareTo(heap[right].getKey()) < 0)
            {
                current = right;
            }
        }
        //if largest or smallest is not the loot then it swap.
        if(current != index)
        {
            Entry<K, V> tempEntry = heap[index];
            heap[index] = heap[current];
            heap[current] = tempEntry;

            heapify(current);
        }
    } // end of heapify method



} // end of FlexiblePriorityQueue class