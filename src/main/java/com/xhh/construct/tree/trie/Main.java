package com.xhh.construct.tree.trie;

import java.util.ArrayList;
import java.util.List;

import com.xhh.construct.set.BSTSet;
import com.xhh.construct.set.FileOperator;

/**
 * Trie：字典树，多叉树,属于前缀树。多应用于插入、查询操作
 * 局限性：空间    解决方案：压缩Trie、三分搜索Trie
 *
 */
public class Main {

    public static void main(String[] args) {
        // 比较BST和Trie的性能
        System.out.println("pride-and-prejudice.txt");
        List<String> words = new ArrayList<>();
        if (FileOperator.readFile("src\\main\\java\\pride-and-prejudice.txt", words)) {
            long startTime = System.nanoTime();
            // BST
            BSTSet<String> set = new BSTSet<>();
            for (String word : words)
                set.add(word);

            for (String word : words)
                set.contains(word);

            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + set.getSize());
            System.out.println("BSTSet: " + time + " S");

            // Trie
            startTime = System.nanoTime();
            Trie trie = new Trie();
            for (String word : words)
                trie.add(word);

            for (String word : words)
                trie.contains(word);

            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + set.getSize());
            System.out.println("Trie: " + time + " S");
        }
    }
}
