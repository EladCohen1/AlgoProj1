package MST;

import java.util.LinkedList;

public class Vertex implements Comparable<Vertex> {
    private LinkedList<AdjNode> adjacentList;
    private int id;
    private int piId;
    private double key;
    private String BFSColor;
    private int BFSPiId;
    private double BFSPiEdgeWeight;

    public Vertex(int id) {
        this.adjacentList = new LinkedList<AdjNode>();
        this.id = id;
        this.piId = -1;
        this.key = -1;
        this.BFSColor = "white";
        this.BFSPiId = -1;
        this.BFSPiEdgeWeight = -1;
    }

    public Vertex() {
        this.adjacentList = new LinkedList<AdjNode>();
        this.id = -1;
        this.piId = -1;
        this.key = -1;
        this.BFSColor = "white";
        this.BFSPiId = -1;
        this.BFSPiEdgeWeight = -1;
    }

    public void addAdjacentNode(AdjNode AdjNode) {
        this.adjacentList.add(AdjNode);
    }

    public void removeAdjacentNode(int AdjNodeid) {
        for (AdjNode adjNode : this.adjacentList) {
            if (adjNode.getId() == AdjNodeid) {
                this.adjacentList.remove(adjNode);
            }
        }
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

    public String getBFSColor() {
        return this.BFSColor;
    }

    public void setBFSColor(String BFSColor) {
        this.BFSColor = BFSColor;
    }

    public int getBFSPiId() {
        return this.BFSPiId;
    }

    public void setBFSPiId(int BFSPiId) {
        this.BFSPiId = BFSPiId;
    }

    public double getBFSPiEdgeWeight() {
        return this.BFSPiEdgeWeight;
    }

    public void setBFSPiEdgeWeight(Double BFSPiEdgeWeight) {
        this.BFSPiEdgeWeight = BFSPiEdgeWeight;
    }

    // for priority queue
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
