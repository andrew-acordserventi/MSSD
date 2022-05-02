package week6;

import java.util.ArrayList;

public class Node {
    private String name;
    public ArrayList<Node> followees = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addFollower (Node addition) {
        followees.add(addition);
    }
}
