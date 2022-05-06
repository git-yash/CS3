import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RatVault {
    public static boolean isNotWall(String position) {
        return !position.equals("G");
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("rat.dat"));
        int numberOfInputs = kb.nextInt();
        ArrayList<String> messages = new ArrayList<>();

        for (int i = 0; i < numberOfInputs; i++) {
            int rows = kb.nextInt();
            int columns = kb.nextInt();
            kb.nextLine();
            String[] gridInArray = new String[rows * columns];
            String[][] grid = new String[rows][columns];
            int count1 = 0;

            for (int j = 0; j < rows; j++) {
                String currentLine = kb.nextLine();
                for (int k = 0; k < columns; k++, count1++) {
                    String[] positions = currentLine.split("");

                    if (positions[k].equals(".")) {
                        gridInArray[count1] = String.valueOf(count1);
                    } else {
                        gridInArray[count1] = positions[k];
                    }
                }
            }

            int count = 0;
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++, count++) {
                    grid[j][k] = gridInArray[count];
                }
            }

            Graph graph = new Graph(grid);
            try {
                BFS mazePositions = new BFS(graph, "E");
                messages.add(mazePositions.distanceTo("S") + " seconds");
            } catch (Exception e) {
                messages.add("Oh Rem please help me");
            }

        }

        for (String message : messages) {
            System.out.println(message);
        }

    }
}
