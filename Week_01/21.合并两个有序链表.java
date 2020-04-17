/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * 1. 新建node temp，然后对比l1，l2，哪个小就next到哪个去 2.
         * 当有一个是!null时而且循环已经停止了，那么就把当前node.next指到 非空node中
         */
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 如果跳出while了，就代表有一个是非空的——最后的数字肯定比另外的list大。
        // 连接上这个非空的即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;

    }
}
// @lc code=end
