import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.containsKey(ch) == false) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }
        getwordsCount(str, unique, 0, k, "", 0);

    }

    public static void getwordsCount(String str, HashMap<Character, Integer> fmap, int cs, int ts, String asf,
            int lastIdx) {

        if (cs == ts+1) {
            System.out.println(asf);
            return;
        }

        for (int i = lastIdx; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (fmap.get(ch) > 0) {
                fmap.put(ch, fmap.get(ch) - 1);

                getwordsCount(str, fmap, cs + 1, ts, asf + ch, i);
                fmap.put(ch, fmap.get(ch) + 1);
            }
        }
    }

}