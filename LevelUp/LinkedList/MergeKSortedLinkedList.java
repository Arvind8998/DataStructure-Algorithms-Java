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

 public static ListNode mergeKLists(ListNode[] lists, int si, int ei) {
     if(si > ei) return null;
     if(si == ei) return lists[si];
     
     int mid = (si + ei)/2;
     
        return mergeTwoSortedLinkedList(mergeKLists(lists, si, mid), mergeKLists(lists, mid+1, ei));
    }
    
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length ==0) return null;
        return mergeKLists(lists, 0, lists.length-1);
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
        ListNode[] list = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            list[i] = createList(m);
        }

        ListNode head = mergeKLists(list);
        printList(head);
    }
}