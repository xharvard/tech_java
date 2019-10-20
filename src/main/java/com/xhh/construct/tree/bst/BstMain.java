package com.xhh.construct.tree.bst;

public class BstMain {
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

        bst.preOrder();
        System.out.println();

        bst.preOrderNR();
        System.out.println();

        System.out.println(bst);

        bst.inOrder();
        System.out.println();

        bst.postOrder();
        System.out.println();

        bst.levelOrder();
        System.out.println();
    }
}
