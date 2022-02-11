class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] rightMin = new int[n + 1];

        rightMin[n] = (int) 1e9;

        int leftMaxEl = -(int) 1e9;

        // right min element
        for (int i = n - 1; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }

        for (int el : rightMin)
            System.out.print(el + ",");

        int ans = 0;

        // comparing left max element && return i+1 for no of element
        for (int i = 0; i < n; i++) {
            leftMaxEl = Math.max(leftMaxEl, nums[i]);

            if (leftMaxEl <= rightMin[i + 1]) {
                ans = i;
                break;
            }
        }
        return ans + 1;
    }
}


// class Solution {
//     public int partitionDisjoint(int[] nums) {
//         int n = nums.length;
//         int greater = nums[0], leftMax = nums[0], ans = 0;
     
//     for(int i=1; i<n; i++){
//         if( nums[i] > greater){
//             greater = nums[i];
//         }
//          else if(nums[i] < leftMax){
//             leftMax = greater;
//             ans = i;
//         }
//     }
//         return ans+1;
        
//     }
// }