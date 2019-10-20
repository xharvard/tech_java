package com.xhh.construct.leetcode.N203;

/**
 * 虚拟头结点实现
 */
public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        while (prev.next != null) {
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;

        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode newNode = new Solution2().removeElements(head, 6);
        System.out.println(newNode);
    }
}
