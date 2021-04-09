import java.io.*;
import java.util.*;

public class Main {

public static Scanner scn = new Scanner(System.in);

public static boolean isPalindrome(String str, int si, int ei){
    while(si < ei){
        if(str.charAt(si) != str.charAt(ei)){
            return false;
        }
        si++;
        ei--;
        
    }
    return true;
}

	public static void solution(String str){
	    int n = str.length();
		for(int i=0; i<n; i++){
		 for(int j=i; j<n; j++){   
		 if(isPalindrome(str, i,j)){
		     String sbStr = str.substring(i, j+1);
		     System.out.println(sbStr);
		 }
		}
		
	}
	}

	public static void main(String[] args) {
		
		String str = scn.next();
		solution(str);
	}

}