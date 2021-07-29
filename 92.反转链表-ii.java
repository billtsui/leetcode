/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 计算需要逆置的节点数
        int change_len = right - left + 1;

        // 初始化开始逆置的节点的前驱
        ListNode pre_head = null;

        // 最终转换后的链表头结点，非特殊情况即为head
        ListNode result = head;

        // 将head向前移动left-1个位置
        while (null != head && --left > 0) {
            pre_head = head;
            head = head.next;
        }

        // 将modify_last_tail指向当前head，即链表逆置后的尾结点
        ListNode modify_last_tail = head;

        ListNode new_head = null;

        // 开始逆置节点
        while (null != head && change_len > 0) {
            ListNode next = head.next;

            head.next = new_head;

            new_head = head;

            head = next;

            change_len--;
        }

        // 将逆置后的尾结点和right后面的节点相连
        modify_last_tail.next = head;

        // 如果pre_head不为空，说明不是从第一个节点开始逆置的
        if (null != pre_head) {
            pre_head.next = new_head;
        } else {
            result = new_head;
        }

        return result;
    }
}
// @lc code=end

