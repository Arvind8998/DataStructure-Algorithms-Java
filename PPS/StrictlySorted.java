import java.util.Scanner;

public class StrictlySorted {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);	      
	    //System.out.println("plz enter the size of array");
	    int z=sc.nextInt();
	    int[] A=new int[z];
	      for(int i=0; i<z; i++)
	      {
	    	  A[i]=sc.nextInt();
	      }
	    int counter = 0;
	  
	    int j = -1;
	    
	    int n=A.length;
	   
	  
	    for(int i = 1; i < n; i++) 
	    {
	        if (A[i - 1] >= A[i])
	        {
	              
	            counter++;
	            
	            j = i;
	        }
	    }
	  
	    
	    if (counter > 1) {
	    	System.out.println("No Solution Exists!");
	    	
	    }
	   
	    else if (counter == 0) {
	    	System.out.println("Array is OK. No removed value");
	       
	    }
	    else if (j == n - 1) {
	    	System.out.println("Array is OK. Removed value "+ A[j] +" at index "+ (j));
	    }
	    else if (j == 1) {
	    	System.out.println("Array is OK. Removed value "+ A[j-1] +" at index "+ (j-1));
	        
	    }
	    else if((A[j-1]==A[j+1])&&(A[j]==A[j-2])) {
	    	System.out.println("No Solution Exists!");
	    }
	    else if((A[j-1]==A[j+1])) {
	    	System.out.println("Array is OK. Removed value "+ A[j-1] +" at index "+ (j-1));
	    }
	  
	    else if (A[j - 1] < A[j + 1]) {
	    	System.out.println("Array is OK. Removed value "+ A[j] +" at index "+ j);
	       
	    }
	   
	    else if (j - 2 >= 0 && A[j - 2] < A[j]) {
	    	System.out.println("Array is OK. Removed value "+ A[j] +" at index "+ j);
	       
	    }
	      
	    else if(j < 0) {
	    	  System.out.println("Array is OK. No removed value");
	          
	      }
	    else {
	    	System.out.println("No Solution Exists!");
	    }
	   
	}
	

}
