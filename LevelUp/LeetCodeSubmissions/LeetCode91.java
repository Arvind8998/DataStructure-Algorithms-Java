class Solution {
    public int numDecoding(String str, int idx, int[]dp){
        if(idx == str.length()) return dp[idx] = 1;
        if(dp[idx] != -1) return dp[idx];
        
        char ch = str.charAt(idx);
        if(ch == '0') return dp[idx] = 0;
        int count = numDecoding(str, idx+1, dp);

        if(idx < str.length()-1){
            char ch2 = str.charAt(idx+1);
            int num = (ch -'0')*10 + (ch2 - '0');

            if(num <=26)
             count += numDecoding(str, idx+2, dp);
        }
        return dp[idx] = count;
    }

    public int numDecodings(String str){
        int n = str.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);
        return numDecoding(str,0, dp);
    }
}