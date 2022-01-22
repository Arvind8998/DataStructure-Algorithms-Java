import java.util.*;

public class Main {

  // ~~~~~~~~~~~~User Section~~~~~~~~~~~~
   public static List<List<Integer>> twoSum(int si, int ei, int[] nums, int targ) {
      List<List<Integer>> res = new ArrayList<>();
      int left = si;
      int right = ei;
      
      while(left< right){
          if(left!=si && nums[left] == nums[left-1]){
              left++;
              continue;
          } 
          
          int sum = nums[left]+ nums[right];
          if(sum == targ){
              List<Integer> subres = new ArrayList<>();
              subres.add(nums[left]);
              subres.add(nums[right]);
              res.add(subres);
              left++;
              right--;
          }
          else if(sum > targ){
              right--;
          }
          else{
              left++;
          }
      }
    return res;
  }
  
  public static List<List<Integer>> threeSum(int[] nums, int targ) {
      List<List<Integer>> res = new ArrayList<>();
      
      int n = nums.length;
      if(n<3) return res;
      
      Arrays.sort(nums);
      
    for(int i=0; i<=n-3; i++){
        if(i!=0 && nums[i] == nums[i-1]){
            continue;
        } 

        List<List<Integer>> pairList = twoSum(i+1, n-1, nums, targ-nums[i]);
        
        for(List<Integer> list: pairList){
            list.add(nums[i]);
            res.add(list);
        }
    }
    return res;
  }

  // ~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    List<List<Integer>> res = threeSum(arr, target);
    ArrayList<String> finalResult = new ArrayList<>();
    for (List<Integer> list : res) {
      Collections.sort(list);
      String ans = "";
      for (int val : list) {
        ans += val + " ";
      }
      finalResult.add(ans);
    }
    Collections.sort(finalResult);
    for (String str : finalResult) {
      System.out.println(str);
    }
  }

}