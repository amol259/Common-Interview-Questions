/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverselinkedlist;

/**
 *
 * @author amolsidhu
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static class LinkedListNode{
        private LinkedListNode next;
        int value;
        
        public LinkedListNode(int value){
            this.value=value;
        }
    }
    
 private LinkedListNode reverseLinkedList(LinkedListNode head){
       
     //3 nodes
        LinkedListNode current= head;
        LinkedListNode next= null;
        LinkedListNode prev= null;
        
        //iterate through list 
        
        while(current.next!=null){
            //need a copy of the next node
            next = current.next;
            
            //move current.next ptr to be previosu
           current.next = prev;
            
            //now move forward
            prev= current;
            current = next;
            
            
            
        }
        return prev;
    }
    
 
    public LinkedListNode findKthToLastNode(int key, LinkedListNode head){
        
        int listSize=1;
        LinkedListNode current=head;
       
        while(current.next!=null){
            current=current.next;
            listSize+=1;
            
        }
           
        int howFarToGo= listSize-key;
        
        //reset current
        
        current= head;
        //now travel to that node
        for(int i=0; i<=howFarToGo;i++){
            current=current.next;
        }
        return current;
        
    }
    
    public LinkedListNode deleteNode(LinkedListNode Node){
        LinkedListNode current= Node;
        LinkedListNode next =Node.next;
        
        //need to tranfer the data from next node to current node
        if(next!=null){
        current.value=next.value;
        current.next=next;
                
        }
            return current;    
    }
    
    
    
}
