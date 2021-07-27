/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {

        /**
         * 声明两个头结点，一个链接大于等于x的数，一个链接小于x的数
         * 最后再用小于x的链表尾链接大于x的链表头
         */
        //临时头结点
        ListNode lessHead = new ListNode(0);
        ListNode moreHead = new ListNode(0);

        ListNode lessPtr = lessHead;
        ListNode morePtr = moreHead;

        while(null != head){
            if(head.val < x){
                lessPtr.next = head;
                lessPtr = head;
            }else{
                morePtr.next = head;
                morePtr = head;
            }
            head = head.next;
        }
        lessPtr.next = moreHead.next;
        morePtr.next = null;

        return lessHead.next;
    }
}
// @lc code=end

