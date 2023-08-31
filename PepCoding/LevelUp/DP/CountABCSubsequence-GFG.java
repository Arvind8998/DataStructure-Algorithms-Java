// https://practice.geeksforgeeks.org/problems/count-subsequences-of-type-ai-bj-ck4425/1
class Solution {
    public int fun(String s) {
        int n = s.length();
        long emptyCount = 1, aCount = 0, bCount = 0, cCount = 0, mod = (long) 1e9 + 7;

        for (int idx = 0; idx < s.length(); idx++) {
            char ch = s.charAt(idx);
            if (ch == 'a') {
                aCount = aCount + (emptyCount + aCount) % mod;
            } else if (ch == 'b') {
                bCount = bCount + (aCount + bCount) % mod;
            } else if (ch == 'c') {
                cCount = cCount + (bCount + cCount) % mod;
            }
        }

        return (int) (cCount % mod);
    }
}