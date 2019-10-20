package com.xhh.construct.linkedlist;

/**
 * 链表-基于虚拟头结点
 *
 * 增:O(n)
 * addLast(e)       O(n)
 * addFirst(e)      O(1)
 * add(index, e)    O(n/2) = O(n)
 *
 * 删:O(n)
 * removeLast(e)    O(n)
 * removeFirst(e)   O(1)
 * remove(index, e) O(n/2) = O(n)
 *
 * 改:O(n)
 * set(index, e)    O(n)
 *
 * 查:O(n)
 * get(index)       O(n)
 * contains(e)      O(n)
 *
 * @param <E>
 */
public class LinkedList<E> {

    //虚拟头结点，用来统一add操作
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index处添加元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i ++)
            prev = prev.next;

//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

        //等同上面3句话的缩写
        prev.next = new Node(e, prev.next);
        size ++;
    }

    /**
     * 在链表头添加元素e
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾添加元素e
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }


    /**
     * 获取index位置元素e
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. illegal index.");

        //虚拟Node后一个表示index为0位置的Node
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        return cur.e;
    }

    /**
     * 获取链表第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改index位置元素为e
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. illegal index.");

        //虚拟Node后一个表示index为0位置的Node
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    /**
     * 查找链表中是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }


    /**
     * 从链表删除index位置元素e
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i ++)
            prev = prev.next;

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;

        size --;
        return retNode.e;
    }

    /**
     * 删除链头
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除链尾
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除元素e
     */
    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur + "->");
            cur = cur.next;
        }

//  for的写法
//        for(cur = dummyHead.next; cur != null; cur = cur.next)
//            sb.append(cur + "->");
        sb.append("NULL");
        return sb.toString();
    }

    /**
     * 内部节点类
     */
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

        public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < 5; i++) {
                linkedList.addFirst(i);
                System.out.println(linkedList);
            }

            linkedList.add(2, 555);
            System.out.println(linkedList);

            linkedList.remove(2);
            System.out.println(linkedList);

            linkedList.removeFirst();
            System.out.println(linkedList);

            linkedList.removeLast();
            System.out.println(linkedList);
        }
}
