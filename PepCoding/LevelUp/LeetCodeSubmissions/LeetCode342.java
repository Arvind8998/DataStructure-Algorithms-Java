package PepCoding.LevelUp.LeetCodeSubmissions;
//public boolean isPowerofFour(int n){
//    if(n <=0 || (n & (n-1)) != 0) // if not a power of 2 it will not be power of 4;
//        return false;
//
//    int count = 0; // triple right shift drop 1 bit from right
//    while(n !=1){
//        count ++;
//        n >>>= 1;
//    }
//    return (count & 1) == 0; // check if even , lsb of even is 0
//}