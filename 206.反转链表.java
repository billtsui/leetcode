/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    //遍历链表然后逆置每一个节点，头插法
    public ListNode reverseList(ListNode head) {
        ListNode new_head = null;

        while(null != head){
            //备份next
            ListNode next = head.next;

            //更新head->next
            head.next = new_head;
            
            //移动new_head
            new_head = head;

            head = next;
        }
        return new_head;
    }
}
// @lc code=end

