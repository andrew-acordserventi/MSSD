package project;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ProcessScheduling {
    // creating global variables to track the system
    static int currentTime = 0;
    static double totalWait = 0;
    static boolean isRunning = false;
    static int maxWait = 30;
    // this is the current running process; created global to share between methods easier with no errors
    static CustomProcess runningProcess;

    /**
     * Simulation to run processes stored in a text file, through a timer, based on their priority.
     * CustomProcess objects are created from a text file, stored in a Linked List, moved to a Priority Queue,
     * and run based on the highest priority and the system time vs the CustomProcesses' wait time.
     * Driver Code
     */
    public static void main(String[] args) throws IOException {

        // processLinkedList to initially store the custom process objects
        LinkedList<CustomProcess> customProcessLinkedList = new LinkedList<>();

        // need to write to a text file
        FileWriter fileWriter = new FileWriter("process_scheduling_output.txt");
        PrintWriter writer = new PrintWriter(fileWriter);

        // reads from the file and stores the process objects in a linkedlist
        getProcessList(customProcessLinkedList, writer);
        int numProcesses = customProcessLinkedList.size();

        // prints out the linked list of process objects
        printProcessList(customProcessLinkedList, writer);

        System.out.println("\nMax wait time = " + maxWait + "\n");
        writer.write("\nMax wait time = " + maxWait + "\n\n");

        // creates a new priority queue to store processes so they can run in order
        PriorityQueue<CustomProcess> queue = new PriorityQueue<>(10, new ProcessComparator());

        // empties the linkedlist into the queue
        emptyLinkedList(customProcessLinkedList, queue, writer);
        // linkedlist should be empty by now - need to run remaining CustomProcess objects in the queue

        // starts running remainder of processes in the priority queue and updates the timers
        runProcess(queue, writer);

        // prints results
        System.out.println("\nTotal wait time: " + totalWait);
        writer.append("\nTotal wait time: " + totalWait + "\n");
        double avgWait = totalWait/numProcesses;
        System.out.println("\nAverage wait time: " + avgWait);
        writer.append("\nAverage wait time: " + avgWait + "\n");
        writer.close();
    }

    /**
     * Takes an empty linked list with CustomProject objects and emptys it into the passed queue.
     * Also runs the processes in a time simulation. Ends when the linked list is empty.
     * Does not finish running the processes (need to invoke runProcess method to finish running processes).
     * @param customProcessLinkedList - linked list filled with CustomProcess objects
     * @param queue - Priority Queue to hold CustomProcess objects until they run
     * @param writer
     */
    private static void emptyLinkedList(LinkedList<CustomProcess> customProcessLinkedList,
                                        PriorityQueue<CustomProcess> queue, PrintWriter writer) throws IOException {
        CustomProcess holdingProcess = new CustomProcess();

        // while there are still items in the linkedlist
        while (customProcessLinkedList.size() > 0) {

            // gets the next process from the linkedlist (note, arrival time is ordered by PID)
            int first = customProcessLinkedList.getFirst().getArrivalTime();
            int earlyIndex = 0;

            // double checks to ensure we have the earliest arrival time process
            for (int i = 0; i < customProcessLinkedList.size(); i++) {
                int tempTime = customProcessLinkedList.get(i).getArrivalTime();
                if (tempTime < first) {
                    first = tempTime;
                    earlyIndex = i;
                }
            }
            holdingProcess = customProcessLinkedList.get(earlyIndex);

            // adds the process to run to the que and removes it from the linked list
            if (holdingProcess.getArrivalTime() <= currentTime) {
                queue.add(holdingProcess);
                customProcessLinkedList.remove(earlyIndex);
            }

            // starts running a process, removing it from queue, and updates the timers
            if (queue.isEmpty() != true && isRunning == false) {
                runningProcess = queue.poll();
                totalWait += currentTime - runningProcess.getArrivalTime();
                runningProcess.setEndRuntime(currentTime + runningProcess.getDuration());
                System.out.println("Process removed from queue is: id = " + runningProcess.getId() + ", at time " +
                        currentTime + ", wait time = " + runningProcess.getWaitTime() +
                        " Total wait time = " + totalWait + "\n");
                writer.append("\nProcess removed from queue is: id = " + runningProcess.getId() + ", at time " +
                        currentTime + ", wait time = " + runningProcess.getWaitTime() +
                        " Total wait time = " + totalWait + "\n");
                System.out.println("Process id = " + runningProcess.getId() + "\nPriority = " +
                        runningProcess.getPriority() + "\nArrival = " + runningProcess.getArrivalTime() +
                        "\nDuration = " + runningProcess.getDuration() + "\n");
                writer.append("\nProcess id = " + runningProcess.getId() + "\nPriority = " +
                        runningProcess.getPriority() + "\nArrival = " + runningProcess.getArrivalTime() +
                        "\nDuration = " + runningProcess.getDuration() + "\n");
                isRunning = true;
            }

            // advances time by 1 *important step!*
            currentTime++;

            // if the process is done after updating the time, finish it and let user know
            // also update wait times and priorities
            if (isRunning == true && runningProcess.getEndRuntime() == currentTime) {
                System.out.println("Process " + runningProcess.getId() +
                        " finished at time " + runningProcess.getEndRuntime() + "\n");
                writer.append("\nProcess " + runningProcess.getId() +
                        " finished at time " + runningProcess.getEndRuntime() + "\n");
                isRunning = false;

                // iterates through the queue to update wait times
                System.out.println("Update Priority: ");
                writer.append("\nUpdate Priority: \n");
                if (queue.isEmpty() != true) {
                    // while the iterator still has objects, update their wait times.
                    Iterator<CustomProcess> updateWait = queue.iterator();
                    // while the iterator still has objects, update their wait times.
                    while (updateWait.hasNext() == true) {

                        // need to create temp CustomProcess or errors occur
                        CustomProcess temp = updateWait.next();
                        int timeWaited = currentTime - temp.getArrivalTime();
                        temp.setWaitTime(timeWaited);
                    }
                }
                System.out.println();
            }
        }
        // while loop concludes, linkedlist is empty, method returns to main
        System.out.println("Linked list becomes empty at time " + currentTime + "\n");
        writer.append("\nLinked list becomes empty at time " + currentTime + "\n");
    }

    /**
     * Very similar to emptyLinkedList method. Runs CustomProcess until Priority Queue is emptied.
     * When processes are finished running, tells user the total amount of time the simulation took.
     * @param queue - A priority queue filled with CustomProcess objects that need to be run
     * @param writer
     */
    private static void runProcess(PriorityQueue<CustomProcess> queue, PrintWriter writer) throws IOException {
        // starts running a process, removing it from queue, and updates the timers
        while (queue.isEmpty() == false || isRunning == true) {
            // starts running a process, removing it from queue, and updates the timers
            if (queue.isEmpty() != true && isRunning == false) {
                runningProcess = queue.poll();
                totalWait += currentTime - runningProcess.getArrivalTime();
                runningProcess.setEndRuntime(currentTime + runningProcess.getDuration());
                System.out.println("Process removed from queue is: id = " + runningProcess.getId() +
                        ", at time " + currentTime + ", wait time = " + runningProcess.getWaitTime() +
                        " Total wait time = " + totalWait + "\n");
                writer.append("\nProcess removed from queue is: id = " + runningProcess.getId() +
                        ", at time " + currentTime + ", wait time = " + runningProcess.getWaitTime() +
                        " Total wait time = " + totalWait + "\n");
                System.out.println("Process id = " + runningProcess.getId() + "\nPriority = " +
                        "" + runningProcess.getPriority() + "\nArrival = " +
                        runningProcess.getArrivalTime() + "\nDuration = " + runningProcess.getDuration() + "\n");
                writer.append("\nProcess id = " + runningProcess.getId() + "\nPriority = " +
                        "" + runningProcess.getPriority() + "\nArrival = " +
                        runningProcess.getArrivalTime() + "\nDuration = " + runningProcess.getDuration() + "\n");
                isRunning = true;
            }

            // advances time by 1 *important step!*
            currentTime++;

            // if the process is done after updating the time, finish it and let user know
            // also update wait times and priorities
            if (isRunning == true && runningProcess.getEndRuntime() == currentTime) {
                System.out.println("Process " + runningProcess.getId() +
                        " finished at time " + runningProcess.getEndRuntime() + "\n");
                writer.append("\nProcess " + runningProcess.getId() +
                        " finished at time " + runningProcess.getEndRuntime() + "\n");
                isRunning = false;

                // iterates through the queue to update wait times
                if (queue.isEmpty() != true) {
                    System.out.println("Update Priority: ");
                    writer.append("\nUpdate Priority: \n");
                    // iterator to traverse the queue created
                    Iterator<CustomProcess> updateWait = queue.iterator();
                    // while the iterator still has objects, update their wait times.
                    while (updateWait.hasNext() == true) {
                        CustomProcess temp = updateWait.next();
                        int timeWaited = currentTime - temp.getArrivalTime();
                        temp.setWaitTime(timeWaited);
                    }
                }
                System.out.println();
            }
        }
        System.out.println("System finished running processes at time = " + currentTime);
        writer.append("\nSystem finished running processes at time = " + currentTime + "\n");
    }

    /**
     * Prints a list of all CustomProcesses contained in a linked list
     * @param fileList - Linked List that contains CustomProcess objects
     * @param writer
     */
    private static void printProcessList(LinkedList<CustomProcess> fileList, PrintWriter writer) throws IOException {
        // prints the linkedlist of process objects
        for (int i = 0; i < fileList.size(); i++) {
            System.out.println("Id: " + fileList.get(i).getId() + "\t\t" +
                                "Priority: " + fileList.get(i).getPriority() + "\t\t" +
                                "Duration: " + fileList.get(i).getDuration() + "\t\t" +
                                "Arrival Time: " + fileList.get(i).getArrivalTime());
            writer.append("Id: " + fileList.get(i).getId() + "\t\t" +
                    "Priority: " + fileList.get(i).getPriority() + "\t\t" +
                    "Duration: " + fileList.get(i).getDuration() + "\t\t" +
                    "Arrival Time: " + fileList.get(i).getArrivalTime() + "\n");
        }
    }

    /**
     * Builds an initial list of CustomProcess objects from a text file, stores them in a Linked List.
     * @param fileList - linked list to store the CustomProcesses
     * @return - returns the linked list filled with CustomProcesses
     * @throws FileNotFoundException - necessary to read from a file
     */
    private static LinkedList<CustomProcess> getProcessList(LinkedList<CustomProcess> fileList, PrintWriter writer)
            throws FileNotFoundException {
        // scanner to open the file
        Scanner inputScanner = new Scanner (new File("process_scheduling_input.txt"));

        // reads line inputs
        String lineInput;

        // initialize variables to use to setup process objects
        int setId;
        int setPriority;
        int setDuration;
        int setArrivalTime;
        int setMaxWait = maxWait;

        // while the file has stuff in it
        while (inputScanner.hasNext()) {
            // reads the line
            lineInput = inputScanner.nextLine();

            // splits the line by spaces
            String[] splitLine = lineInput.split(" ");

            // sets the variables to use by what is read in the file
            setId = Integer.parseInt(splitLine[0]);
            setPriority = Integer.parseInt(splitLine[1]);
            setDuration = Integer.parseInt(splitLine[2]);
            setArrivalTime = Integer.parseInt(splitLine[3]);

            // creates a new process using the above variables
            CustomProcess customProcess = new CustomProcess(
                    setId,
                    setPriority,
                    setDuration,
                    setArrivalTime,
                    setMaxWait,
                    writer);

            // adds the processes created to the linkedlist
            fileList.add(customProcess);
        }
        inputScanner.close();
        return fileList;
    }
}

