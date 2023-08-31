class Solution {
    public int numOfSubarrays(int[] arr) {
        int even=0,odd=0, sum=0;
        long ans=0;
        int mod = (int)1e9 + 7;

        for(int el: arr){
            sum += el;
            if(sum%2 ==0){
                even++;
                ans += odd;
            }
            else{
                odd++;
                ans += even+1;
            }
        }
        return (int)(ans%mod);
        
    }
}