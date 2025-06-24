import graph.Dijkstra;
import graph.Graph;
import graph.GraphParser;
import graph.Prim;

import java.io.IOException;

public class Main {

    public static void main(String[] args){
        try {
            Graph graph1 = GraphParser.parseFile("input/graph1.txt");
            Graph graph2 = GraphParser.parseFile("input/graph2.txt");
            Graph graph3 = GraphParser.parseFile("input/graph3.txt");
            Graph graph4 = GraphParser.parseFile("input/graph4.txt");

            System.out.println("Graph 1: Dijkstra (Single-source Shortest Path) Output");
            Dijkstra.findShortestPath(graph1, graph1.getSource());

            if(!graph1.isDirected()){
                System.out.println("\nGraph 1: Prim's Minimum Spanning Tree Output");
                Prim.findMST(graph1);
            }

            if(!graph2.isDirected()){
                System.out.println("\nGraph 2: Prim's MST Output");
                Prim.findMST(graph2);
            }

            System.out.println("\nGraph 2: Dijkstra Output");
            Dijkstra.findShortestPath(graph2, graph2.getSource());

            System.out.println("\nGraph 3: Dijkstra Output");
            Dijkstra.findShortestPath(graph3, graph3.getSource());

            if (!graph3.isDirected()) {
                System.out.println("Graph 3: Prim's MST Output");
                Prim.findMST(graph3);
            }

            System.out.println("\nGraph 4: Dijkstra Output");
            Dijkstra.findShortestPath(graph4, graph4.getSource());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
