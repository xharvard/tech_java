package com.xhh.construct.tree.unionFind;

/**
 * 查询、 合并都比较快。跟树的高度有关
 * 
 * 底层是树结构，用组数实现。
 * 
 * 针对5的优化：find的时候添加路径压缩,对路径压缩再优化，采用递归直接指到根节点。但是效率不一定比5快，只能说差不多
 *
 */
public class UnionFind6 implements UF {

    // i表示第i个元素指向的父节点
    private int[] parent;
    // i为根的集合所表示的树的层数
    private int[] rank;

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    // 查看元素p和元素q是否所属同一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合并元素p和元素q所属的集合
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        // 优化方案：取2个元素的节点rank低的连接到元素rank高的节点
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }

    // 查找元素的根节点
    // 添加路径压缩，采用递归直接指到根节点
    private int find(int n) {
        if (n < 0 || n >= parent.length)
            throw new IllegalArgumentException("index is not illegal.");

        while (n != parent[n]) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

}
