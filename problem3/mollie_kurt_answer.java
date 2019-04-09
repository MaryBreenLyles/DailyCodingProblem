import java.util.Queue;
import java.util.LinkedList;

public class Problem3 {
    
    public static class Node {
        
        public String val;
        public Node left;
        public Node right;
        
        public Node(String val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    static String answer = "";
    
    // Turns Tree into a string delimited with commas
    public static String seralize(Node node){
        
        answer += node.val + ","; // append strings to answer

        // recurse to left node or append null        
        if (node.left != null){
            seralize(node.left);
        }else {
            answer += "null" + ",";
        }
        
        // recurse to right node or append null
        if (node.right != null){
            seralize(node.right);
        }else {
            answer += "null" + ",";
        }
        
        // if you reach the end of a branch, return (goes back to do
        // next child)
        if (node.left == null && node.right == null){
            return answer;
        }
        
        // return the final string
        return answer;
    }

    // 1) Turn string into Queue
    public static Queue<String> stringToQueue(String str, char delimiter){
        
        char[] charArray = str.toCharArray();
        String curWord = "";
        Queue<String> queueAns = new LinkedList<String>();
        
        for (int i = 0; i < charArray.length; i++){
            if (charArray[i] != delimiter){
                curWord += charArray[i] ;
            }else{
                queueAns.add(curWord);
                curWord = "";
            }
        }
        
        return queueAns;
    }

    // 2) Turn Queue into Node
    public static Node desHelp(Queue<String> queueAns){
        
        String curr = queueAns.remove();

        // if reach the "null" string, return/make the child null
        if(curr.equals("null")){
            return null;
        }
        // recurse to make left and right children
        else{
            return new Node(curr, desHelp(queueAns), desHelp(queueAns));
        }
        
    }
        
    // 3) Turn String into Tree
    public static Node deserialize(String answer){
        Queue<String> queueAns = stringToQueue(answer, ',');
        
        return desHelp(queueAns);
    }


    // Build a little test guy
    public static Node makeTestTree(){
        
        return new Node("1",
            new Node("2", 
                new Node("4", null, null),
                new Node("5", null, 
                    new Node("6", null, null))
                ),
            new Node("3", new Node("7", null, null), null)
        );

    }
       
    
    
    public static void main(String args[]) {
     
        //Node testTree = makeTestTree();
        //seralize(testTree);
        //System.out.println("Tree Seralized: " + answer);
        //Node tree = deserialize(answer);
        
        boolean thisWorks = deserialize(seralize(makeTestTree())).left.left.val.equals("4");
        System.out.println(thisWorks);
        
    }
    
    
}
