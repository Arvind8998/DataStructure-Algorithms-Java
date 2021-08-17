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

    public static ListNode mergeTwoSortedLinkedList(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 != null ? l1: l2;
        ListNode dummy = new ListNode(-1), c1 = l1, c2 = l2, curr = dummy;
        
        while(c1 != null && c2 != null){
            if(c1.val < c2.val){
                curr.next = c1;
                c1 = c1.next;
            }
            else{
                curr.next = c2;
                c2 = c2.next;
            }
            curr = curr.next;
        }
        curr.next = c1!= null ? c1 : c2;
        return dummy.next;
    } 

    public static ListNode mergeSort(ListNode head) {
        if(head.next == null) return head;

        ListNode middle = midNode(head);
        ListNode nHead = middle.next;
        middle.next = null;
        
        return mergeTwoSortedLinkedList(mergeSort(head), mergeSort(nHead));
        
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

        ListNode head = mergeSort(h1);
        printList(head);
    }
}