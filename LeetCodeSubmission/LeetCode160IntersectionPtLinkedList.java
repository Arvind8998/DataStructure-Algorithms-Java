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

    public int lengthOfLL(ListNode node){
    int len = 0;
        while(node != null){
        node = node.next;
            len++;
    }
        return len;
        
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = lengthOfLL(headA);
        int b = lengthOfLL(headB);
        
        ListNode biggerNode = a >= b ? headA : headB;
        ListNode smallerNode = a < b ? headA : headB;
        
    
    int diff = Math.abs(a-b);
    
    while(diff-- > 0){
    biggerNode = biggerNode.next;
    }
    
    while(biggerNode != smallerNode){
        biggerNode = biggerNode.next;
        smallerNode = smallerNode.next;
    }
    return biggerNode;

}
}
