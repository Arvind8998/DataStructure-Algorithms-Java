import java.io.*;
import java.util.*;

public class Main {

	public static String compression1(String str){
		String ans = "";
		ans += str.charAt(0);
		
		int i = 1;
		int n = str.length();
		
		while(i < n){
		    while(i< n && ans.charAt(ans.length()-1) == str.charAt(i)){
		        i++;
		    }
		    if(i<n){
		        ans += str.charAt(i);
		        i++;
		    }
		}

		return ans;
	}

	public static String compression2(String str){
			String ans = "";
		ans += str.charAt(0);
		
		int i = 1;
		int n = str.length();
		int changes =0;
		while(i < n){
		    int count = 1;
		    while(i< n && ans.charAt(ans.length()-1) == str.charAt(i)){           count++;
		        i++;
		    }
		    if(count>1){
		        ans += count;
		    }
		    if(i<n){
		        ans += str.charAt(i);
		        i++;
		    }
		}

		return ans;

	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}