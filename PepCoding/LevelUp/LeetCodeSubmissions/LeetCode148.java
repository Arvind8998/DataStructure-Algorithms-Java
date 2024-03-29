package PepCoding.LevelUp.LeetCodeSubmissions;
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
    public static int getLength(ListNode head){
       if(head == null) return 0;

       int len = 0;

       ListNode curr = head;
       while(curr !=null){
           curr = curr.next;
           len ++;
       }
       return len;
   }

   public static ListNode[] getSegregateNodes(ListNode head, int pivotIdx){
       if (head == null || head.next == null)
       return new ListNode[] { null, head, null };

   ListNode pivotNode = head;
   while (pivotIdx-- > 0)
       pivotNode = pivotNode.next;

   ListNode smaller = new ListNode(-1), larger = new ListNode(-1), sp = smaller, lp = larger, curr = head;
   while (curr != null) {
       if (curr != pivotNode && curr.val <= pivotNode.val) {
           sp.next = curr;
           sp = sp.next;
       } else if (curr != pivotNode) {
           lp.next = curr;
           lp = lp.next;
       }

       curr = curr.next;
   }

   sp.next = lp.next = pivotNode.next = null;

   return new ListNode[] { smaller.next, pivotNode, larger.next };
   }

   public static ListNode[] mergeLinkedLists(ListNode[] left, ListNode pivotNode, ListNode[] right){
       ListNode fh = null, ft = null;
       if (left[0] != null && right[0] != null) {
           fh = left[0];
           left[1].next = pivotNode;
           pivotNode.next = right[0];
           ft = right[1];
       } else if (left[0] == null && right[0] == null) {
           fh = ft = pivotNode;
       } else if (left[0] == null) {
           fh = pivotNode;
           pivotNode.next = right[0];
           ft = right[1];
       } else {
           fh = left[0];
           left[1].next = pivotNode;
           ft = pivotNode;
       }

       return new ListNode[] { fh, ft };
   }

   public static ListNode[] quickSort_(ListNode head){
       if (head == null || head.next == null)
           return new ListNode[] { head, head };

       int len = getLength(head);
       ListNode[] segregateNodes = getSegregateNodes(head, len / 2);

       ListNode[] left = quickSort_(segregateNodes[0]);
       ListNode[] right = quickSort_(segregateNodes[2]);

       return mergeLinkedLists(left, segregateNodes[1], right);
   }

   public ListNode sortList(ListNode head) {
        return quickSort_(head)[0];
   }
}