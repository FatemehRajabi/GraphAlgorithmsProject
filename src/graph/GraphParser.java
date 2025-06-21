package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class GraphParser {

    public static Graph parseFile(String fileNAme) throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader("input/graph1.txt"));
        String firstLine = reader.readLine();
        String[] parts = firstLine.split(" ");
        int numberOfNodes = Integer.parseInt(parts[0]);
        int numberOfEdges = Integer.parseInt(parts[1]);
        boolean isDirected = parts[2].equals("D");

        for(int i=0; i<numberOfNodes; i++){
            String currentLine = reader.readLine();
            String[] edgeParts = currentLine.split(" ");
            String from = edgeParts[0];
            String to = edgeParts[1];
            int weight = Integer.parseInt(edgeParts[2]);

            addEdge(graph, from, to, weight, isDirected);
        }

        String sourceLine = reader.readLine();
        if (sourceLine != null && !sourceLine.isEmpty()) {
            graph.setSource(sourceLine.trim());
        }

        String[] info = firstLine.split(" ");

    }

    public static void addEdge(Graph graph, String u, String v, int weight, boolean isDirected){
        Edge edge = new Edge(u, v, weight);
        graph.adjacencyList(edge);
        if (!isDirected){
            Edge reverseEdge = new Edge(v, u, weight);
            graph.adjacencyList(reverseEdge);
        }
    }
}
