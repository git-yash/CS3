public class Test {
    public static boolean doesHaveSum(int[] arr, int sum){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i] + arr[j] == sum){
                    return true;
                }
            }
        }

        return false;
    }
}
