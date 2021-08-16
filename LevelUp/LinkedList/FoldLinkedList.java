import java.util.*;

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

public static ListNode reverseLinkedList(ListNode head){
    ListNode prev = null, curr = head;
    
    while(curr != null){
        ListNode forw = curr.next;
        
        curr.next = prev;
        
        prev = curr;
        curr = forw;
    }
    return prev;
}

    public static void fold(ListNode head) {
        ListNode c1 = head, c2 =null, f1 = null, f2 = null;
        ListNode midNode = midNode(head);
        ListNode nHead = midNode.next;
        midNode.next = null;
        nHead = reverseLinkedList(nHead);
        
        c2 = nHead;
        while(c2 !=null){
            f1 = c1.next;
            f2 = c2.next;

            c1.next = c2;
            c2.next = f1;

            c1 = f1;
            c2 = f2;
        }
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
        fold(head);
        printList(head);
    }
}