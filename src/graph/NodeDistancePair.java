package graph;

public class NodeDistancePair {
    private String node;
    private int distance;

    public NodeDistancePair(String node, int distance){
        this.node = node;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getNode() {
        return node;
    }
}
