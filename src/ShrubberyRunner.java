import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ShrubberyRunner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("shrubbery.dat"));
        int numberOfDataSets = kb.nextInt();

        for (int i = 0; i < numberOfDataSets; i++) {
            int shrubberyCount = kb.nextInt();
            ArrayList<Shrubbery> shrubberies = new ArrayList<>();

            for (int j = 0; j < shrubberyCount; j++) {
                shrubberies.add(new Shrubbery(kb.next(), kb.nextInt(), kb.nextDouble(), kb.nextDouble()));
            }

            Shrubbery.sortBy = kb.next();
            Collections.sort(shrubberies);

            for (Shrubbery shrubbery : shrubberies) {
                System.out.println(shrubbery.getName());
            }

            System.out.println();
        }
    }
}