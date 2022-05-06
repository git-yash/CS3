import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphRunner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(System.in);
        Graph moviesGraph = new Graph("movies.txt", "/");
        String name = kb.nextLine();

        for (String adj : moviesGraph.adjacentTo(name)) {
            System.out.println(adj);
        }
    }
}
