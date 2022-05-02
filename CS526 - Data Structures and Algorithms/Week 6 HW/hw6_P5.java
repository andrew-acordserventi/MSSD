package week6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class hw6_P5 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Node> adjList = new ArrayList<>();

        // reads the file and builds the initial list of people
        readFile(adjList);

        // adds followers to our initial list of people
        addFollowees(adjList);

        // this is the name we want to check
        String check = "A";

        allFollows(check, adjList);
    }

    // prints the followers of people, direct and indirect
    private static void allFollows(String check, ArrayList<Node> adjList) {
        // iterates through the adjList to get the current node to check
        Node current = new Node("temp");
        for (int i = 0; i < adjList.size(); i++) {
            if (check.equals(adjList.get(i).getName())) {
                current = adjList.get(i);
            }
        }
        // creates an arraylist to store direct and indirect followers
        ArrayList<String> indirectFollowers = new ArrayList<>();
        ArrayList<String> directFollowers = new ArrayList<>();

        // prints out the checked nodes followers
        System.out.print(current.getName() + " directly follows ");
        for (int k = 0; k < current.followees.size(); k++) {
            System.out.print(current.followees.get(k).getName());
            directFollowers.add(current.followees.get(k).getName());
        }

        System.out.println();

        // iterates through the followerlist of the current node
        for (int k = 0; k < current.followees.size(); k++) {
            // iterates through subfollowers
            for (int j = 0; j < current.followees.get(k).followees.size(); j++) {
                // if adds subfollowers to our list
                indirectFollowers.add(current.followees.get(k).followees.get(j).getName());
            }
        }

        // iterates through direct followers; direct followers cannot be indirect followers
        for (int i = 0; i < directFollowers.size(); i++) {
            // if the indirectfollower list contains a direct follower, remove it
            if (indirectFollowers.contains(directFollowers.get(i))) {
                indirectFollowers.remove(directFollowers.get(i));
            }
        }

        // removes any duplicates in the indirect follower array
        ArrayList<String> printArray = removeDuplicates(indirectFollowers);

        // prints the indirect followers
        System.out.print(current.getName() + " indirectly follows ");
        for (int i = 0; i < printArray.size(); i++) {
            System.out.print(printArray.get(i));
        }
    }

    // builds the initial arraylist of people
    private static void readFile(ArrayList<Node> adjList) throws FileNotFoundException {
        // scanner to open the file
        Scanner inputScanner = new Scanner(new File("follows_input.txt"));

        // reads line inputs
        String lineInput;

        // while the file has stuff in it
        while (inputScanner.hasNext()) {
            // reads the line
            lineInput = inputScanner.nextLine();

            // splits the line by spaces
            String[] splitLine = lineInput.split(", ");

            Node temp = new Node(splitLine[0]);
            adjList.add(temp);
        }
        inputScanner.close();
    }

    // takes the arraylist of people, and adds their followers
    private static void addFollowees(ArrayList<Node> adjList) throws FileNotFoundException {
        // scanner to open the file
        Scanner inputScanner = new Scanner(new File("follows_input.txt"));

        // reads line inputs
        String lineInput;

        // tracks the number of times the while loop iterates (essentially iterating through our adjList)
        int counter = 0;

        // while the file has stuff in it
        while (inputScanner.hasNext()) {
            // reads the line
            lineInput = inputScanner.nextLine();

            // splits the line by commas
            String[] splitLine = lineInput.split(", ");

            // this iterates through the followers for the counter person
            for (int k = 1; k < splitLine.length; k++) {
                // this checks the follower against the adjList
                for (int j = 0; j < adjList.size(); j++) {
                    // compares the readfile line to the adjList name and if it matches...
                    if (splitLine[k].equals(adjList.get(j).getName())) {
                        // adds the follower in the readfile to our person at counter
                        adjList.get(counter).addFollower(adjList.get(j));
                    }
                }
            }

            // moves to next person on the list
            counter++;
        }
    }

    // removes duplicates in an arraylist
    // method to remove duplicates taken from
    // How to Remove Duplicates from ArrayList in Java
    // Author: Rishabh Prabhu, 11 Dec, 2018
    // https://www.geeksforgeeks.org/how-to-remove-duplicates-from-arraylist-in-java/
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list)
    {
        // Create a new ArrayList
        ArrayList<T> newList = new ArrayList<T>();

        // Traverse through the first list
        for (T element : list) {

            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {

                newList.add(element);
            }
        }
        // return the new list
        return newList;
    }
}

/*
Test cases:

D directly follows BCE
D indirectly follows FG
Process finished with exit code 0

A directly follows BC
A indirectly follows F
Process finished with exit code 0
 */