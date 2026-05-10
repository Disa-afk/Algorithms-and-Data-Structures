import java.util.*;

public class GraphTraversal {
    private Map<Character, List<Character>> adj = new LinkedHashMap<>();

    public void addEdge(char u, char v) {
        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }

    public void dfs(char start) {
        Set<Character> visited = new LinkedHashSet<>();
        System.out.print("DFS Order: ");
        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(char v, Set<Character> visited) {
        visited.add(v);
        System.out.print(v + " ");
        for (char neighbor : adj.getOrDefault(v, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public void bfs(char start) {
        Set<Character> visited = new LinkedHashSet<>();
        Queue<Character> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS Order: ");
        while (!queue.isEmpty()) {
            char v = queue.poll();
            System.out.print(v + " ");
            for (char neighbor : adj.getOrDefault(v, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphTraversal g = new GraphTraversal();
        g.addEdge('A', 'C'); g.addEdge('A', 'B'); g.addEdge('A', 'D');
        g.addEdge('B', 'A'); g.addEdge('B', 'C'); g.addEdge('B', 'E'); g.addEdge('B', 'G');
        g.addEdge('C', 'A'); g.addEdge('C', 'B'); g.addEdge('C', 'D');
        g.addEdge('D', 'C'); g.addEdge('D', 'A');
        g.addEdge('E', 'G'); g.addEdge('E', 'F'); g.addEdge('E', 'B');
        g.addEdge('F', 'G'); g.addEdge('F', 'E');
        g.addEdge('G', 'F'); g.addEdge('G', 'B');

        g.dfs('A');
        g.bfs('A');
    }
}