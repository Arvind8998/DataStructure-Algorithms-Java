package PepCoding.LevelUp.LeetCodeSubmissions;
class Solution {
    static String max;
	public static void findMaximum(String str, int k) {
        if(k==0) return;
		
        for(int i=0; i<str.length(); i++){
            int idx = -1;
            char maxChar = '0';
            
            for(int j=i+1; j<str.length(); j++){
                if(str.charAt(i) < str.charAt(j) && maxChar < str.charAt(j)){
                    maxChar = str.charAt(j);
                    idx = j;
                }
            }
            if(idx != -1){
                for(int j=idx; j<str.length(); j++){
                    if(str.charAt(j) == maxChar){
                        String temp = swap(str, i ,j);
                        if(isGreater(temp, max)) max = temp;
                        findMaximum(temp, k-1);
                    }
                }
            }
        }
	}

    public static String swap(String str, int i, int j){
        StringBuilder sb = new StringBuilder(str);
        
        char c1 = str.charAt(i);
        char c2 = str.charAt(j);
        
        sb.setCharAt(i, c2);
        sb.setCharAt(j, c1);

        return sb.toString();
    }

    public static boolean isGreater(String temp, String str ){
        if(temp.length() > str.length()) return true;
        else if(temp.length() < str.length()) return false;

        for(int idx =0; idx< str.length(); idx++){
            if(temp.charAt(idx) > str.charAt(idx)) return true;
            else if( temp.charAt(idx) < str.charAt(idx)) return false;
        }
        return true;
    }
    
    public int maximumSwap(int num) {
        String number = String.valueOf(num);
        max = number;
        findMaximum(number, 1);
        return Integer.parseInt(max);
    }
}