package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphParser {

    public static Graph parseFile(String fileNAme) throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader(fileNAme));
        String firstLine = reader.readLine();
        String[] parts = firstLine.split(" ");
        int numberOfNodes = Integer.parseInt(parts[0]);
        int numberOfEdges = Integer.parseInt(parts[1]);
        boolean isDirected = parts[2].equals("D");
        Graph graph = new Graph(isDirected);

        for(int i=0; i<numberOfEdges; i++){
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
        return graph;
    }

    public static void addEdge(Graph graph, String u, String v, int weight, boolean isDirected){

        graph.addEdge(new Edge(u, v, weight));
        if (!isDirected) {
            graph.addEdge(new Edge(v, u, weight));
        }
    }
}
