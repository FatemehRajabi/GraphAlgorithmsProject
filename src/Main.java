import graph.Dijkstra;
import graph.Graph;
import graph.GraphParser;

import java.io.IOException;

public class Main {

    public static void main(String[] args){
        try {
            Graph graph = GraphParser.parseFile("input/graph1.txt");
//            graph.printGraph();
            Dijkstra.findShortestPath(graph, "F");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
