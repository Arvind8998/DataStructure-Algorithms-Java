class Solution {

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'A') {
            return true;
        } else if (c == 'e' || c == 'E') {
            return true;
        } else if (c == 'i' || c == 'I') {
            return true;
        } else if (c == 'o' || c == 'O') {
            return true;
        } else if (c == 'u' || c == 'U') {
            return true;
        } else {
            return false;
        }
    }

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (isVowel(arr[i]) && isVowel(arr[j])) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            } else if (isVowel(arr[i])) {
                j--;
            } else if (isVowel(arr[j])) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return new String(arr);

    }
}