class MinDeletionforSortedArrayGFG {
    public static int minDeletions(int arr[], int n) {
        int[] dp = new int[n];
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] >= arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(dp[i], maxLength);
        }
        for (int el : dp) {
            System.out.println(el + " ");
        }
        return arr.length - maxLength;
    }

    public static void main(String[] args) {
        int[] arr = { 1,1,1 };
        System.out.print(minDeletions(arr, 3));
    }
}