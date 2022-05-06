import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {
    Map<String, ArrayList<String>> adjacencyList = new HashMap<>();
    private int numberOfVertices;

    public Graph() {
        numberOfVertices = 0;
    }

    public Graph(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                String currentPosition = array[i][j];
                if (!currentPosition.equals("G")) {
                    String top;
                    String bottom;
                    String left;
                    String right;

                    try {
                        if (RatVault.isNotWall(array[i - 1][j]) && !array[i - 1][j].equals("G")) {
                            top = array[i - 1][j];
                            addEdge(currentPosition, top);
                        }
                    } catch (IndexOutOfBoundsException ignored) {
                    }
                    try {
                        if (RatVault.isNotWall(array[i + 1][j]) && !array[i + 1][j].equals("G")) {
                            bottom = array[i + 1][j];
                            addEdge(currentPosition, bottom);
                        }
                    } catch (IndexOutOfBoundsException ignored) {
                    }
                    try {
                        if (RatVault.isNotWall(array[i][j - 1]) && !array[i][j - 1].equals("G")) {
                            left = array[i][j - 1];
                            addEdge(currentPosition, left);
                        }
                    } catch (IndexOutOfBoundsException ignored) {
                    }
                    try {
                        if (RatVault.isNotWall(array[i][j + 1]) && !array[i][j + 1].equals("G")) {
                            right = array[i][j + 1];
                            addEdge(currentPosition, right);
                        }
                    } catch (IndexOutOfBoundsException ignored) {
                    }

                }
            }
        }
    }

    public Graph(String fileName, String delimiter) throws FileNotFoundException {
        Scanner kb = new Scanner(new File(fileName));

        while (kb.hasNextLine()) {
            String[] lineNodes = kb.nextLine().split(delimiter);
            for (int i = 1; i < lineNodes.length; i++) {
                addEdge(lineNodes[0], lineNodes[i]);
            }
        }
    }

    public void addEdge(String v, String w) {
        editEdge(w, v);
    }

    private void editEdge(String v, String w) {
        ArrayList<String> currentNodeVertices;

        if (adjacencyList.containsKey(w)) {
            currentNodeVertices = new ArrayList<>(adjacencyList.get(w));
            currentNodeVertices.add(v);
            adjacencyList.replace(w, currentNodeVertices);
        } else {
            currentNodeVertices = new ArrayList<>();
            currentNodeVertices.add(v);
            adjacencyList.put(w, currentNodeVertices);
            numberOfVertices++;
        }
    }

    public int V() {
        return numberOfVertices;
    }

    public int E() {
        int numberOfEdges = 0;

        for (String vertex : vertices()) {
            numberOfEdges += adjacencyList.get(vertex).size();
        }

        return numberOfEdges;
    }

    public Iterable<String> vertices() {
        return adjacencyList.keySet();
    }

    public Iterable<String> adjacentTo(String v) {
        return adjacencyList.get(v);
    }

    public int degree(String v) {
        return adjacencyList.get(v).size();
    }

    public boolean hasVertex(String v) {
        return adjacencyList.containsKey(v);
    }

    public boolean hasEdge(String v, String w) {
        if (!hasVertex(v)) {
            return false;
        }

        ArrayList<String> vSet = adjacencyList.get(v);

        for (String s : vSet) {
            if (s.equals(w)) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        StringBuilder graph = new StringBuilder();

        Set<String> vertices = (Set<String>) vertices();
        for (String vertex : vertices) {
            graph.append(vertex).append(" --> ").append(Arrays.toString(adjacencyList.get(vertex).toArray())).append("\n");
        }

        return graph.toString();
    }
}
