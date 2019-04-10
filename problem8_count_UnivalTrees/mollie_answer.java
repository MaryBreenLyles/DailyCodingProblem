public class Problem8_Unival{

// Make node constructor
public static class Node {
        
        public int val;
        public Node left;
        public Node right;
        
        public Node(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }


// For every subtree visited, return true if subtree rooted under it is
// single valued and increment count. So the idea is to use count as a
// reference parameter in recursive calls and use returned values to find
// out if left and right subtrees are single valued or not.

/*
    Use a boolean, and static counter
    What would it take to solve the simplest case: one node
        - Check left/right are null or Unival Tree => then I'm a unitree too
        - Left and Right subtrees must both be unitrees for me to be unitree
        - 2 if statements:
            - If at a null node, return true (move out of that stackframe, 
              return to prev frame)
            - When all the above are true, return true and count ++
            
                    ROOT
                   /    \
         [LEFT BOX]     [RIGHT BOX]
*/

public static class UnivalInfo{
    
    public Node node; 
    public int count;
    
    public UnivalInfo(Node node){
        this.node = node;
    }
    
    public boolean isUnival(Node node){
    
        if (node==null){
            return true;
        }
        
        boolean isLeftUni = isUnival(node.left);
        boolean isRightUni = isUnival(node.right);
        
        if (isLeftUni && isRightUni 
            && (node.left==null || node.left.val==node.val) 
            && (node.right==null || node.right.val==node.val)){
            count ++;
            return true;
        }
        
        else{
            return false;
        }
    }
}


    // Build a little test guy
    public static Node makeTestTree(){
         
         Node Tree = new Node(1);
         Tree.left = new Node(1);
         Tree.right = new Node(1);
         Tree.right.right = new Node(0);
         Tree.right.left = new Node(0);
         Tree.right.left.left = new Node(0);
         Tree.right.left.right = new Node(0);
         
         // should be 5
         
         return Tree;   
    }



     public static void main(String []args){
        
        Node myTree = makeTestTree();
        
        UnivalInfo uniInf = new UnivalInfo(myTree);
        
        uniInf.isUnival(myTree);
        
        
        // Will return 5
        System.out.println(uniInf.count);
        
    
     }
    
     
}

