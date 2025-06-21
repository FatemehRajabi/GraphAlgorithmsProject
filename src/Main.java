import graph.Graph;
import graph.GraphParser;

import java.io.IOException;

public class Main {

    public static void main(String[] args){
        try {
            Graph graph = GraphParser.parseFile("input/graph1.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
