package week5;

import java.util.*;

public class Hw5_p7 {

    /*Method taken from GeeksForGeeks.com: https://www.geeksforgeeks.org/insertion-sort/ */
    /*Function to sort array using insertion sort*/
    public static void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }


    /*Mergesort methods taken from Baeldung: https://www.baeldung.com/java-merge-sort */
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    /*Quicksort methods taken from Geeks for Geeks at: https://www.geeksforgeeks.org/quick-sort/ */
    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(int[] arr, int low, int high)
    {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot)
            {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /*Heapsort methods taken from Geeks for Geeks at: https://www.geeksforgeeks.org/heap-sort/ */
    public static void heapSort(int arr[])
    {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }


    public static void main(String[] args) {

        // initializing the timers
        long startTime, endTime, elapsedTime;
        elapsedTime = 0;

        // creating a random seed to use
        Random r = new Random(System.currentTimeMillis());

        // initializing array with 100_000 slots
        int[] startArray = new int[100_000];

        // arrays to store sort times
        long[] insertTimes = new long[10];
        long[] mergeTimes = new long[10];
        long[] quickTimes = new long[10];
        long[] heapTimes = new long[10];

        // generating an array of 100,000 random integers,  1 to 1 million
        for (int i = 0; i < 100_000-1; i++) {
            startArray[i] = r.nextInt(1_000_000) + 1;
        }

        // following code blocks run 10 times, increasing the temporary array by 10,000 * (i) each loop
        // starttime is run, sort on the temparray is completed, then elapsed time is calculated
        // elapsed time is then stored in an array for each sort method for printing at the end
        // note that the sorts are done on the same exact array, which is duplicated through a temp array each time

        // insertion sort with timer array
        for (int i = 0; i < 10; i++) {
            int[] tempArray = Arrays.copyOfRange(startArray, 0, (i+1)*10_000);
            startTime = System.currentTimeMillis();
            insertionSort(tempArray);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            insertTimes[i] = elapsedTime;
        }

        // merge sort with timer array
        for (int i = 0; i < 10; i++) {
            int[] tempArray = Arrays.copyOfRange(startArray, 0, (i+1)*10_000);
            startTime = System.currentTimeMillis();
            mergeSort(tempArray, tempArray.length);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            mergeTimes[i] = elapsedTime;
        }

        // quick sort with timer array
        for (int i = 0; i < 10; i++) {
            int[] tempArray = Arrays.copyOfRange(startArray, 0, (i+1)*10_000);
            startTime = System.currentTimeMillis();
            quickSort(tempArray, 0, tempArray.length-1);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            quickTimes[i] = elapsedTime;
        }

        // heap sort with timer array
        for (int i = 0; i < 10; i++) {
            int[] tempArray = Arrays.copyOfRange(startArray, 0, (i+1)*10_000);
            startTime = System.currentTimeMillis();
            heapSort(tempArray);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            heapTimes[i] = elapsedTime;
        }

        // print results
        System.out.println("Insert sort results (in ms): " + Arrays.toString(insertTimes));
        System.out.println("Merge sort results (in ms): " + Arrays.toString(mergeTimes));
        System.out.println("Quick sort results (in ms): " + Arrays.toString(quickTimes));
        System.out.println("Heap sort results (in ms): " + Arrays.toString(heapTimes));
    }
}
/**
 Test case:

 Insert sort results (in ms): [15, 39, 76, 143, 218, 306, 415, 539, 683, 847]
 Merge sort results (in ms): [3, 3, 5, 8, 10, 13, 12, 9, 12, 15]
 Quick sort results (in ms): [2, 2, 1, 3, 4, 4, 5, 7, 7, 8]
 Heap sort results (in ms): [1, 3, 4, 4, 5, 6, 8, 8, 10, 11]

 Process finished with exit code 0


 */