import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
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
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        //用set存节点，如果没有环就只能返回false。有环则set的第一个元素是环起点
        // Set nodeSet = new HashSet<>();
        // while(null != head){
        //     if(nodeSet.contains(head)){
        //         return true;
        //     }
        //     nodeSet.add(head);
        //     head = head.next;
        // }

        //快慢指针
        ListNode fast = head.next;
        ListNode slow = head;
        while(slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
// @lc code=end

