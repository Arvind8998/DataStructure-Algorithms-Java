/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {

    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode forw = curr.next;
            curr.next = prev;

            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode nHead = mid.next;
        mid.next = null;

        nHead = reverseLinkedList(nHead);

        ListNode c1 = head, c2 = nHead;
        boolean isPalindrome = true;
        while (c2 != null) {
            if (c1.val != c2.val) {
                isPalindrome = false;
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
        }

        nHead = reverseLinkedList(nHead);
        mid.next = nHead;
        return isPalindrome;
    }
}