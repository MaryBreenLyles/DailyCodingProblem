/*
-------------------------------------------------------
 Question
-------------------------------------------------------
Given the root to a binary tree, implement serialize(root), which serializes the tree into a 
string, and deserialize(s), which deserializes the string back into the tree.

-------------------------------------------------------
 Algorithm Explanation 
-------------------------------------------------------
Basic Idea: We walk the tree using recursion, and build a string representation. The string
uses 'null' to denote a leaf. Below is a picture of a tree and its equivalent representation. 

                    1                           1,                     
                  /   \                            2,
                 2     3                              4,
                / \    /                                 null,
               4   5  7                                  null,
                    \                                 5,
                     6                                   null,
                                                         6,
                                                            null,
                                                            null,
                                                    3,
                                                        7,
                                                            null,
                                                            null,
                                                        null

We can use a similar recursive approach to build the tree again
from the string.

-------------------------------------------------------
 Revisions
-------------------------------------------------------
- Actually made seralize return an answer rather than using static
- Demonstrating method overloading by naming the two seralize and deserailze methods the same
- Utilized string builder to reduce complexity by O(answer.length) for each string append
- Changed the seralize base case to a leaf node, and the unit of work to seralize left seralize right.

*/

import java.util.Queue;
import java.util.LinkedList;
import java.lang.StringBuilder;

public class Problem3 {
    

    //UTILITY METHODS////////////////////

    //Basic Node Class
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

    //Builds a test tree with the Node Class
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

    //Turn a string into a queue, splitting the string into elements based on the delimiter
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
    
    //MAIN METHODS////////////////////

    public static String emptyMarker = "null";

    //Setup for seralization; defines the answer variable and kicks off the recursion 
    public static String seralize(Node node){
        StringBuilder answer = new StringBuilder("");
        return seralize(node, answer).toString();
    }

    //Recursivley creates a string representing the passed in Tree
    public static StringBuilder seralize(Node node, StringBuilder answer){
        
        //If at leaf, add null
        if (node == null){
            answer.append(emptyMarker + ",");
            return answer;
        }
        
        answer.append(node.val + ",");         // Add current nodes value to the answer
        answer = seralize(node.left, answer);  // Seralize the left subtree
        answer = seralize(node.right, answer); // Seralize the right subtree
        
        //Climb back up the tree
        return answer;
    }

    //Setup for deserialization; converts the string into a queue and kicks of the recursion
    public static Node deserialize(String answer){
        Queue<String> queueAns = stringToQueue(answer, ',');
        return deserialize(queueAns);
    }

    //Recursivley creates a tree from a string representation 
    public static Node deserialize(Queue<String> queueAns){
        
        String curr = queueAns.remove();

        // if reach the "null" string, return/make the child null
        if(curr.equals("null")){
            return null;
        }
        // Otherwise, create a new node with the current value
        // and recurse to create the left and right subtrees 
        else{
            return new Node(curr, deserialize(queueAns), deserialize(queueAns));
        }
        
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
