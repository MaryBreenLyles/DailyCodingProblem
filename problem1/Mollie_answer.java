public class MolliesAnswersIsValid{

     public static void main(String []args){
    
        
        
        int [] A = {30, 40, 13, 12, 50, 2, 13, 14, 22};
        
        int k = 24;
        
        if(isSumK(A, k) == true){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }  
        
        
     }
     
     
     
     
     static boolean isSumK(int [] A, int k) {
         for(int i=0; i<A.length; i++) {
             if( A[i] >= k ){
                 continue;
             }
             else{
                 for(int j=i+1; j<A.length; j++){
                     if( A[i]+A[j]==k ){
                         return true;
                     }
                 }
             }
         }
         
         return false;
         
     }
     
    
     
     
}
