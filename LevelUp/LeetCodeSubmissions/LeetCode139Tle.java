class Solution {
    
    public boolean isStringPresent(String str, List<String> wordDict){
        if(str.length() == 0){
            return true;
        }
        
        boolean res = false;
        
         for(int i=0; i< str.length(); i++){
            String left = str.substring(0, i+1);
            if(wordDict.contains(left)){
                String right = str.substring(i+1);
                res = res || isStringPresent(right, wordDict);
            }
        }
        return res;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
       return isStringPresent(s, wordDict);
    }
}