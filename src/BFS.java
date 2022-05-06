import java.io.FileNotFoundException;
import java.util.*;

public class BFS {
    Map<String, Integer> dist = new HashMap<>();
    Map<String, String> prev = new HashMap<>();

    public BFS(Graph g, String s) {
        Queue<String> q = new LinkedList<>();
        q.add(s);
        int distance = 0;
        dist.put(s, distance);
        while (!q.isEmpty()) {
            String current = q.remove();
            for (String adj : g.adjacentTo(current)) {
                if (!dist.containsKey(adj)) {
                    q.add(adj);
                    dist.put(adj, dist.get(current) + 1);
                    prev.put(adj, current);
                }
            }
        }
    }

    public int distanceTo(String v) {
        return dist.get(v);
    }

    public Stack<String> pathTo(String v) {
        Stack<String> path = new Stack<>();
        while (v != null && dist.containsKey(v)) {
            path.push(v);
            v = prev.get(v);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph a = new Graph("airline.txt", " ");
        BFS airports = new BFS(a, "JFK");
        System.out.println(airports.pathTo("LAX"));
        System.out.println(airports.distanceTo("LAX"));
    }
}
