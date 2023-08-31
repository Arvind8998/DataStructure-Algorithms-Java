package PepCoding.LevelUp.LeetCodeSubmissions;
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        boolean flag = false;
        int num = 0;
        int reverse = 0;
    
    for(int i=31; i>=0; i--){
            int mask = (1<< i);
            
            if(flag){
                if( (n & mask) != 0){
                    int smask = (1<< num);
                    reverse |= smask;
                }
                num++;
            }
            
            else{
                if( (n & mask) != 0){
                    flag = true;
                    System.out.print(1);
                    int smask = (1<< num);
                    reverse |= smask;
                    
                }
                num++;
                
            }
        }
        return reverse;
        
    }
}