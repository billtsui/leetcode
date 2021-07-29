import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(null == head) return null;

        Map<Node,Node> map = new HashMap<Node,Node>();
        Node p = head;
        //将原节点和新节点放入map中
        while(null != p){
            Node newNode = new Node(p.val);
            map.put(p,newNode);
            p = p.next;
        }
        p = head;
        //遍历原链表，设置新节点的next和random
        while(null != p){
            Node newNode = map.get(p);
            if(null != p.next){
                newNode.next = map.get(p.next);
            }

            if(null != p.random){
                newNode.random = map.get(p.random);
            }

            p = p.next;
        }

        return map.get(head);
    }
}
// @lc code=end

