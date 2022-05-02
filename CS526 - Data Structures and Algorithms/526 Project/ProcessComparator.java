package project;

import java.util.Comparator;

public class ProcessComparator implements Comparator<CustomProcess> {
    // implementation from https://www.geeksforgeeks.org/implement-priorityqueue-comparator-java/

    /**
     * Allows implementation of a priority queue. Compares two CustomProcess and returns the comparison
     * allowing for movement in the priority queue based on their priority.
     * @param o1 - CustomProcess 1 priority to look at
     * @param o2 - CustomProcess 2 priority to look at
     * @return - Returns 1 if CustomProcess 1's priority is higher; -1 if lower; 0 if equal
     */
    public int compare(CustomProcess o1, CustomProcess o2) {
        if (o1.getPriority() > o2.getPriority()) {
            return 1;
        }
        if (o1.getPriority() < o2.getPriority()) {
            return -1;
        }
        return 0;
    }
}
