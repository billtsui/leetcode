import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // Set法，需要额外的存储空间
        // Set nodeSet = new HashSet<>();

        // while(headA != null){
        // nodeSet.add(headA);
        // headA = headA.next;
        // }

        // while(headB != null){
        // if(nodeSet.contains(headB)){
        // return headB;
        // }
        // headB = headB.next;
        // }

        int listA_len = getListLength(headA);
        int listB_len = getListLength(headB);

        if (listA_len > listB_len) {
            headA = forwardLongList(listA_len, listB_len, headA);
        } else {
            headB = forwardLongList(listB_len, listA_len, headB);
        }

        while (null != headA && null != headB) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;

    }

    // 对齐指针
    private ListNode forwardLongList(int long_len, int short_len, ListNode head) {
        int delta = long_len - short_len;
        while (null != head && delta > 0) {
            head = head.next;
            delta--;
        }
        return head;
    }

    private int getListLength(ListNode head) {
        int len = 0;
        while (null != head) {
            len++;
            head = head.next;
        }
        return len;
    }
}
// @lc code=end
