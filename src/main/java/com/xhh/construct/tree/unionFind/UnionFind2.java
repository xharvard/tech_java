package com.xhh.construct.tree.unionFind;

/**
 * 查询、 合并都比较快。跟树的高度有关
 * 
 * 底层是树结构，用组数实现。
 *
 */
public class UnionFind2 implements UF {

    // i表示第i个元素指向的父节点
    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
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

        parent[pRoot] = qRoot;
    }

    // 查找元素的根节点
    private int find(int n) {
        if (n < 0 || n >= parent.length)
            throw new IllegalArgumentException("index is not illegal.");

        while (n != parent[n]) {
            n = parent[n];
        }
        return n;
    }

}
