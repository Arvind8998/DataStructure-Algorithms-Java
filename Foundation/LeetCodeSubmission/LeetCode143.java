/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode getMiddleNode(ListNode node){
        ListNode slow = node, fast = node;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
     }
    
    public ListNode reverseLinkedList(ListNode head){
        ListNode prev = null, curr = head;
        
        while(curr != null){
            ListNode forw = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            curr = forw;
        }
        return prev;
    }
    
    public void reorderList(ListNode head) {
            if(head == null || head.next == null){
                System.out.print("[");
                System.out.print(head.val);
                System.out.print("]");
                
            } 
            ListNode middleNode = getMiddleNode(head);
            ListNode nHead = middleNode.next;
            middleNode.next = null;
        
            nHead = reverseLinkedList(nHead);
        
            ListNode c1 = head;
            ListNode c2 = nHead;
        
        while(c2 != null){
            ListNode f1 = c1.next, f2 = c2.next;
           
            c1.next = c2;
            c2.next = f1;
            
            c1 = f1;
            c2 = f2;
        }

        System.out.print("[");
        while(head != null){
        System.out.print(head.val);
            if(head.next != null)
                System.out.print(",");
            head =  head.next;
        }
        System.out.print("]");
        
    }
}