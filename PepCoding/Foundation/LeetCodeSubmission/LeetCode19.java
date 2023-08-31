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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode fast = head, slow = head;

      while(n-- > 0) fast = fast.next;

      if(fast == null){
          ListNode rNode = slow;
          head = rNode.next;
          rNode.next = null;
          return head;
      }

      while(fast.next != null){
          slow = slow.next;
          fast = fast.next;
      }

      ListNode rNode = slow.next;
      slow.next = rNode.next;
      rNode.next = null;
      return head;
    }
}