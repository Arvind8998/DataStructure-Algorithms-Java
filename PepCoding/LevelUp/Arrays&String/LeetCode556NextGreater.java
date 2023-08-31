class Solution {
    public int nextGreaterElement(int n) {
        char[] charArr = Integer.toString(n).toCharArray();

        int i = charArr.length - 2;

        while (i >= 0 && charArr[i] >= charArr[i + 1]) {
            i--;
        }
        if (i == -1)
            return -1;

        // find just greater than ith element
        int k = charArr.length - 1;

        while (charArr[i] >= charArr[k]) {
            k--;
        }

        // swap k & i
        char temp = charArr[i];
        charArr[i] = charArr[k];
        charArr[k] = temp;

        String res = "";

        // concatenate from 0 to i
        for (int j = 0; j <= i; j++) {
            res += charArr[j];
        }

        // concatinate from k to i+1
        for (int j = charArr.length - 1; j > i; j--) {
            res += charArr[j];
        }
        return Integer.parseInt(res);
    }
}