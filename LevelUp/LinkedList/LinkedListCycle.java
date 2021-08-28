public boolean hasCycle(ListNode head) {
    if(head == null || head.next == null) return false;
    
    ListNode slow = head, fast = head;
    
    while(fast != null && fast.next != null ){
        slow = slow.next;
        fast = fast.next.next;
        
        if(slow == fast){
            return true;
        }
    }
    return false;
}

public ListNode detectCycle(ListNode head) {
    if(head == null || head.next == null) return null;

    ListNode slow = head, fast = head;
    
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        
        if(slow == fast){
            break;
        }
    }

    if(slow != fast) return null;
    
    slow = head;
    
    while(slow != fast){
        slow = slow.next;
        fast = fast.next;
    }
    return fast;
} 

public static getCycleLen(ListNode mp){
    int cycleLength = 1;
    ListNode  curr = mp.next;

    while(curr != mp){  
        curr = curr.next;
        cycleLength++;
    }
    return cycleLength;
}

public ListNode cycleVariables(ListNode head) {
    if(head == null || head.next == null) return null;

    ListNode slow = head, fast = head;
    
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        
        if(slow == fast){
            break;
        }
    }

    if(slow != fast) return null;
    
    slow = head;
    ListNode mp = fast
    int cycleCount = 0 ,A=0;
    while(slow != fast){
        slow = slow.next;
        fast = fast.next;

        if(mp == fast) cycleCount ++;
        A++;
    }
    int cycleLength = getCycleLen(mp);
    int m = cycleCount +1;
    int C = A- cycleCount * cycleLen;
    int B = cycleLen - C;

    return slow;
} 