package com.xhh.construct.map;

/**
 * 基于二分搜索树的Map
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node root;
    private int size;

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = addNode(root, key, value);
    }

    private Node addNode(Node node, K key, V value) {
        //递归终止判断
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        //递归判断
        if (key.compareTo(node.key) < 0)
            node.left = addNode(node.left, key, value);
        else if (key.compareTo(node.key) > 0)
            node.right = addNode(node.right, key, value);
        else
            node.value = value;
        return node;
    }

    private Node getNode(Node node, K key) {
        if (node == null)
            return null;

        if (key.compareTo(node.key) == 0)
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node remove(Node node, K key) {

        if (node == null)
            return node;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else { //找到的情况
            //只有左子节点
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //只有右子节点
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            //左右节点都有，找右子树的最小值替代当前节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + "doesn't exist.");

        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    public static void main(String[] args) {
        String[] words = {"apple", "apple", "orange", "pair", "apple", "orange"};
        BSTMap<String, Integer> map = new BSTMap<>();

        for (String word : words) {
            if (map.contains(word))
                map.set(word, map.get(word) + 1);
            else
                map.add(word, 1);
        }

        System.out.println("total size: " + map.getSize());
        System.out.println("Frequency of apple: " + map.get("apple"));
        System.out.println("Frequency of orange: " + map.get("orange"));
        System.out.println("Frequency of pair: " + map.get("pair"));
    }
}
