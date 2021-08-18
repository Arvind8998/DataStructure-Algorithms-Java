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

  public static int getLength(ListNode head){
      ListNode c1 = head;
      int len = 0;

      while(c1 !=null){
          c1 = c1.next;
          len++;
      }
      return len;
  }

  public static boolean isBigger(ListNode l1, ListNode l2){
    int len1 = getLength(l1), len2 = getLength(l2);

    if(len1 > len2) return true;
    else if(len1 < len2) return false;
    else{
        ListNode c1 = l1, c2 = l2;
        while(c1 != null){
            if(c1.val > c2.val) return true;
            else if(c1.val < c2.val) return false;

            c1 = c1.next;
            c2 = c2.next;
        }
    }
    return true;
  }

  public static ListNode reverseLinkedList(ListNode head){
    ListNode prev = null, curr = head, forw = null;

    while(curr != null){
        forw = curr.next;
        curr.next = prev;

        prev = curr;
        curr = forw;
    }
    return prev;
}

  public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1), c1, c2, prev = dummy;

    int borrow = 0;

    if(isBigger(l1, l2)){
        c1 = reverseLinkedList(l1);
        c2 = reverseLinkedList(l2);
    }
    else{
        c1 = reverseLinkedList(l2);
        c2 = reverseLinkedList(l1);
    }

    while(c1 != null || c2 !=null ){
        int diff = borrow + (c1 != null ? c1.val : 0) - (c2 != null ? c2.val : 0);

        int digit = diff;

        if(diff < 0){
            digit += 10;
            borrow = -1;
        }
        else{
            borrow = 0;
        }
        
        prev.next = new ListNode(digit);
        prev = prev.next;

        if(c1!=null) c1 = c1.next;
        if(c2 !=null) c2 = c2.next;
    }

    ListNode ans = reverseLinkedList(dummy.next);
    prev = dummy;
    prev.next = null;

    ListNode c = ans;

    while(c != null){
        if(c.val !=0){
            prev.next = c;
            break;
        }
        ListNode forw = c.next;
        c.next = null;
        c = forw;
    }
   
    return dummy.next != null ? dummy.next : new ListNode(0);
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
    ListNode head1 = makeList(scn.nextInt());
    ListNode head2 = makeList(scn.nextInt());

    ListNode ans = subtractTwoNumbers(head1, head2);
    printList(ans);
  }

}