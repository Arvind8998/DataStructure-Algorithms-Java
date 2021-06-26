class Solution {
    
    public static int decimalToAnyBase(int n, int b){
        int ans =0;
        int pow=1;
        
        while(n !=0){
            int rem = n%b;
            n = n/b;
            
            ans += rem*pow;
            pow *= 10;
        }
        return ans;
    }
    
    public String baseNeg2(int n) {
        int ans = decimalToAnyBase(n, Math.abs(-2));
        String s = Integer.toString(ans); 
        return s;
    }
}