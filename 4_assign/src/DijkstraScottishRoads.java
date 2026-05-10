import java.util.*;

public class DijkstraScottishRoads {
    static class Edge {
        String target;
        int weight;
        Edge(String target, int weight) { this.target = target; this.weight = weight; }
    }

    public static void computePath(String start, String end, Map<String, List<Edge>> graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> prev = new HashMap<>();

        for (String node : graph.keySet()) distances.put(node, Integer.MAX_VALUE);
        distances.put(start, 0);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.dist > distances.get(current.name)) continue;

            for (Edge edge : graph.getOrDefault(current.name, new ArrayList<>())) {
                int newDist = distances.get(current.name) + edge.weight;
                if (newDist < distances.get(edge.target)) {
                    distances.put(edge.target, newDist);
                    prev.put(edge.target, current.name);
                    pq.add(new Node(edge.target, newDist));
                }
            }
        }

        System.out.println("Shortest Distance: " + distances.get(end));
    }

    static class Node {
        String name; int dist;
        Node(String n, int d) { name = n; dist = d; }
    }

    public static void main(String[] args) {
        Map<String, List<Edge>> graph = new HashMap<>();
        graph.put("Edinburgh", List.of(new Edge("Stirling", 50), new Edge("Glasgow", 70), new Edge("Perth", 100)));
        graph.put("Stirling", List.of(new Edge("Perth", 40), new Edge("Glasgow", 50)));
        graph.put("Perth", List.of(new Edge("Dundee", 60)));
        graph.put("Dundee", new ArrayList<>());
        graph.put("Glasgow", new ArrayList<>());

        computePath("Edinburgh", "Dundee", graph);
    }
}