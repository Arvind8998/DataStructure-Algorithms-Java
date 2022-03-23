import java.util.*;

public class CombinationSumTarget {

    public static void combinationSum(int[] arr, int tar, int idx, List<List<Integer>> ans, List<Integer> smallAns) {

        if (tar == 0) {
            List<Integer> base = new ArrayList<>(smallAns); // deep copy
            ans.add(base); // shallow copy
            return;
        }
        int prev = -1;
        for (int i = idx; i < arr.length; i++) {
            if (prev!= arr[i] && tar - arr[i] >= 0) {
                smallAns.add(arr[i]);
                combinationSum(arr, tar - arr[i], i+1, ans, smallAns);
                prev = arr[i];
                smallAns.remove(smallAns.size() - 1);
            }
            
        }

    }

    public static List<List<Integer>> combinationSum(int[] arr, int tar) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        combinationSum(arr, tar, 0, ans, smallAns);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 5, 4, 3, 2, 2, 1 };
        List<List<Integer>> ans = combinationSum(arr, 10);
        ans.forEach(System.out::println);
        System.out.println(ans.size());
    }
}
