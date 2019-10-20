package com.xhh.construct.tree.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BstMain2 {
    //测试删除最小，最大元素
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        int count = 1000;

        for (int i = 0; i < count; i++)
            bst.add(random.nextInt(10000));
        List<Integer> min = new ArrayList<>();
        while (!bst.isEmpty()) {
            min.add(bst.removeMin());
        }
        System.out.println("min：" + min);


        for (int i = 0; i < count; i++)
            bst.add(random.nextInt(10000));
        List<Integer> max = new ArrayList<>();
        while (!bst.isEmpty()) {
            max.add(bst.removeMax());
        }
        System.out.println("max：" + max);

    }
}
