import java.util.Arrays;

class Solution {
    public String largestMultipleOfThree(int[] digits) {
        String ans = "";
        int n = digits.length - 1;

        int sum = 0;

        for (int i = 0; i <= n; i++) {
            sum += digits[i];
        }

        Arrays.sort(digits);

        if (sum % 3 == 0) {
            if (digits[n] == 0)
                return "0";
            String s = "";
            for (int i = n; i >= 0; i--) {
                s += "" + (digits[i]);
            }
            return s;
        } else if (sum % 3 == 1) {
            boolean idealnumFound = false;
            for (int i = 0; i <= n; i++) {
                if (digits[i] % 3 == 1) {
                    digits[i] = -1;
                    idealnumFound = true;
                    break;
                }
            }
            if (!idealnumFound) {
                int[] indexArr = new int[2];
                indexArr[0] = -1;
                indexArr[1] = -1;

                for (int i = 0; i <= n; i++) {
                    if (digits[i] % 3 == 2) {
                        if (indexArr[0] == -1) {
                            indexArr[0] = i;
                        } else {
                            indexArr[1] = i;
                            break;
                        }
                    }
                }

                if (indexArr[1] != -1) {
                    digits[indexArr[0]] = -1;
                    digits[indexArr[1]] = -1;
                } else {
                    return "";
                }
            }
        }

        else {
            boolean idealnumFound = false;
            for (int i = 0; i <= n; i++) {
                if (digits[i] % 3 == 2) {
                    digits[i] = -1;
                    idealnumFound = true;
                    break;
                }
            }
            if (!idealnumFound) {
                int[] indexArr = new int[2];
                indexArr[0] = -1;
                indexArr[1] = -1;

                for (int i = n; i >= 0; i--) {
                    if (digits[i] % 3 == 1) {
                        if (indexArr[0] == -1) {
                            indexArr[0] = i;
                        } else {
                            indexArr[1] = i;
                            break;
                        }
                    }
                }

                if (indexArr[1] != -1) {
                    digits[indexArr[0]] = -1;
                    digits[indexArr[1]] = -1;
                } else {
                    return "";
                }
            }
        }
        if (digits[n] == 0) {
            return "0";
        }
        for (int i = n; i >= 0; i--) {
            if (digits[i] != -1) {
                ans += "" + digits[i];
            }
        }

        if(ans != "" && ans.charAt(0) == '0'){
            return "0";
        }

        return ans;
    }
}