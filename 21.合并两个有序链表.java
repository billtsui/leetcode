/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();

        ListNode pointer = head;

        while(null != l1 && null != l2){
            if(l1.val < l2.val){
                pointer.next = l1;
               l1 = l1.next;
            }else{
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        if(null != l1){
            pointer.next = l1;
        }

        if(null != l2){
            pointer.next = l2;
        }

        return head.next;
    }
}
// @lc code=end

