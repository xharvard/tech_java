package com.xhh.construct.tree.unionFind;

/**
 * Quick Find 查询非常快：O(1) 合并慢： O(n)
 * 
 * 底层是数组实现
 *
 */
public class UnionFind1 implements UF {

    private int[] ids;

    public UnionFind1(int size) {
        ids = new int[size];
        for (int i = 0; i < size; i++)
            ids[i] = i;
    }

    @Override
    public int getSize() {
        return ids.length;
    }

    // 查看元素p和元素q是否所属同一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合并元素p和元素q所属的集合
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId)
            return;

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == qId)
                ids[i] = pId;
        }
    }

    // 查找元素的根节点
    private int find(int n) {
        if (n < 0 || n >= ids.length)
            throw new IllegalArgumentException("index is not illegal.");
        return ids[n];
    }

}
