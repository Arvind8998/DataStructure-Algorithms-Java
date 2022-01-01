class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
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
        List<String> ans = new ArrayList<>();
        if (dp[n]) {
            wordBreak__backEngg(s, wordDict, ans, len, set, 0, dp, "");
        }
        return ans;
    }

    public void wordBreak__backEngg(String s, List<String> wordDict, List<String> ans, int maxLength,
            HashSet<String> set, int idx, boolean[] dp, String ssf) {
        if (idx >= s.length()) {
            ans.add(ssf.substring(0, ssf.length() - 1));
            return;
        }

        for (int i = 1; i <= maxLength && i + idx <= s.length(); i++) {
            if (dp[i + idx]) {
                String substr = s.substring(idx, i + idx);
                if (set.contains(substr)) {
                    wordBreak__backEngg(s, wordDict, ans, maxLength, set, i + idx, dp, ssf + substr + " ");
                }
            }
        }

    }
}