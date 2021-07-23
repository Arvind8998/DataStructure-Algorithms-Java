// AllPalindromePartitions
import java.util.*;

public class Main {
    public static boolean isPalindrome(String str){
        int left = 0;
        int right = str.length()-1;

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

	public static void solution(String str, String asf) {
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }
        for(int i=0; i<str.length(); i++){
            String prefix = str.substring(0,i+1);
            String ros = str.substring(i+1);
            if(isPalindrome(prefix)){
                solution(ros, asf +"(" + prefix+ ")" +" ");
            }
        }
		
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		solution(str, "");
	}

}