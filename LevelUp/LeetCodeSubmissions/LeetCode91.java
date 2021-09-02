class Solution {
    public static int getDecodingsCount(String str, int idx, int[] dp){
        if(idx == str.length()) return dp[idx] =1;
        
        char ch = str.charAt(idx);
        
        if(dp[idx] != -1) return dp[idx];
        
        if(ch == '0'){
            return dp[idx] = 0;
        }
        int count = getDecodingsCount(str, idx+1, dp);

        if(idx < str.length() -1){
            char ch1 = str.charAt(idx+1);
            int num = (ch - '0')*10 + (ch1 -'0');
            if(num <=26){
                count += getDecodingsCount(str, idx+2, dp);
            }
        }
        
        return dp[idx] = count;
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length() +1];
        Arrays.fill(dp, -1);
        return getDecodingsCount(s, 0, dp);
    }
}