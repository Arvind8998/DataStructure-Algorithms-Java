import java.util.*;

public class Main {
    public static ArrayList<Integer> majorityElement(int[] arr, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int el : arr) {
            if (myMap.containsKey(el)) {
                int freq = myMap.get(el);
                myMap.put(el, ++freq);
            } else {
                myMap.put(el, 1);
            }
        }

        myMap.keySet().forEach(el -> {
            if (myMap.get(el) > n / k) {
                res.add(el);
            }
        });
        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        ArrayList<Integer> res = majorityElement(arr, k);
        System.out.println(res);
    }
}