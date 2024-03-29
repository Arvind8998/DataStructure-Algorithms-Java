package PepCoding.LevelUp.LinkedList;
import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1), prev = dummy, curr = head;
        while(curr != null){
            while(curr != null && prev.val == curr.val){
                ListNode forw = curr.next;
                curr.next = null;
                curr = forw;
            }
            prev.next = curr;
            prev = prev.next;
            if(curr !=null){
                curr = curr.next;
            }
        }
        return head;
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = makeList(scn.nextInt());

        ListNode ans = removeDuplicates(head);
        printList(ans);
    }

}