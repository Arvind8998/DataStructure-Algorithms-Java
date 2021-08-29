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

    public static ListNode segregateOnLastIndex(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode pivotNode = head;
        
        while(pivotNode.next != null){
            pivotNode = pivotNode.next;
        }
        
        ListNode smaller = new ListNode(-1), larger = new ListNode(-1), sp = smaller, lp = larger, curr = head;

        while(curr != null){
            if(curr.val <= pivotNode.val){
                sp.next = curr;
                sp = sp.next;
            }
            else{
                lp.next = curr;
                lp = lp.next;
            }
            curr = curr.next;
        }

        sp.next = lp.next = null;
        sp.next = larger.next;

        return pivotNode;
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
        h1 = segregateOnLastIndex(h1);
        printList(h1);
    }
}