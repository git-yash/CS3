import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestRunner {
    public static boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<String, Integer> frequency1 = new HashMap<>();
        Map<String, Integer> frequency2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            String currentChar1 = word1.substring(i, i + 1);
            String currentChar2 = word2.substring(i, i + 1);

            if (frequency1.containsKey(currentChar1)) {
                frequency1.replace(currentChar1, frequency1.get(currentChar1) + 1);
            } else {
                frequency1.put(currentChar1, 1);
            }

            if (frequency2.containsKey(currentChar2)) {
                frequency2.replace(currentChar2, frequency2.get(currentChar2) + 1);
            } else {
                frequency2.put(currentChar2, 1);
            }
        }

        return frequency1.equals(frequency2);
    }

    public static int[] firstAndLastPos(int[] arr, int target) {
        int firstPos = -1;
        int lastPos = -1;
        int left = 0;
        int right = arr.length - 1;

        if (arr[0] == target) {
            firstPos = 0;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target && arr[mid - 1] < target) {
                firstPos = mid;
            }
            else if(arr[mid] < target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        if(arr[-1] == target){

        }
        left = 0;
        right = arr.length - 1;

        return new int[]{firstPos, lastPos};
    }

    public static void main(String[] args) {
        String word1 = "dhanggr";
        String word2 = "gardgn";

        System.out.println(isAnagram(word1, word2));

        int[] arr = {2, 4, 5, 5, 5, 5, 5, 7, 9, 9};
        int target = 5;

        System.out.println(Arrays.toString(firstAndLastPos(arr, target)));
    }
}
