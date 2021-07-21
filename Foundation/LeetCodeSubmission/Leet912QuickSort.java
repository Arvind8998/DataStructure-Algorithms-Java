class Solution {
    
    public void swap(int[] arr, int si, int ei){
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }
    
    public int partition(int[] arr, int si, int ei, int pIdx){
        int p = si-1, itr = si;
         swap(arr, si, pIdx);
        while(itr <= ei){
            if(arr[itr] <= arr[pIdx]){
                swap(arr, itr, ++p);
            }
            itr++;
        }
        return p;
    }
    
    public void quickSort(int[] arr, int si, int ei){
        
        if(si > ei) return;
        
        int pIdx = ei;
        
        int p = partition(arr, si, ei, pIdx);
        quickSort(arr, si, p-1);
        quickSort(arr, p+1, ei);
    }
    
    
    
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n-1);
        return nums;
        
    }
}