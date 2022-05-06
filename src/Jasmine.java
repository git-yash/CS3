import java.util.Scanner;

public class Jasmine {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String name = kb.next();
        String firstPart = name.substring(0, 2);
        String secondPart = name.substring(2, 4);
        String thirdPart = name.substring(4);

        System.out.print(firstPart + " " + secondPart + " " + thirdPart + " ==> ");

        thirdPart = thirdPart.toUpperCase();
        firstPart = firstPart.toLowerCase();
        firstPart = new StringBuilder(firstPart).reverse().toString();
        secondPart = new StringBuilder(secondPart).reverse().toString();
        secondPart = secondPart.toUpperCase();

        if (thirdPart.length() > firstPart.length()) {
            System.out.print(thirdPart + firstPart + secondPart);
        } else {
            firstPart = new StringBuilder(firstPart).reverse().toString();
            firstPart = firstPart.toUpperCase();
            secondPart = secondPart.toLowerCase();
            System.out.println(firstPart + secondPart + thirdPart);
        }

    }
}
