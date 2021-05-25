class Solution {
    
    public static int convertAnyBaseToDecimal(int n, int b){
        int ans = 0;
        int pow = 1;
        
        while(n!= 0){
            int rem = n %10;
             n = n/10;
            
            ans += rem *pow;
            pow *= b;
        }
        return ans;
        }
    
    public static int convertDecimalToAnyBase(int n, int b){
        int ans = 0;
        int pow = 1;
        
        while(n!= 0){
            int rem = n %b;
             n = n/b;
            
            ans += rem *pow;
            pow *= 10;
        }
        return ans;
    }
    
    public String convertToBase7(int num) {
        int decimalNo = convertAnyBaseToDecimal(num, 10);
        int ans =  convertDecimalToAnyBase(decimalNo, 7);
        String s = Integer.toString(ans); 
        return s;
    }
}