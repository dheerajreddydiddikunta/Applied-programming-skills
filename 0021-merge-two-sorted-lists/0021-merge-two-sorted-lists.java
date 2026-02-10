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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. Create a dummy node to act as the starting point
        ListNode ans = new ListNode(0);
        ListNode current = ans;

        // 2. Iterate while BOTH lists have nodes remaining
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;   // Link the smaller node
                list1 = list1.next;      // Move list1 pointer forward
            } else {
                current.next = list2;   // Link the smaller node
                list2 = list2.next;      // Move list2 pointer forward
            }
            current = current.next;      // Move the result list pointer forward
        }

        // 3. If one list is longer than the other, attach the remainder
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        // 4. Return the head of the merged list (skip the dummy)
        return ans.next;
    }
}