package com.xhh.construct.tree.unionFind;

/**
 * 查询、 合并都比较快。跟树的高度有关
 * 
 * 底层是树结构，用组数实现。
 * 
 * 针对2的优化：基于size，树的节点数
 *
 */
public class UnionFind3 implements UF {

    // i表示第i个元素指向的父节点
    private int[] parent;
    // i为根的集合中的元素个数
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
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

        // 优化方案：取2个元素的节点少的连接到元素多的节点
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
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
