package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

//    private List<Edge>;
//    private List<Node>;
    private boolean isDirected;
    private Map<String, List<Edge>> adjacencyList = new HashMap<>();
    private String source;

    public Graph(boolean isDirected){
        this.isDirected = isDirected;
    }

    public void addEdge(Edge edge) {
        adjacencyList.putIfAbsent(edge.getSource(), new ArrayList<>());
        adjacencyList.get(edge.getSource()).add(edge);
    }

    public Map<String, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print(node + " -> ");
            for (Edge edge : adjacencyList.get(node)) {
                System.out.print(edge.getDestination() + "(" + edge.getWeight() + ") ");
            }
            System.out.println();
        }
    }

}
