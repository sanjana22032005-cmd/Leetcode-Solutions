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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int total=1;
        if(head==null){
            return null;
        }
        ListNode curr=head;
        while(curr.next!=null){
            curr=curr.next;
            total++;
        }
        ListNode start=head;
        ListNode prev=null;
        int pos=1;
        if((total-n+1)==1){
            return head.next;
        }
        while(start!=null){
             if(pos==(total-n+1)){
              prev.next=start.next;
              break;
           }
            prev=start;
           start=start.next;
           pos++;
        }
        return head;
    }
}