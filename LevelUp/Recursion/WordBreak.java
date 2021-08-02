import java.io.*;
import java.util.*;

public class WordBreak {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dict = new HashSet<>();
		for(int i = 0  ; i  < n; i++){
			dict.add(scn.next());
		}
		String sentence = scn.next();
		wordBreak(sentence,"", dict);
	}

	public static int wordBreak(String str, String ans, HashSet<String> dict){
		if(str.length() == 0){
		    System.out.println(ans);
		    return 1;
		} 
		
        int count = 0;
        for(int ei=0; ei<str.length(); ei++){
            String potentialWord = str.substring(0, ei+1);
            if(dict.contains(potentialWord)){
                String restofString = str.substring(ei+1);
                count += wordBreak(restofString, ans + potentialWord +  " ", dict);
            }
        }
        return count;
	}

}