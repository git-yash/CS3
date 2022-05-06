import java.io.FileNotFoundException;

public class BaconNumberRunner {
    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph("movies.txt", "/");
        BFS movies = new BFS(graph, "Bacon, Kevin");
        System.out.println(movies.pathTo("50 Cent"));
        System.out.println(movies.distanceTo("50 Cent") / 2);
    }
}
