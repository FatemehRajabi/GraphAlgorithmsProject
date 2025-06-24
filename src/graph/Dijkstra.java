package graph;

import java.util.*;

public class Dijkstra {

    public static void findShortestPath(Graph graph, String source){

        Map<String, Integer> distanceMap = new HashMap<>();
        Map<String, String> previousMap = new HashMap<>();
        Set<String> visitedNodes = new HashSet<>();
        PriorityQueue<NodeDistancePair> priorityQueue =
                new PriorityQueue<>(Comparator.comparingInt(NodeDistancePair::getDistance));

        for (String node: graph.getAdjacencyList().keySet()){
            distanceMap.put(node, Integer.MAX_VALUE);
        }
        distanceMap.put(source, 0);

        priorityQueue.add(new NodeDistancePair(source, 0));

        int currentDistance;
        while (!priorityQueue.isEmpty()){
            NodeDistancePair currentNode = priorityQueue.poll();
            if (!visitedNodes.contains(currentNode.getNode())){
                visitedNodes.add(currentNode.getNode());

                List<Edge> neighbors = graph.getAdjacencyList().get(currentNode.getNode());

                for (Edge node: neighbors){
                    int newDistance = distanceMap.get(currentNode.getNode()) + node.getWeight();
                    String neighbour = node.getDestination();
                    if (newDistance < distanceMap.get(neighbour)){
                        distanceMap.put(neighbour, newDistance);
                        previousMap.put(neighbour, currentNode.getNode());
                        priorityQueue.add(new NodeDistancePair(neighbour, newDistance));
                    }
                }
            }
        }


        for (String node : distanceMap.keySet()){
            if (distanceMap.get(node) == Integer.MAX_VALUE){
                System.out.println("unreachable");
            } else {
                System.out.println(source + " -> " + node + ": cost= " + distanceMap.get(node));
                printPath(previousMap, node);
            }
        }
    }
    public static void printPath(Map<String, String> previousMap, String target){
        List<String> path = new ArrayList<>();
        String current = target;

        while (current != null){
            path.add(current);
            current = previousMap.get(current);
        }

        Collections.reverse(path);
        System.out.println(String.join(" -> ", path));
        System.out.println();

    }
}
