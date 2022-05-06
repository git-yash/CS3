import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Components {
    public static boolean isRaw(ArrayList<String> ingredients, Map<String, ArrayList<String>> recipes) {
        for (String ingredient : ingredients) {
            if (recipes.containsKey(ingredient)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("components.dat"));
        int numberOfRecipes = kb.nextInt();
        Map<String, ArrayList<String>> recipes = new HashMap<>();
        kb.nextLine();

        // Put everything in hashmap
        for (int i = 0; i < numberOfRecipes; i++) {
            String[] line = kb.nextLine().split(" ");
            String name = line[0];
            String[] ingredients = new String[line.length - 2];
            System.arraycopy(line, 2, ingredients, 0, line.length - 2);
            recipes.put(name, new ArrayList<>(Arrays.asList(ingredients)));
        }

        for (Map.Entry<String, ArrayList<String>> entry : recipes.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> ingredients = entry.getValue();
            ArrayList<String> nonRawIngredients = new ArrayList<>();

            for (String ingredient : ingredients) {
                if (recipes.containsKey(ingredient)) {
                    nonRawIngredients.add(ingredient);
                }
            }

            while (!isRaw(nonRawIngredients, recipes)) {
                ArrayList<String> rawIngredients = recipes.get(nonRawIngredients.get(0));
                nonRawIngredients.remove(0);
                nonRawIngredients.addAll(rawIngredients);
            }

            ArrayList<String> rawIngredients = new ArrayList<>();
            for (String ingredient : ingredients) {
                if (!recipes.containsKey(ingredient)) {
                    rawIngredients.add(ingredient);
                }
            }

            nonRawIngredients.addAll(rawIngredients);
            recipes.replace(key, nonRawIngredients);
        }


        int numberOfRequests = kb.nextInt();
        for (int i = 0; i < numberOfRequests; i++) {
            ArrayList<String> inputList = recipes.get(kb.next());

            Map<String, Integer> frequencyOfElements = new TreeMap<>();
            for (String element : inputList) {
                if (frequencyOfElements.containsKey(element)) {
                    frequencyOfElements.put(element, frequencyOfElements.get(element) + 1);
                } else {
                    frequencyOfElements.put(element, 1);
                }
            }

            for (String name : frequencyOfElements.keySet()) {
                String value = frequencyOfElements.get(name).toString();
                System.out.println(name + " " + value);
            }

            System.out.println("***");
        }

    }
}