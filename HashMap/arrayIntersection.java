import java.io.*;
import java.util.*;

public class arrayIntersection {

    public static Scanner scn = new Scanner(System.in);

    public static void inputArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }

    public static void getintersectionWithputDuplicate(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int el : arr1)
            map.put(el, map.getOrDefault(el, 0) + 1);

        for (int el : arr2) {
            if (map.containsKey(el)) {
                System.out.println(el);
                map.remove(el);
            }
        }
    }

    public static void getintersectionWithDuplicate(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int el : arr1)
            map.put(el, map.getOrDefault(el, 0) + 1);

        for (int el : arr2) {
            if (map.containsKey(el)) {
                System.out.println(el);
                map.put(el, map.get(el) - 1);
                if (map.get(el) == 0)
                    map.remove(el);
            }
        }
    }

    public static char maxfreqChar(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int maxFreq = 0;
        char maxfreqChar = '\u0000';

        for (char key : map.keySet()) {
            if (map.get(key) > maxFreq) {
                maxFreq = map.get(key);
                maxfreqChar = key;
            }
        }
        return maxfreqChar;
    }

    public static void main(String[] args) throws Exception {
        // int n1 = scn.nextInt();
        // int[] arr1 = new int[n1];
        // inputArr(arr1);
        // int n2 = scn.nextInt();
        // int[] arr2 = new int[n2];
        // inputArr(arr2);

        String str = scn.nextLine();
        maxfreqChar(str);
    }

}