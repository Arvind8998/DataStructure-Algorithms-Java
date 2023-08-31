package PepCoding.LevelUp.LinkedList;
import java.util.*;
/* MyNotes :
return 1st head of linkedlist i.e fast.next.next != null
return 2nd head of linkedlist i.e fast!=null

leetcode question has returned 2nd head

for using utility function of middle node always return 1st middle of linkedList

odd length linkedList c1 = c2
Even length linkedList c1 > c2
*/
class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode midNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next!=  null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

    return slow;
}

public static ListNode reverse(ListNode head) {
    if(head == null || head.next == null) return head;
    ListNode prev=null,forw=null, curr = head;

    while(curr != null){
         forw = curr.next;

        curr.next = prev;
        prev = curr;
        curr = forw;
    }
    return prev;
}

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode middle = midNode(head);
        ListNode nHead = middle.next;
        middle.next = null;
        
        nHead = reverse(nHead);

        while(nHead != null){
             if(nHead.val != head.val) return false;
            nHead = nHead.next;
            head = head.next;

           
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        System.out.println(isPalindrome(dummy.next));
    }
}