package com.xhh.construct.tree.segment;

/**
 * 线段树： Segment Tree,处理区间问题 。是平衡二叉树，依然可以用数组表示，如果区间有n个元素，需要4n的空间。属于高级结构。
 * 
 * 对于给的区间，解决更新、查询问题，不考虑添加、删除元素,使用静态数组实现即可。
 * 更新：更新区间中的一个元素或者一个区间的值
 * 查询： 区间[i, j]的最大值，最小值，或者区间数字和
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        Integer[] nums = { -2, 0, 3, -5, 2, -1 };
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segmentTree);

        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(2, 5));
        System.out.println(segmentTree.query(0, 5));
    }

}
