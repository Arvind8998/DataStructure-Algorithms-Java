class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        int n = nums.size();
        List<Integer> al = new ArrayList<Integer>();
            
        for(int gap = 0; gap<n; gap++){
            for(int i = gap, j=0; i>=0 && j<nums.get(i).size(); i--, j++){
                
               al.add(nums.get(i).get(j));
                System.out.print(nums.get(i).get(j) + " ");
            }
        }
        
        
        for(int gap = n; gap <nums.get(0).size()+n-1; gap++){
            
            for(int i = n-1, j=gap-i; i>=0 && j<nums.get(i).size(); i--, j++){
                
               al.add(nums.get(i).get(j));
                System.out.print(nums.get(i).get(j) + " ");
            }
        }
        int[] ans = new int[al.size()];
        // ans = al.toArray(ans);
        
        return new int[al.size()];
    }
}