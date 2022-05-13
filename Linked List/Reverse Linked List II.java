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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count=0;
        dummy=new ListNode(-1);
        dummy.next=head;
        ListNode temp=dummy;
        boolean b1=false,b2=false;
        ListNode start=dummy,end=null;
        while(temp!=null){
            if(count+1==left){
                start=temp;    
                b1=true;
            }
            else if(count==right){
                end=temp.next;
                b2=true;
            }
            count++;
            temp=temp.next;
        }
        if(b1&&b2)
            reverse(start,end);
        return dummy.next;
    }
    private ListNode reverse(ListNode start,ListNode end){
        ListNode prev=start,cur=start.next,next=null;
        ListNode ans=cur;
        while(cur!=end)
        {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;    
        }
        start.next=prev;
        ans.next=cur;
        return ans;
    }
    private ListNode dummy;
}
