import java.util.Queue;
import java.util.LinkedList;

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
    
    static int count = 0;
    
    // Turns Tree into a string delimited with commas
    public static boolean isUnival(Node node){
        
        boolean rIsUnival = false;
        boolean lIsUnival = false;
        
        if (node == null){
            return true;
        }        
    
        lIsUnival = isUnival(node.left);
        rIsUnival = isUnival(node.right);
        
        if (rIsUnival && lIsUnival && (node.right == null || node.right.val == node.val) && (node.left == null || node.left.val == node.val)){
            count++;
            return true;
        }

        return false;
        
    }


    // Build a little test guy
    public static Node makeTestTree(){
        
        return new Node(0,
            new Node(0, 
                new Node(0, null, null),
                new Node(0, null, 
                    new Node(0, null, null))
                ),
            new Node(0, new Node(1, null, null), null)
        );

    }
       
    
    
    public static void main(String args[]) {
     
        isUnival(makeTestTree());
        System.out.println(count);
        
    }
    
    
}
