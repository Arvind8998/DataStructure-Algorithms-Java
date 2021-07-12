import java.util.HashMap;
import java.util.ArrayList;

public class hashMap {
    public static void HashMapBasic() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 98);
        map.put("USA", 99);
        map.put("UK", 98);
        map.put("UK", 95);

        // map.remove("UK");
        if (map.containsKey("UK"))
            System.out.println(map.get("UK"));

        // System.out.println(map);
        // ArrayList<String> keys = new ArrayList<>(map.keySet());
        // System.out.println(keys);
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

    }

    // public static void frequencyGetter(String inputStr) {
    //     HashMap<Character, Integer> map= new HashMap<>();
    //     for (int i = 0; i < inputStr.length(); i++) {
    //         char ch = inputStr.charAt(i);
    //         if(map.containsKey(ch)){
    //             int count = map.get(ch);
    //             map.put(ch, ++count);
    //         }
    //         else{
    //             map.put(ch, 1);
    //         }
    //     }
    //     for(char ch : map.keySet()){
    //         System.out.println(ch + " -> " + map.get(ch));
    //     }
    // }

    public static void frequencyGetter(String inputStr) {
        HashMap<Character, ArrayList<Integer>> map= new HashMap<>();
        for (int i = 0; i < inputStr.length(); i++) {
            char ch = inputStr.charAt(i);
            if(map.containsKey(ch)){
                ArrayList<Integer> count = map.get(ch);
                count.add(i);
                map.put(ch, count);
            }
            else{
                ArrayList<Integer> count = new ArrayList<>();
                count.add(i);
                map.put(ch, count);
            }
        }
        for(char ch : map.keySet()){
            System.out.println(ch + " -> " + map.get(ch));
        }
    }

    public static void main(String[] args) {
        HashMapBasic();
        String inputStr = "aabbaaaaaabdsfaa";
        frequencyGetter(inputStr);
    }
}