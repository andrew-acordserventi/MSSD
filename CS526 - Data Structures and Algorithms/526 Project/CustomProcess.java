package project;

import java.io.PrintWriter;
import java.util.Comparator;

public class CustomProcess implements Comparator<CustomProcess> {
    // global variables for our objects
    final private int id;
    final private int arrivalTime;
    private int priority;
    private int duration;
    private int waitTime = 0;
    // gets the maximum wait time, as set in ProcessScheduling app (default 30)
    private int maxWaitTime;
    private int endRunTime = 0;
    private PrintWriter writer;

    // constructor
    public CustomProcess(int id, int priority, int duration, int arrivalTime, int maxWaitTime, PrintWriter writer) {
        this.id = id;
        this.priority = priority;
        this.duration = duration;
        this.arrivalTime = arrivalTime;
        this.maxWaitTime = maxWaitTime;
        this.writer = writer;
    }
    // overloaded empty constructor
    public CustomProcess() {
        this.id = 0;
        this.priority = 0;
        this.duration = 0;
        this.arrivalTime = 0;
    }

    /**
     * Invoked when setWaitTime is invoked and the wait time increases. If the wait time is larger than max,
     * lower the priority (minimum of 1) and inform user
     */
    public void increasePriority() {
        if (this.priority > 1 && this.waitTime >= maxWaitTime){
            System.out.println("PID = " + this.getId() +
                    ", wait time = " + this.getWaitTime() +
                    ", current priority = " + this.getPriority());
            writer.append("PID = " + this.getId() +
                    ", wait time = " + this.getWaitTime() +
                    ", current priority = " + this.getPriority() + "\n");
            this.priority = this.priority - 1;
            System.out.println("PID = " + this.getId() + ", new priority = " + this.getPriority());
            writer.append("PID = " + this.getId() + ", new priority = " + this.getPriority() + "\n");
        }
    }

    // basic getters to access basic items that are generated from the text file
    public int getPriority() {
        return this.priority;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getId() {
        return this.id;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    /**
     * Sets the wait time for a CustomProcess. Checks if the priority needs to be increased
     * @param setWait - an integer of the wait time to set this object to
     */
    public void setWaitTime(int setWait) {
        this.waitTime = setWait;
        this.increasePriority();
    }

    public int getWaitTime() {
        return this.waitTime;
    }

    public void setEndRuntime(int endRuntime) {
        this.endRunTime = endRuntime;
    }

    public int getEndRuntime () {
        return this.endRunTime;
    }

    /**
     * Allows implementation of a priority queue. Compares two CustomProcess and returns the comparison
     * allowing for movement in the priority queue based on their priority.
     * @param o1 - CustomProcess 1 priority to look at
     * @param o2 - CustomProcess 2 priority to look at
     * @return - Returns 1 if CustomProcess 1's priority is higher; -1 if lower; 0 if equal
     */
    @Override
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
