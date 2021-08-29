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

  public static ListNode segregate(ListNode head, int pivotIdx) {
    if(head == null || head.next == null){
        return head;
    }

    ListNode pivotNode = head;
    while(pivotIdx -- >0){
        pivotNode = pivotNode.next;
    }

    ListNode smaller = new ListNode(-1), larger = new ListNode(-1), sp = smaller, lp = larger, curr = head;

    while(curr != null){
        if(curr != pivotNode && curr.val <= pivotNode.val){
            sp.next = curr;
            sp = sp.next;
        }
        else if(curr != pivotNode){
            lp.next = curr;
            lp = lp.next;
        }
        curr = curr.next;
    }
    sp.next = pivotNode.next = lp.next = null;
    sp.next = pivotNode;
    pivotNode.next = larger.next;

    return smaller.next;
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
    int idx = scn.nextInt();
    h1 = segregate(h1, idx);
    printList(h1);
  }
}