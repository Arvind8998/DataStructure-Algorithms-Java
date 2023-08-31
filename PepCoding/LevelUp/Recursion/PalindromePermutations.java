package PepCoding.LevelUp.Recursion;
import java.util.*;

public class Main {

	public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
		if(cs > ts){
			String reverse = "";
			int length = asf.length();
			for(int i=length-1; i>=0; i--){
				reverse += asf.charAt(i);	
			}
			String ans = asf;
			if(oddc !=null){
			   ans += oddc; 
			}
			ans += reverse;
			System.out.println(ans);
			return;
		}
		for(char ch: fmap.keySet()){
			int freq = fmap.get(ch);
			if(freq >0){
				fmap.put(ch, freq-1);
				generatepw(cs+1, ts, fmap, oddc, asf+ch);
				fmap.put(ch, freq);
		    }
			}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(fmap.containsKey(ch)){ 
				int of = fmap.get(ch);
				fmap.put(ch, of+1);
			}
			else{
				fmap.put(ch, 1);
			}
		}

		int oddc = 0;
		Character oddEl = null;
		int length =0;

		for(char ch : fmap.keySet()){
			int freq = fmap.get(ch);
			if(freq % 2 == 1){
				oddEl = ch;
				oddc++;
			}
			fmap.put(ch, freq/2);
			length += freq/2;
		}

		if(oddc > 1){
			System.out.println(-1);
			return;
		}
		generatepw(1, length, fmap, oddEl, "");
		
	}
	
}