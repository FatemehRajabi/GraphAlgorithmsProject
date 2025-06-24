package graph;

import java.util.*;

public class Prim {

    public static void findMST(Graph graph){

        Set<String> visitedNodes = new HashSet<>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        List<Edge> mstEdges = new ArrayList<>();
        int totalWeight = 0;

        String source = graph.getSource();
        visitedNodes.add(source);
        List<Edge> edges = graph.getAdjacencyList().get(source);

        for(int i=0; i<edges.size(); i++){
            priorityQueue.add(edges.get(i));
        }

        while (!priorityQueue.isEmpty()){
            Edge smallestEdge = priorityQueue.poll();
            String newNode;
            if (!visitedNodes.contains(smallestEdge.getDestination())
                    && visitedNodes.contains(smallestEdge.getSource())){
                newNode = smallestEdge.getDestination();
                mstEdges.add(smallestEdge);
                visitedNodes.add(newNode);

                List<Edge> currentAdjacencyList = graph.getAdjacencyList().get(newNode);
                for(int i=0; i<currentAdjacencyList.size(); i++){
                    priorityQueue.add(currentAdjacencyList.get(i));
                }

            } else if (visitedNodes.contains(smallestEdge.getDestination())
                    && !visitedNodes.contains(smallestEdge.getSource())){
                newNode = smallestEdge.getSource();
                mstEdges.add(smallestEdge);
                visitedNodes.add(newNode);

                List<Edge> currentAdjacencyList = graph.getAdjacencyList().get(newNode);
                for(int i=0; i<currentAdjacencyList.size(); i++){
                    priorityQueue.add(currentAdjacencyList.get(i));
                }
            }
        }

        for (int i=0; i<mstEdges.size(); i++){
            System.out.println(mstEdges.get(i));
            totalWeight += mstEdges.get(i).getWeight();
        }
        System.out.println("Total weight: " + totalWeight);

        if (visitedNodes.size() < graph.getAdjacencyList().size()) {
            System.out.println("Warning: Graph is not connected. MST could not reach all nodes.");
        }

    }

}
