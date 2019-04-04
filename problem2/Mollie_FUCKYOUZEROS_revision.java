import java.util.Arrays;

public class ICanDoThings_ProdNoti{

     public static void main(String []args){
       
      
        int [] A = {3,2,1,0};
        
        
        for(int i=0; i<A.length; i++){
            System.out.println(prodNoti_MASTER_OF_ZEROS(A)[i]);
        }
        
     
        
     }
     
     
     //3 Can take zero in A (BETTER)
     
     // If one zero is present, all other indices in output will
     // contain 0, except for the index of original Array that contained 
     // the zero
     
     // Also, if more than one zero is present, all entries in output are zero
     
    static int [] prodNoti_MASTER_OF_ZEROS(int [] A){
         
         int prod = 1;
         int [] B = new int[A.length];
         
         
         // CHECK FOR THOSE PROGRAM-BREAKING ZERO BASTARDS
         int zeroCount = 0;
         for(int i=0; i<A.length; i++){
             
             if ( A[i]==0 ){
                 zeroCount++;
                 continue;
             }
         }
         
         
         // FOR THE NONZERO GOOD TIMES
         if (zeroCount==0){
             
             for(int i=0; i<A.length; i++){
                 prod = prod*A[i];
             }
         
             for(int i=0; i<A.length; i++){
                 B[i] = prod/A[i]; 
             }
             
         }
         
         
         // FOR THE SINGLE ZERO TIMES
         else if (zeroCount==1){
             
             for(int i=0; i<A.length; i++){
                 
                 if(A[i]==0){
                     continue;
                 }
                 else{
                     prod = prod*A[i];
                 }
             }
             
             for(int i=0; i<A.length; i++){
             
                 if (A[i]!=0){
                     B[i] = 0;
                 }
                 else{
                     B[i] = prod;
                 }
             }
         }
         
         
         // FOR THE MULTI FUCKIN ZERO TIMEZZZZ
         else{
             
             for(int i=0; i<A.length; i++){
                 B[i] = 0;
             }
         }
         
         
         return B;
     }
     
     
