package com.xhh.construct.tree.unionFind;

public interface UF {

    int getSize();

    // 查询
    boolean isConnected(int p, int q);

    // 合并
    void unionElements(int p, int q);
}
