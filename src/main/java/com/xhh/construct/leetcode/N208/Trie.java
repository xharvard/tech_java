package com.xhh.construct.leetcode.N208;

import java.util.TreeMap;

public class Trie {
    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 添加单词
     */
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 单词不存在，则添加单词节点
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }

        // 待添加的单词不存在才添加
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * Trie中是否存在word
     * 
     * @param word
     * @return
     */
    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 查询是否在Trie中有单词以prefix为前缀
     * 
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }

    /**
     * 单词数量
     */
    public int getSize() {
        return size;
    }
    
    private class Node {
        // 是否是单词结尾
        public boolean isWord;
        // 子节点
        public TreeMap<Character, Node> next;

        public Node() {
            this(false);
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }
    }
}
