import java.util.HashSet;

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int len = 0, n = s.length();
        for (String ss : wordDict) {
            set.add(ss);
            len = Math.max(len, ss.length());
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            if (!dp[i])
                continue;

            for (int idx = 1; idx <= len && i + idx <= n; idx++) {
                String sbtr = s.substring(i, i + idx);
                if (set.contains(sbtr)) {
                    dp[i + idx] = true;
                }
            }
        }
        return dp[n];
    }
}