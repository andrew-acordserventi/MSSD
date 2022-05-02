package week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Hw4_p6 {
    public static void main(String[] args) {

        // initializing the timers
        long startTime, endTime, elapsedTime1, elapsedTime2, elapsedTime3;
        elapsedTime1 = 0;
        elapsedTime2 = 0;
        elapsedTime3 = 0;
        long elapsedTime4 = 0;
        long elapsedTime5 = 0;
        long elapsedTime6 = 0;

        // sout before the loop to acknowledge start
        System.out.println("Number of keys = 100000");

        // set the number of loops to run through
        int numLoops = 10;

        // loop 10 times
        for (int i = 0; i < numLoops; i++) {

            // zeroes and creates a new array
            int[] insertKeys = new int[100_000];

            // generates random numbers and stores them in each slot in insertKeys array
            Random r = new Random(System.currentTimeMillis());
            for (int k = 0; k < 100000; k++) {
                insertKeys[k] = r.nextInt(1_000_000) + 1;
            }

            // clearing/initializing the objects
            HashMap<Integer, Integer> myMap = new HashMap<>();
            ArrayList<Integer> myArrayList = new ArrayList<>();
            LinkedList<Integer> myLinkedList = new LinkedList<>();

            // hashmap insertion
            startTime = System.currentTimeMillis();
            for (int k = 0; k < 100000; k++) {
                myMap.put(insertKeys[k], k);
            }
            endTime = System.currentTimeMillis();
            elapsedTime1 += endTime - startTime;

            // arraylist insertion
            startTime = System.currentTimeMillis();
            for (int k = 0; k < 100000; k++) {
                myArrayList.add(insertKeys[k]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime2 += endTime - startTime;

            // linkedlist insertion
            startTime = System.currentTimeMillis();
            for (int k = 0; k < 100000; k++) {
                myLinkedList.add(insertKeys[k]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime3 += endTime - startTime;

            // creates and zeroes the searchkeys array
            int[] searchKeys = new int[100_000];

            // generates random numbers and stores them in each slot in searchKeys array
            Random r2 = new Random(System.currentTimeMillis());
            for (int k = 0; k < 100_000; k++) {
                searchKeys[k] = r2.nextInt(2_000_000) + 1;
            }

            // searching hashmap
            startTime = System.currentTimeMillis();
            for (int k = 0; k < 100_000; k++) {
                myMap.containsKey(searchKeys[k]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime4 += endTime - startTime;

            // searching arraylist
            startTime = System.currentTimeMillis();
            for (int k = 0; k < 100_000; k++) {
                myArrayList.contains(searchKeys[k]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime5 += endTime - startTime;

            // searching linkedlist
            startTime = System.currentTimeMillis();
            for (int k = 0; k < 100_000; k++) {
                myLinkedList.contains(searchKeys[k]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime6 += endTime - startTime;

            // printing status at end of each loop to ensure the loop is continuing
            System.out.println("Loop " + (i+1) + " finished.");
        }

        // prints the final result; note we can divide by the numLoops in order to get the average since it loops
        // multiple times
        System.out.println();
        System.out.println("Hashmap average total insert time = " + (elapsedTime1/numLoops));
        System.out.println("ArrayList average total insert time = " + (elapsedTime2/numLoops));
        System.out.println("LinkedList average total insert time = " + (elapsedTime3/numLoops));
        System.out.println();
        System.out.println("Hashmap average total search time = " + (elapsedTime4/numLoops));
        System.out.println("ArrayList average total search time = " + (elapsedTime5/numLoops));
        System.out.println("LinkedList average total search time = " + (elapsedTime6/numLoops));

    }
}
/** Observations:
 * Using the insertion function has little variability on the runtime of each data structure type.
 * However, the search time of each varies greatly.
 * Hashmap was the slowest to insert (although barely), but was WAY faster to search.
 * Arraylist was the fastest to insert, but was much slower to search.
 * Linkedlist was the middle to insert, but was by far the slowest to search.
 * In terms of searchability, hashmap was the superior choice. Insertion time, overall, did not matter
 * since each data structure was fairly quick to insert 100,000 integers.
 * However, if the data structure is never going to be needed to be searched (unlikely to predict future
 * requirements), then arraylist or linkedlist would be the superior choice due to faster insertion times.
 * Hashmap does take longer to insert, likely owing to its key/value pairings that need to be created.
 * Personally, I would prefer to use hashmap just because inserting new items was relatively quick,
 * and the performance gains searching through the data structure were monumental compared to
 * linkedlists and arraylists.
 */


/**
 Test case:

 Number of keys = 100000

 Loop 1 finished.
 Loop 2 finished.
 Loop 3 finished.
 Loop 4 finished.
 Loop 5 finished.
 Loop 6 finished.
 Loop 7 finished.
 Loop 8 finished.
 Loop 9 finished.
 Loop 10 finished.

 Hashmap average total insert time = 7
 ArrayList average total insert time = 1
 LinkedList average total insert time = 2

 Hashmap average total search time = 3
 ArrayList average total search time = 7212
 LinkedList average total search time = 18297

 Process finished with exit code 0

 */