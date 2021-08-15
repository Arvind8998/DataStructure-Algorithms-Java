class Solution {
    public static boolean ksubsets(int[] arr, int idx, int[] subsetSum, ArrayList<ArrayList<Integer>> ans, int k) {
        if(idx == arr.length){
            int el = subsetSum[0];
            
            for(int i=1; i<subsetSum.length; i++){
                if(el != subsetSum[i]) return false;
            }
            return true;
        }
        
        boolean res = false;
        
        for(int i=0; i<k; i++){
            ArrayList<Integer> set = ans.get(i);
            set.add(arr[idx]);
            subsetSum[i] += arr[idx];
            
            res = res || ksubsets(arr, idx+1, subsetSum, ans, k);
            
            set.remove(set.size()-1);
            subsetSum[i] -= arr[idx];
            if(set.size() == 0) break;
        }
        return res;
    }
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] subsetSum = new int[k];
        
        for (int i = 0; i < k; i++)
            ans.add(new ArrayList<>());
        
        int sum = 0;
        for (int ele : nums)
            sum += ele;

        if (sum % k != 0)
            return false;
        
        return ksubsets(nums, 0, subsetSum, ans, k);
    }
}