class Solution {
    public int getPotentialRow(int[][] matrix, int target){
        int si=0;
        int ei = matrix.length-1;
        
        while(si <= ei){
            int pi = (si+ei)/2;
            int lc = matrix[pi].length-1;

            if(matrix[pi][0] <= target && target <= matrix[pi][lc]){
                return pi;
            }
            else if(matrix[pi][0] < target){
                si = pi+1;
            }
            else if(matrix[pi][0] > target){
                ei = pi-1;
            }
        }
        return -1;
    }

    public boolean search_target_binarySearch(int[] nums, int target ){
        int si=0;
        int ei = nums.length-1;
        while(si <=ei){
            int pi = (si + ei) /2;
            if(nums[pi] == target) return true;
            else if(nums[pi] < target) si = pi+1;
            else ei = pi-1;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = getPotentialRow(matrix, target);
        if(r == -1) return false;
        boolean found = search_target_binarySearch(matrix[r], target);
        return found;
    }
}