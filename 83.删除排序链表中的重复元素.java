/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start
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
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode pointer = head;

        while (null != pointer.next) {
            ListNode new_next = pointer.next.next;
            if (pointer.val == pointer.next.val) {
                pointer.next = new_next;
            } else {
                pointer = pointer.next;
            }
        }

        return head;
    }
}
// @lc code=end

