class Solution {

    public void swap(int si, int ei, char[] arr) {
        char temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }

    public int maximumSwap(int num) {

        String number = String.valueOf(num);
        char[] arr = number.toCharArray();
        int n = arr.length;
        int[] lastIdxDigits = new int[10];

        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i] - '0';
            lastIdxDigits[digit] = i;
        }

        boolean isSwapped = false;
        for (int i = 0; i < n; i++) {
            int currDigit = arr[i] - '0';
            for (int j = 9; j > currDigit; j--) {
                if (i < lastIdxDigits[j]) {
                    swap(i, lastIdxDigits[j], arr);
                    isSwapped = true;
                    break;
                }
            }
            if (isSwapped == true)
                break;
        }

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res *= 10;
            res += arr[i] - '0';
        }
        return res;
    }
}