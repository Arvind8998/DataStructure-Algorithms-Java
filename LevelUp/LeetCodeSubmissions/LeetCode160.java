/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode meetingPoint(ListNode head){
        if(head == null || head.next == null) return null;
        
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                return slow;
            }
        }
        return null;
    }
    
     public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode mp = meetingPoint(head);
        if(mp == null) return mp;
        
        ListNode slow = head, fast = mp;
        
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    } 
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode tail = headA;
        
        while(tail.next != null){
            tail = tail.next;
        }
        
        tail.next = headB;
        ListNode ip = detectCycle(headA);
        tail.next = null;
        
        return ip;
        
    }
}