package com.xhh.construct.map;


import com.xhh.construct.set.FileOperator;

import java.util.ArrayList;

/**
 * 基于二分搜索树实现（效率高），复杂度（O(logn)）
 * 基于链表实现，复杂度（O(n)）
 *
 * 有序映射：键具有顺序性（基于搜索树实现）
 * 无序映射：键没有顺序性（基于链表/哈希表实现）
 * 多重映射：键可以重复
 */
public class Main {

    private static double testMap(Map<String, Integer> map, String filename){
        long startTime = System.currentTimeMillis();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperator.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words){
                if(map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        long endTime = System.currentTimeMillis();

        return (endTime - startTime) / 1000.0;
    }

    public static void main(String[] args) {

        String filename = "src\\pride-and-prejudice.txt";

        BSTMap<String, Integer> bstMap = new BSTMap<>();
        double time1 = testMap(bstMap, filename);
        System.out.println("BST Map: " + time1 + " s");

        System.out.println();

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap, filename);
        System.out.println("Linked List Map: " + time2 + " s");

    }
}
