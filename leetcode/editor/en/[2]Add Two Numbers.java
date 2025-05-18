//You are given two non-empty linked lists representing two non-negative 
//integers. The digits are stored in reverse order, and each of their nodes contains a 
//single digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the 
//number 0 itself. 
//
// 
// Example 1: 
// 
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have 
//leading zeros. 
// 
//
// Related Topics Linked List Math Recursion 👍 33483 👎 6721


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode current = null;
        String l1AsString = "";
        String l2AsString = "";
        String result = "";
        int l = 0;
        int carry = 0;
        while (l1 != null) {
            l1AsString = l1AsString + String.valueOf(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            l2AsString = l2AsString + String.valueOf(l2.val);
            l2 = l2.next;
        }
        l = (l1AsString.length() > l2AsString.length()) ? l1AsString.length() : l2AsString.length();
        for (int i = 0; i < l; i++) {
            int l1digit = (i > l1AsString.length() - 1) ? 0 : Integer.parseInt("" + l1AsString.charAt(i));
            int l2digit = (i > l2AsString.length() - 1) ? 0 : Integer.parseInt("" + l2AsString.charAt(i));
            int digit = l1digit + l2digit + carry;
            carry = 0;
            if (digit >= 10) {
                carry = 1;
                digit = digit - 10;
            }
            if (l3 == null) {
                l3 = new ListNode(digit);
                current = l3;
            } else {
                current.next = new ListNode(digit);
                current = current.next;
            }
        }
        if (carry == 1) current.next = new ListNode(1);
        return l3;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