/* Test case:

Id: 1		Priority: 4		Duration: 25		Arrival Time: 10
Id: 2		Priority: 3		Duration: 15		Arrival Time: 17
Id: 3		Priority: 1		Duration: 17		Arrival Time: 26
Id: 4		Priority: 9		Duration: 17		Arrival Time: 30
Id: 5		Priority: 10		Duration: 9		Arrival Time: 40
Id: 6		Priority: 6		Duration: 14		Arrival Time: 47
Id: 7		Priority: 7		Duration: 18		Arrival Time: 52
Id: 8		Priority: 5		Duration: 18		Arrival Time: 70
Id: 9		Priority: 2		Duration: 16		Arrival Time: 93
Id: 10		Priority: 8		Duration: 20		Arrival Time: 125

Max wait time = 30

Process removed from queue is: id = 1, at time 10, wait time = 0 Total wait time = 0.0

Process id = 1
Priority = 4
Arrival = 10
Duration = 25

Process 1 finished at time 35

Update Priority:

Process removed from queue is: id = 3, at time 35, wait time = 9 Total wait time = 9.0

Process id = 3
Priority = 1
Arrival = 26
Duration = 17

Process 3 finished at time 52

Update Priority:
PID = 2, wait time = 35, current priority = 3
PID = 2, new priority = 2

Process removed from queue is: id = 2, at time 52, wait time = 35 Total wait time = 44.0

Process id = 2
Priority = 2
Arrival = 17
Duration = 15

Process 2 finished at time 67

Update Priority:
PID = 4, wait time = 37, current priority = 9
PID = 4, new priority = 8

Process removed from queue is: id = 6, at time 67, wait time = 20 Total wait time = 64.0

Process id = 6
Priority = 6
Arrival = 47
Duration = 14

Process 6 finished at time 81

Update Priority:
PID = 5, wait time = 41, current priority = 10
PID = 5, new priority = 9
PID = 4, wait time = 51, current priority = 8
PID = 4, new priority = 7

Process removed from queue is: id = 8, at time 81, wait time = 11 Total wait time = 75.0

Process id = 8
Priority = 5
Arrival = 70
Duration = 18

Process 8 finished at time 99

Update Priority:
PID = 4, wait time = 69, current priority = 7
PID = 4, new priority = 6
PID = 5, wait time = 59, current priority = 9
PID = 5, new priority = 8
PID = 7, wait time = 47, current priority = 7
PID = 7, new priority = 6

Process removed from queue is: id = 9, at time 99, wait time = 6 Total wait time = 81.0

Process id = 9
Priority = 2
Arrival = 93
Duration = 16

Process 9 finished at time 115

Update Priority:
PID = 7, wait time = 63, current priority = 6
PID = 7, new priority = 5
PID = 4, wait time = 85, current priority = 6
PID = 4, new priority = 5
PID = 5, wait time = 75, current priority = 8
PID = 5, new priority = 7

Process removed from queue is: id = 7, at time 115, wait time = 63 Total wait time = 144.0

Process id = 7
Priority = 5
Arrival = 52
Duration = 18

Linked list becomes empty at time 126
Process 7 finished at time 133

Update Priority:
PID = 4, wait time = 103, current priority = 5
PID = 4, new priority = 4
PID = 5, wait time = 93, current priority = 7
PID = 5, new priority = 6

Process removed from queue is: id = 4, at time 133, wait time = 103 Total wait time = 247.0

Process id = 4
Priority = 4
Arrival = 30
Duration = 17

Process 4 finished at time 150

Update Priority:
PID = 5, wait time = 110, current priority = 6
PID = 5, new priority = 5

Process removed from queue is: id = 5, at time 150, wait time = 110 Total wait time = 357.0

Process id = 5
Priority = 5
Arrival = 40
Duration = 9

Process 5 finished at time 159

Update Priority:
PID = 10, wait time = 34, current priority = 8
PID = 10, new priority = 7

Process removed from queue is: id = 10, at time 159, wait time = 34 Total wait time = 391.0

Process id = 10
Priority = 7
Arrival = 125
Duration = 20

Process 10 finished at time 179


System finished running processes at time = 179

Total wait time: 391.0
Average wait time: 39.1

Process finished with exit code 0

 */