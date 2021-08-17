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

    public static ListNode segregate012(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode curr = head, zer = new ListNode(-1), one = new ListNode(-1), tp = new ListNode(-1), c1 = zer, c2 = one, c3 = tp;
        
        while(curr != null){
            if(curr.val  == 0){
                c1.next = curr;
                c1 = c1.next;
            }
            else if(curr.val  == 1){
                c2.next = curr;
                c2 = c2.next;
            }
            else if(curr.val  == 2){
                c3.next = curr;
                c3 = c3.next;
            }
            curr = curr.next;
        }
        c1.next = c2.next = c3.next = null;
        c2.next = tp.next;
        c1.next = one.next;
        return zer.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        h1 = segregate012(h1);
        printList(h1);
    }
}