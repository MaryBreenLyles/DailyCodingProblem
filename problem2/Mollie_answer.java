// 1) DIVISION - O(2n): Won't work for Array values of zero

// 2) NO DIVISION - O(n^2): Will work for Array vals of zero


import java.util.Arrays;

public class ICanDoThings_ProdNoti{

     public static void main(String []args){
       
      
        int [] A = {1, 2, 3, 4, 5, 0};
        
        
        for(int i=0; i<A.length; i++){
            System.out.println(prodNoti_canZero(A)[i]);
        }
        
     
        
     }
     
     
     // 1) Can't take zero in A (DIVISION)
     static int [] prodNoti_NoZero(int [] A){
         
         int prod = 1;
         int [] B = new int[A.length];
         
         for(int i=0; i<A.length; i++){
             prod = prod*A[i];
         }
         
         for(int i=0; i<A.length; i++){
             
                B[i] = prod/A[i]; 
         }
         
         return B;
     }
     
     
     // 2) Can take zero in A (NO DIVISION)
     static int [] prodNoti_canZero(int [] A){

         int [] B = new int[A.length];
         Arrays.fill(B, 1);
         
         
         for(int i=0; i<A.length; i++){
             for(int j=0; j<A.length; j++){
                 
                 if(j==i){
                    continue;
                 }
                 else{
                    B[i] = B[i]*A[j];
                 }
             }            
         }
         
         return B;
     }
     
     
}
