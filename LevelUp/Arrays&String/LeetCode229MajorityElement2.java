import java.util.List;

class Solution {
    public boolean isGreaterThan3(int val, int[] nums) {
        int freq = 0;
        for (int num : nums) {
            if (num == val)
                freq++;
        }
        return freq > nums.length/3;
    }

    public List<Integer> majorityElement(int[] nums) {
        int count1 = 1, value1 = nums[0], count2 = 0, value2 = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == value1) {
                count1++;
            } else if (nums[i] == value2) {
                count2++;
            } else {
                if (count1 == 0) {
                        value1 = nums[i];
                        count1 = 1;
                }
            else if(count2 == 0){
                    value2 = nums[i];
                    count2 = 1;
                }
                else{
                    count1--;
                    count2--;
                }   
            }
        }

        List<Integer> res = new ArrayList<Integer>();

        if (isGreaterThan3(value1, nums)) {
            res.add(value1);
        }

        if (value1 != value2 && isGreaterThan3(value2, nums)) {
            res.add(value2);
        }
        return res;
    }
}