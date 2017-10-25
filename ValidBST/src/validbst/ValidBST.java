/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validbst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author amolsidhu
 */
public class ValidBST {

   
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    private static class NodeDepthPair{
        BinaryTreeNode node;
        int depth;
        NodeDepthPair(BinaryTreeNode node, int depth){
        this.node=node;
        this.depth=depth;
        }
    }
    public static boolean isBalanced(BinaryTreeNode treeRoot){
        //tree with no nodes is superbalances, since there are no leaves
        if(treeRoot==null){return true;}
        
        //We end as soon as we find more than 2
        List<Integer> depths= new ArrayList<>(3);
    
        //nodes will store pair of nodes and depth of nodes
        Stack<NodeDepthPair> nodes= new Stack<>();
        nodes.push(new NodeDepthPair(treeRoot, 0));
       
    while(!nodes.empty()){
    //peop node and its depth from stack
    NodeDepthPair nodeDepthPair=nodes.pop();
    BinaryTreeNode node= nodeDepthPair.node;
    int depth= nodeDepthPair.depth;
    
    //case: found a leaf
    if(node.left ==null && node.right ==null){
        //we only care to update it if this is a new depth
        if(!depths.contains(depth)){
            depths.add(depth); //add to arraylist
            //2 ways to have an unbalanced tree
          //  1. more than 2 different leaf depths
            //2. 2 leaf depths more than 1 apart
            
             if (depths.size() > 2 || (depths.size() == 2 
                        && Math.abs(depths.get(0) - depths.get(1)) > 1)) {
                    return false;  
                } 
        }
   
    }
    
    //case this is not a leaf so step down
    else{ if(node.left!=null){
        nodes.push(new NodeDepthPair(node.left,depth+1));
    } if(node.right!=null){
                nodes.push(new NodeDepthPair(node.right,depth+1));

    }
    
    }
    }
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
