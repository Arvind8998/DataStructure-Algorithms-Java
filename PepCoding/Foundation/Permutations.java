import java.io.*;
import java.util.*;

public class Main {

    public static Scanner scn = new Scanner(System.in);

   public static int printPermutations(String str, String ans) {
         if(str.length() == 0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        char prev = '$';
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != prev){
                String ros = str.substring(0,i) + str.substring(i+1);
                count += printPermutations(ros, ans+ str.charAt(i));
            }
            prev = str.charAt(i);
        }
        return count;
    }

  public static void printPermutationWithoutDuplicate(String str){
    StringBuilder sb = new StringBuilder();
    int[] freq = new int[26];
    for(int i=0; i<str.length(); i++)
        freq[str.charAt(i) -'a']++;
    
    for(int i=0; i<26; i++){
        for(int j=0; j<freq[i]; j++){
            sb.append((char)(i + 'a'));
        }
    }
    printPermutations(sb.toString(),"");
    }

public static void main(String[] args) throws Exception {
    String str = scn.nextLine();
    printPermutationWithoutDuplicate(str);
}
}




