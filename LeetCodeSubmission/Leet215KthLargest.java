class Solution {
    
    public void swap(int[] arr, int si, int ei){
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }
    
    public int partition(int[] arr, int si, int ei, int pivot, int idx){

        int p = si-1, itr = si;
        swap(arr, pivot, ei);
        
        while(itr <= ei){
        if(arr[itr] <= arr[ei]){
            swap(arr, itr, ++p);    
        }
            itr++;
        }
        return p;
}

    public void quickSelect(int []arr, int si, int ei,int idx){
      if(si > ei) return;
        
        int pivot = ei;
        int pIdx = partition(arr, si, ei, pivot, idx);
        
        if(idx > pIdx){
            quickSelect(arr, pIdx+1, ei, idx);
        }
        else{
           quickSelect(arr, si, pIdx-1, idx); 
        }
    }
    
    public int quickSelect(int[] arr, int idx){
        quickSelect(arr, 0, arr.length-1, idx);
        return arr[idx];
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;        
        int idx = n-k;
        return quickSelect(nums, idx);
        
    }
}