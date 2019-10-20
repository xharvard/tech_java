package com.xhh.construct.heap;


import java.util.Random;

import com.xhh.construct.array.Array;

/**
 * 最大堆
 * add和extractMax的时间复杂度： O(logN)
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    /**
     * Heapify 的过程
     * @param arr
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for(int i = parent(arr.length - 1); i >= 0; i--)
            siftDown(i);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 添加元素
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        // 调整堆 siftUp
        siftUp(data.getSize() - 1);
    }

    /**
     * 取出堆中最大元素
     * @return
     */
    public E extractMax() {
        E ret = findMax();
        //交换第0个元素和最后一个元素的值,然后删除最后一个，其实相对于删除第一个
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * 取出堆中最大元素,并且替换成元素e
     * @param e
     * @return
     */
    public E replace(E e){
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    /**
     * 查看堆中最大元素
     * @return
     */
    public E findMax() {
        if(data.getSize() == 0)
            throw new IllegalArgumentException("heap is empty.");
        return data.get(0);
    }


    /**
     * 调整堆的父子节点。当前节点的值大于父节点，则互换
     * @param k
     */
    private void siftUp(int k){
        // 父节点的值小于当前节点
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(parent(k), k);
            k = parent(k);
        }
    }

    /**
     * 调整堆的父子节点。父节点的值与左右子节点中较大的节点互换。
     * @param k
     */
    private void siftDown(int k) {
        // 有左节点则循环
        while (leftChild(k) < data.getSize()) {
            // 计算左右节点最大值
            int max = leftChild(k);
            // 如果有右节点，且值大于左节点，则取右节点
            if (max + 1 < data.getSize() && data.get(max + 1).compareTo(data.get(max)) > 0) {
                max = rightChild(k);
            }

            // 如果当前父节点大于左右子节点的最大值，则不用交换，结束循环
            if (data.get(k).compareTo(data.get(max)) >= 0){
                break;
            }

            // 交换
            data.swap(k, max);
            k = max;
        }
    }

    /**
     * 获取当前节点对应的父节点的索引
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0 doesn't has parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 获取当前节点对应的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 获取当前节点对应的右孩子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public static void main(String[] args) {
        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++)
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = maxHeap.extractMax();

        for (int i = 1; i < n; i++)
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("ERROR");

        System.out.println("Test MaxHeap completed.");

        // 测试heapify和空堆里一个一个添加元素的性能差异
        Integer[] data = new Integer[n];
        for(int i = 0; i < n; i++)
            data[i] = random.nextInt(Integer.MAX_VALUE);

        double time1 = testHeap(data, true);
        System.out.println("with heapify, time is " + time1);

        double time2 = testHeap(data, false);
        System.out.println("no heapify, time is " + time2);
    }

    private static double testHeap(Integer[] data, boolean isHeapify){
        long start = System.currentTimeMillis();

        MaxHeap<Integer> maxHeap;

        if(isHeapify)
            maxHeap = new MaxHeap<>(data);
        else{
            maxHeap = new MaxHeap<>();
            for(int i : data)
                maxHeap.add(i);
        }

        int[] arr = new int[data.length];
        for (int i = 0; i < data.length; i++)
            arr[i] = maxHeap.extractMax();

        for (int i = 1; i < data.length; i++)
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("ERROR");

        System.out.println("Test MaxHeap completed.");
        long end = System.currentTimeMillis();
        return (end - start) / 1000.0d;
    }
}
