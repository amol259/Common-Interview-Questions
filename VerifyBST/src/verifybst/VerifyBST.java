/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verifybst;

import java.util.Stack;

/**
 *
 * @author amolsidhu
 */
public class VerifyBST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    private static class NodeBounds{
        BinaryTreeNode node;
        int lowerBound;
        int upperBound;
        
        NodeBounds(BinaryTreeNode node, int lowerBound, int upperBound){
            this.node=node;
            this.lowerBound=lowerBound;
            this.upperBound=upperBound;
        }
    
    }
    
    public static boolean isBST(BinaryTreeNode root){
        //start with a super low lowerbound and super high upperBound
        
        Stack<NodeBounds> nodeAndBoundsStack= new Stack<>();
            nodeAndBoundsStack.push(new NodeBounds(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

            //depth first traversal
            while(!nodeAndBoundsStack.empty()){
                NodeBounds nb= nodeAndBoundsStack.pop();
                BinaryTreeNode node = nb.node;
                int lowerBound= nb.lowerBound;
                int upperBound= nb.upperBound;
                //if the node is invalid, return false right away
                if(node.value <= lowerBound || node.value >= upperBound){return false;}
                
                if(node.left!=null){
                    //this node must be less than current
                    nodeAndBoundsStack.push(new NodeBounds(node.left, lowerBound, node.value));
                    
                }
               if(node.right!=null){
                   //this node must be bigger than current
                   nodeAndBoundsStack.push(new NodeBounds(node.right, node.value, upperBound));
                   
               }
            }
            
            //if none of the nodes were invalid return tr
                
        
    return true;
    }

    
    
    public static class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode insertLeft(int leftValue) {
        this.left = new BinaryTreeNode(leftValue);
        return this.left;
    }

    public BinaryTreeNode insertRight(int rightValue) {
        this.right = new BinaryTreeNode(rightValue);
        return this.right;
    }
}
    
}
