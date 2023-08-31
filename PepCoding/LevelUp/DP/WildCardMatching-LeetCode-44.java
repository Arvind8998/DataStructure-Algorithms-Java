class Solution {
    public String removeStar(String str) {
        int n = str.length();
        if (n == 0)
            return str;

        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));

        int idx = 1;

        while (idx < n) {
            while (idx < n && sb.charAt(sb.length() - 1) == '*' && str.charAt(idx) == '*') {
                idx++;
            }

            if (idx < n)
                sb.append(str.charAt(idx));
            idx++;
        }
        return sb.toString();
    }

    public int isWildCardMatch(String str, String p, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            if (n == 0 && m == 0) {
                return dp[n][m] = 1;
            } else if (m == 1 && p.charAt(m - 1) == '*')
                return dp[n][m] = 1;
            else
                return dp[n][m] = 0;
        }

        if (dp[n][m] != -1)
            return dp[n][m];

        char ch1 = str.charAt(n - 1);
        char ch2 = p.charAt(m - 1);

        if (ch1 == ch2 || ch2 == '?') {
            return dp[n][m] = isWildCardMatch(str, p, n - 1, m - 1, dp);
        } else if (ch2 == '*') {
            boolean res = false;
            res = res || isWildCardMatch(str, p, n - 1, m, dp) == 1; // * taken as sequence of character
            res = res || isWildCardMatch(str, p, n, m - 1, dp) == 1; // * taken as empty string
            return dp[n][m] = res ? 1 : 0;
        } else {
            return dp[n][m] = 0;
        }
    }

    public boolean isMatch(String s, String p) {
        String pattern = removeStar(p);
        int n = s.length(), m = pattern.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        int res = isWildCardMatch(s, pattern, n, m, dp);
        return res == 1;
    }
}