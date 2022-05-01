package MST;

import java.util.LinkedList;

public class Vertex implements Comparable<Vertex> {
    private LinkedList<AdjNode> adjacentList;
    private int id;
    private int piId;
    private double key;

    public Vertex(int id) {
        this.adjacentList = new LinkedList<AdjNode>();
        this.id = id;
    }

    public Vertex() {
        this.adjacentList = new LinkedList<AdjNode>();
        this.id = -1;
    }

    public void addAdjacentNode(AdjNode AdjNode) {
        this.adjacentList.add(AdjNode);
    }

    public LinkedList<AdjNode> getAdjacentList() {
        return this.adjacentList;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getKey() {
        return this.key;
    }

    public void setKey(double key) {
        this.key = key;
    }

    public int getPiId() {
        return this.piId;
    }

    public void setPiId(int piId) {
        this.piId = piId;
    }

    public int compareTo(Vertex other) {
        if (this.getKey() == other.getKey()) {
            return 0;
        } else if (this.getKey() > other.getKey()) {
            return 1;
        } else {
            return -1;
        }
    }
}
