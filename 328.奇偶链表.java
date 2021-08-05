/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
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
    public ListNode oddEvenList(ListNode head) {
        if(null == head || null == head.next){
            return head;
        }

        ListNode evenHead = head.next;
        ListNode odd = head,even = evenHead;

        while(null != even && null != even.next){
            //将奇数节点的下一个节点指向下一个奇数节点
            odd.next = even.next;
            //将奇数节点向后移动
            odd = odd.next;

            //偶数节点的处理方法相同
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
// @lc code=end

