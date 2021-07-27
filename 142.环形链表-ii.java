/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }
        // 快慢指针
        ListNode meet = null;
        ListNode fast = head;
        ListNode slow = head;
        
        while(null != fast){
            slow = slow.next;
            fast = fast.next;

            if(null == fast){
                break;
            }

            fast = fast.next;

            if(fast == slow){
                meet = fast;
                break;
            }
        }

        if(null == meet){
            return null;
        }
        
        while (null != head && null != meet) {
            if (meet == head) {
                return head;
            }

            meet = meet.next;
            head = head.next;
        }

        return null;
    }
}
// @lc code=end
