/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {
        if(null == head || null == head.next){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(null != fast.next && null != fast.next.next){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverseList(slow.next);
        slow = slow.next;

        while(null != slow){
            if(head.val != slow.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head){
        ListNode newHead = null;

        while(null != head){
            ListNode next = head.next;

            head.next = newHead;

            newHead = head;

            head = next;
        }

        return newHead;
    }
}
// @lc code=end

