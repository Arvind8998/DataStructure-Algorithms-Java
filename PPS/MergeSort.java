public class MergeSort{

    public static int[] merge2SortedArrays(int[] left, int[] right){

        if(left.length == 0 || right.length ==0){
            return left.length == 0 ? right : left;
        }

        int n = left.length-1, m =right.length-1;
        
        int k = n+m;
        int [] ans = new int[k];

        int i=0, j=0;

        while(i<=n && j<=m ){
            if(left[i] <= right[j]){
                ans[k++] = left[i++];
            }
            else{
                ans[k++] = right[j++];
            }
        }

        while(i<=n){
            ans[k++]= left[i++];
        }

        while(j<=n){
            ans[k++] = right[j++];
        }
        
        return ans;
    }


    public static int[] mergeSort(int[] arr, int si, int ei){
        if(si >= ei){
            return new int[] {arr[si]};
        }

        int mid = (si+ei)/2;
        int[] left = mergeSort(arr, si, mid);
        int[] right = mergeSort(arr, mid+1, ei);

        merge2SortedArrays(left, right);
    }


    public static void main(String[] args) {
        int[] arr = {5,3,2,1};
        arr = mergeSort(arr,0,arr.length-1);
    }
}
