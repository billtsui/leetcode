/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(null == l1){
            return l2;
        }

        if(null == l2){
            return l1;
        }

        ListNode poiL1 = l1;
        ListNode poiL2 = l2;

        ListNode head = new ListNode();
        ListNode cur = head;

        //进位标志
        int flag = 0;
        while(null != poiL1 && null != poiL2){
            int result =  poiL1.val + poiL2.val + flag;

            flag = result / 10;
            result = result % 10;

            ListNode newNode = new ListNode(result);
            cur.next = newNode;
            cur = cur.next;

            poiL1 = poiL1.next;
            poiL2 = poiL2.next;
        }

        while(null != poiL1){
            int result = poiL1.val + flag;
            flag = result / 10;
            result = result % 10;
            ListNode newNode = new ListNode(result);
            cur.next = newNode;
            cur = cur.next;
            poiL1 = poiL1.next;
        }

        while(null != poiL2){
            int result = poiL2.val + flag;
            flag = result / 10;
            result = result % 10;
            ListNode newNode = new ListNode(result);
            cur.next = newNode;
            cur = cur.next;
            poiL2 = poiL2.next;
        }

        if(flag == 1){
            cur.next = new ListNode(1,null);
        }

        return head.next;
    }
}
// @lc code=end

