import java.util.*;

class nGrams {
    public static Scanner scn = new Scanner(System.in);

  public static List<String> ngrams(int n, String str) {
    List<String> ngrams = new ArrayList<String>();
    for (int i = 0; i <= str.length() - n; i++)
        // Add the substring or size n
        ngrams.add(str.substring(i, i + n));
        // In each iteration, the window moves one step forward
        // Hence, each n-gram is added to the list

    return ngrams;
  }

//   public static int subsequence(String str, int idx, String asf, ArrayList<String> ans) {
//     if (idx == str.length()) {
//         ans.add(asf);
//         return 1;
//     }
//     int count = 0;
//     count += subsequence(str, idx + 1, asf, ans);
//     count += subsequence(str, idx + 1, asf + str.charAt(idx), ans);

//     return count;
// }

  public static void main( String args[] ) {
    // String str = "";
    // for(int i=0; i<3; i++){
    //     str += scn.nextLine();
    // }
    //   while(scn.hasNextLine()){
    //      String currentStr = scn.nextLine();
    //     if(currentStr == null || currentStr.isEmpty()){ //if the line is empty
    //         break;  //exit the loop
    //     }
    //     str += currentStr;
    //   }
    //   ArrayList<String> ans = new ArrayList<>();
    //   int count = subsequence("abcd", 0, "", ans);
    // System.out.println("Input is" + str);
    List<String> ngrams = ngrams(3, "abc");
      for (int i=0; i< ngrams.size(); i++ ){
        System.out.print("(" + ngrams.get(i) + ")");
      }
  }
}