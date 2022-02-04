class Solution {
    
    public void reverse(int []arr, int si, int ei){
      while(si < ei){
          int temp = arr[si];
          arr[si] = arr[ei];
          arr[ei] = temp;
          si++; ei--;
      }
  }
  
  public List<Integer> pancakeSort(int[] arr) {
      int n = arr.length;
      int maxIdx = 0;
      
      List<Integer> ans = new ArrayList<>();
      for (int i = n-1; i >= 0; i--) {
          maxIdx = i;
          
          for (int j = i - 1; j >= 0; j--){
                maxIdx = arr[maxIdx] < arr[j] ? j : maxIdx;
          } 
              if (maxIdx != i) {
                  reverse(arr, 0, maxIdx);
                  ans.add(maxIdx + 1);
                  reverse(arr, 0, i);
                  ans.add(i + 1);
              }
      }
      return ans;
  }


}