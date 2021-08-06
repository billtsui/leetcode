/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        if(null == head || null == head.next){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
    
        while(null != fast && null != fast.next){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(middle);

        ListNode h = new ListNode();
        ListNode pointer = h;
        while(null != left && null != right){
            if(left.val < right.val){
                pointer.next = left;
                left = left.next;
            }else{
                pointer.next = right;
                right = right.next;
            }
            pointer = pointer.next;
        }
        pointer.next = left != null ? left : right;
        return h.next;
    }
}
// @lc code=end

