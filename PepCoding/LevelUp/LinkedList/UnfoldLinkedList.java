package PepCoding.LevelUp.LinkedList;
import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode reverseLinkedList(ListNode head){
        if(head ==null || head.next == null) return head;

        ListNode prev= null, curr = head, forw = null;

        while(curr != null){
            forw = curr.next;

            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public static void unfold(ListNode head) {
        ListNode d1 = new ListNode(-1), d2 = new ListNode(-1), c1 = d1, c2 = d2, c = head;

        while(c!=null){
            c1.next = c;
            c2.next = c.next;

            c1 = c1.next;
            c2 = c2.next;


            c = c.next;
            if(c!= null) c= c.next;
        }
        
       c1.next = null;
        ListNode rNode = reverseLinkedList(d2.next);
        c1.next = rNode;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
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

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}