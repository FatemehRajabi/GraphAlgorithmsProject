import graph.Dijkstra;
import graph.Graph;
import graph.GraphParser;
import graph.Prim;

import java.io.IOException;

public class Main {

    public static void main(String[] args){
        try {
            Graph graph = GraphParser.parseFile("input/graph1.txt");
//            graph.printGraph();

            System.out.println("===== Dijkstra (Single-source Shortest Path) Output =====");
            Dijkstra.findShortestPath(graph, graph.getSource());

            if(!graph.isDirected()){
                System.out.println("\n===== Prim's Minimum Spanning Tree  Output =====");
                Prim.findMST(graph);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
