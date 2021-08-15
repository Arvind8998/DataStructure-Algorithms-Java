import java.util.ArrayList;
import java.util.List;
class Solution {
    public void isStringPresent(String str, String ans, List<String> wordDict, List<String> res){
        if(str.length() == 0){
            res.add(ans);
            return;
        }
        
         for(int i=0; i< str.length(); i++){
            String left = str.substring(0, i+1);
            if(wordDict.contains(left)){
                String right = str.substring(i+1);
                isStringPresent(right, ans + (right.length() != 0 ? left + " " : left), wordDict, res);
            }
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        isStringPresent(s, "", wordDict, res);
        return res;
    }
}