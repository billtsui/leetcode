/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        if(lists.length == 1){
            return lists[0];
        }

        /**
         * 把所有链表的节点添加到List里面，用Java原生的排序，然后再串起来
         */

        // List<ListNode> arrayList = new ArrayList<>();
        // for (int i = 0; i < lists.length; i++) {
        //     ListNode head = lists[i];
        //     while(null!=head){
        //         arrayList.add(head);
        //         head = head.next;
        //     }
        // }

        // Collections.sort(arrayList, new Comparator<ListNode>() {
        //     @Override
        //     public int compare(ListNode a, ListNode b) {
        //         if(a.val == b.val) return 0;
        //         return a.val - b.val > 0 ? 1 : -1;
        //     }
        // });

        // ListNode newHead = new ListNode();
        // ListNode pointer = newHead;

        // for (ListNode listNode : arrayList) {
        //     pointer.next = listNode;
        //     pointer = pointer.next;
        // }

        // return newHead.next;

        /**
         * 分治法
         */
        if(lists.length == 2){
            return mergeTwoLists(lists[0],lists[1]);
        }

        int mid = lists.length / 2;

        ListNode[] subList1 = new ListNode[mid];
        ListNode[] subList2 = new ListNode[lists.length - mid];

        for (int i = 0; i < mid; i++) {
           subList1[i] = lists[i];
        }

        for (int j = mid,k = 0; j <lists.length; j++,k++) {
            subList2[k] = lists[j];
        }
        
        ListNode l1 = mergeKLists(subList1);
        ListNode l2 = mergeKLists(subList2);

        return mergeTwoLists(l1, l2);

    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();

        ListNode pointer = head;

        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        if (null != l1) {
            pointer.next = l1;
        }

        if (null != l2) {
            pointer.next = l2;
        }

        return head.next;
    }
}
// @lc code=end

