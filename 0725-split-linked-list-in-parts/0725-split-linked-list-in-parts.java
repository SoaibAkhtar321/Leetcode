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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[0];

        // Step 1: count nodes
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        // Step 2: calculate sizes
        int base = count / k;
        int extra = count % k;

        curr = head;

        // Step 3: split ll
        for (int i = 0; i < k; i++) {
            if (curr == null) {
                result[i] = null;
                continue;
            }

            result[i] = curr;

            int size = base + (i < extra ? 1 : 0);

            // go to last node of this part
            for (int j = 1; j < size; j++) {
                curr = curr.next;
            }

            // cut in parts
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }

        return result;
    }
}