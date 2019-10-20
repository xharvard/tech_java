package com.xhh.construct.set;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于二分搜索树实现（效率高），复杂度（O(logn)）
 * 基于链表实现，复杂度（O(n)）
 *
 * 有序集合：元素具有顺序性（基于搜索树实现）
 * 无序集合：元素没有顺序性（基于链表/哈希表实现）
 * 多重集合：元素可以重复
 */
public class Main {

    public static void main(String[] args) {
        List<String> words1 = new ArrayList<>();
        List<String> words2 = new ArrayList<>();

        System.out.println("pride-and-prejudice.txt");
        if(FileOperator.readFile("src\\pride-and-prejudice.txt", words1)){
            System.out.println("total words: " + words1.size());

            BSTSet<String> set1 = new BSTSet<>();
            for(String word : words1)
                set1.add(word);

            System.out.println("different words: " + set1.getSize());
        }

        System.out.println();
        System.out.println("a-tale-of-two-cities.txt");
        if(FileOperator.readFile("src\\a-tale-of-two-cities.txt", words2)){
            System.out.println("total words: " + words2.size());

            BSTSet<String> set2 = new BSTSet<>();
            for(String word : words2)
                set2.add(word);

            System.out.println("different words: " + set2.getSize());
        }
    }
}
