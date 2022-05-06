import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BubblePop {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("bubble.dat"));
        String[][] array = new String[10][10];

        for (int i = 0; i < 10; i++) {
            String[] line = kb.next().split("");
            array[i] = line;
        }

        boolean[][] trueArray = new boolean[10][10];
        int numberOfInputs = kb.nextInt();

        for (int i = 0; i < numberOfInputs; i++) {
            int y = kb.nextInt();
            int x = kb.nextInt();
            String master = array[y][x];
            trueArray[y][x] = true;
            int counter = 1;
            Stack<Integer> xStack = new Stack<>();
            Stack<Integer> yStack = new Stack<>();
            xStack.push(y);
            yStack.push(x);
            while (!xStack.isEmpty()) {
                int tempX = xStack.pop();
                int tempY = yStack.pop();
                if (tempX - 1 >= 0) {
                    if (array[tempX - 1][tempY].equals(master) && !trueArray[tempX - 1][tempY]) {
                        xStack.add(tempX - 1);
                        yStack.add(tempY);
                        trueArray[tempX - 1][tempY] = true;
                        counter++;
                    }
                }
                if (tempX + 1 < 10) {
                    if (array[tempX + 1][tempY].equals(master) && !trueArray[tempX + 1][tempY]) {
                        xStack.add(tempX + 1);
                        yStack.add(tempY);
                        trueArray[tempX + 1][tempY] = true;
                        counter++;
                    }
                }
                if (tempY - 1 >= 0) {
                    if (array[tempX][tempY - 1].equals(master) && !trueArray[tempX][tempY - 1]) {
                        xStack.add(tempX);
                        yStack.add(tempY - 1);
                        trueArray[tempX][tempY - 1] = true;
                        counter++;
                    }
                }
                if (tempY + 1 < 10) {
                    if (array[tempX][tempY + 1].equals(master) && !trueArray[tempX][tempY + 1]) {
                        xStack.add(tempX);
                        yStack.add(tempY + 1);
                        trueArray[tempX][tempY + 1] = true;
                        counter++;
                    }
                }
            }
            if(counter >= 3){
                System.out.println("YES " + counter);
            }else{
                System.out.println("NO");
            }
        }
    }
}
