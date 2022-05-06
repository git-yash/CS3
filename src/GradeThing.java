import java.util.ArrayList;
import java.util.Scanner;

public class GradeThing {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String[] actualAnswers = kb.nextLine().split(" ");
        String[] submittedAnswers = kb.nextLine().split(" ");
        ArrayList<Integer> incorrectAnswers = new ArrayList<>();

        for (int i = 0; i < submittedAnswers.length; i++) {
            if(!submittedAnswers[i].equals(actualAnswers[i])){
                incorrectAnswers.add(i + 1);
            }
        }

        System.out.println("Number incorrect: " + incorrectAnswers.size());
        for (int incorrectAnswer : incorrectAnswers) {
            System.out.print(incorrectAnswer + " ");
        }

    }
}
