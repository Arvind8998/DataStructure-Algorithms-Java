class Solution {
    
    public void getSubsetCombinations2(List<List<Integer>> ans, ArrayList<Integer> subset, int[] nums, int idx){
       ans.add(new ArrayList<>(subset));
        int prev = -11;
       for(int i=idx; i<nums.length; i++){
           if(prev != nums[i]){
               subset.add(nums[i]);
               getSubsetCombinations2(ans, subset, nums, i+1);
               prev = nums[i];
               subset.remove(subset.size()-1);
           }
          
       }
   }
   
   public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
       ArrayList<Integer> subset = new ArrayList<>();
       Arrays.sort(nums);
       getSubsetCombinations2(ans, subset, nums, 0);
       return ans;
   }
}