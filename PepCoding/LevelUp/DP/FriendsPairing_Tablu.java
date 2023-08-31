package PepCoding.LevelUp.DP;
class Solution {
    long mod = (int) 1e9 + 7;

    public long countFriendsPairings(int n) {
        long a = 1;
        long b = 1;
        for (int i = 2; i <= n; i++) {
            long sum = (b + (a * (i - 1) % mod)) % mod;
            a = b;
            b = sum;
        }
        return b;
    }

}