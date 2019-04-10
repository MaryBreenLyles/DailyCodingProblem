import java.util.Queue;
import java.util.LinkedList;
import java.lang.Math.*;

public class Problem8 {
    
    public static class Node {
        
        public int val;
        public Node left;
        public Node right;
        
        public Node(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    
    // Turns Tree into a string delimited with commas
    public static int isUnival(Node node){
        
        int countLeftUnival = 0;
        int countRightUnival = 0;
        
        if (node == null){
            return 0;
        }        
    
        countLeftUnival = isUnival(node.left);
        countRightUnival = isUnival(node.right);
        
        boolean lIsUnival = (countLeftUnival >= 0);
        boolean rIsUnival = (countRightUnival >= 0);
        int totalUniVals = Math.abs(countLeftUnival) + Math.abs(countRightUnival);
        
        if (rIsUnival && lIsUnival && (node.right == null || node.right.val == node.val) 
                                   &&  (node.left == null || node.left.val == node.val)){
            return totalUniVals+1;
        }

        return totalUniVals;
        
    }


    // Build a little test guy
    public static Node makeTestTree1(){
        
        return new Node(0,
            new Node(0, 
                new Node(0, null, null),
                new Node(0, null, 
                    new Node(1, null, null))
                ),
            new Node(0, new Node(1, null, null), null)
        );

    }
    
    // Build a little test guy
    public static Node makeTestTree2(){
        
        return new Node(0,
            new Node(0, 
                new Node(0, null, null),
                new Node(0, null, 
                    new Node(0, null, null))
                ),
            new Node(0, new Node(0, null, null), null)
        );

    }
       
    
    
    public static void main(String args[]) {
     
        System.out.println(isUnival(makeTestTree1()));
        System.out.println(isUnival(makeTestTree2()));
        
    }
    
    
}
