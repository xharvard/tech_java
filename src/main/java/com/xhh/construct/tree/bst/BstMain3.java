package com.xhh.construct.tree.bst;

public class BstMain3 {
    //测试删除任一元素
    public static void main(String[] args) {
        /**
         *       5
         *      / \
         *     3  6
         *    / \  \
         *   2  4   8
         *
         */
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);

        bst.remove(3);

        System.out.println(bst);

    }
}
