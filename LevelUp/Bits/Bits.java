
class Bits {
    
    public void offtoOn(int n, int k){
        int mask = (1 << k);
        n |= mask;
        System.out.print(n);
    }

    public void onToOff(int n, int k){
        int mask = 1<<k;
        n &= (~mask);
        System.out.println(n);
    }

    public static int countSetBits(int n){
        int count = 0;
        for(int i=0; i<32; i++){
            int mask = (1<<i);
            if( (mask & n) != 0) count++;
        }
        return count;
    }

    public static int countSetBits02(int n){
        int count = 0;
        while(n !=0){
            if((n & 1) !=0){
                count ++;
                n >>>= 1;
            }
        }
        return count;
    }

    public static int countSetBits03(int n){
        int count = 0;
        while(n !=0){
           n &= (n-1);
            count ++;
            }
        return count;
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0; 
    }

    public boolean isPowerofFour(int n){
        if(n <=0 || (n & (n-1)) != 0) // if not a power of 2 it will not be power of 4;
            return false; 
        
        int count = 0; // triple right shift drop 1 bit from right 
        while(n !=1){
            count ++;
            n >>>= 1;
        }
        return (count & 1) == 0; // check if even , lsb of even is 0 
    }
    
}