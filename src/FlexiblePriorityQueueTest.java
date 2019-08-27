/**
 * Created by jangh on 2019-06-02.
 */
//reference https://www.geeksforgeeks.org/heap-sort/
// O(Logn)
// FlexiblePriorityQueueTest class implementation
public class FlexiblePriorityQueueTest
{
    // start main method
    public static void main(String[] args)
    {
        FlexiblePriorityQueue<Integer, String> fpq = new FlexiblePriorityQueue<Integer, String>();
        fpq.insert(7,"7");
        fpq.insert(4,"4");
        fpq.insert(1,"1");
        fpq.insert(2,"2");
        fpq.insert(3,"3");

        fpq.insert(5,"5");
        fpq.insert(6,"6");

        fpq.insert(8,"8");
//        fpq.insert("a", 1);
//        fpq.insert("d", 2);
//        fpq.insert("b", 3);
//        fpq.insert("c", 4);
//        fpq.insert("e", 5);
//        fpq.insert("f", 6);
//        fpq.insert("h", 7);
//        fpq.insert("g", 8);
//        fpq.insert("versa", 9);
//
     //   fpq.toggle();
        System.out.println("Current State: " + fpq.state());

        System.out.println("Entries: " + fpq);
      //  System.out.println("REMOVE: " +fpq.remove3(1));


    //    fpq.toggle();
        System.out.println("Current State: " + fpq.state());

        System.out.println("Entries: " + fpq);
        fpq.toggle();
        System.out.println("Current State: " + fpq.state());

        System.out.println("Entries: " + fpq);

        fpq.toggle();
        System.out.println("Current State: " + fpq.state());

        System.out.println("Entries: " + fpq);



        System.out.println("\nRemoved top element: " + fpq.remove(3));
        System.out.println("Entries: " + fpq);

        System.out.println("\nToggling the state...");
        fpq.toggle();

        System.out.println("\nCurrent State: " + fpq.state());
        System.out.println("Entries: " + fpq);

        System.out.println("\n top element: " + fpq.top());
        System.out.println("Entries: " + fpq);
    } // end of main method
} // end of FlexiblePriorityQueueTest class