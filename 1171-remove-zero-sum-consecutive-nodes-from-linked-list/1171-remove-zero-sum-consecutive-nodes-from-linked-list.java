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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        HashMap<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        

        // prefix sum
        ListNode curr = dummy;
        while(curr!= null){
            sum += curr.val;
            map.put(sum,curr);
            curr = curr.next;

        }

        curr = dummy;
        sum = 0;
        while(curr !=null){
            sum += curr.val;
            curr.next = map.get(sum).next;
            curr = curr.next;

        }

        return dummy.next;    
    }
}