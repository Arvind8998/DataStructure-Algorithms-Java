/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    class Pair{
        int li;
        int di;
        int value;

        Pair(int li, int di, int value){
            this.li = li;
            this.di = di;
            this.value = value;
        }
    }
    
    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)=>{
        return a.value - b.value;
    });

    public ListNode mergeKLists(ListNode[] lists) {
        for(int i=0; i<lists.length; i++){
            Pair p = new Pair(i, 0, lists.get(i).get(0));
            pq.add(p);
            
        }

        while(pq.size()> 0){
            Pair p = pq.remove();
            rv.add(p.value);
            p.di++;

            if(p.di < lists.get(p.li)){
                p.val = lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }
        return rv;
    }
}