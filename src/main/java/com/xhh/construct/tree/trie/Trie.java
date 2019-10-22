package com.xhh.construct.tree.trie;

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
    public void add(String word) {
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
    public boolean contains(String word) {
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
    public boolean isPrefix(String prefix) {
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
    
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.add("hello");
        trie.add("word");
        trie.add("words");
        trie.add("hellowall");
        
        System.out.println(trie.contains("hello"));
        System.out.println(trie.contains("hello2"));
        System.out.println(trie.isPrefix("hel"));
        System.out.println(trie.isPrefix("wod"));
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
