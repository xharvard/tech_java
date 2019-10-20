package com.xhh.construct.array;

/**
 * 自定义数组
 *
 * 数组内类型必须一致，索引从0开始
 * 优点：快速查询 arr[i]
 *
 */
public class Array<E> {

    //默认数组容量: 10
    private static final int DEFAULT_CAPACITY = 10;
    //数组的写入位置
    private int size;
    //数据内部存储数组
    private E[] data;

    /**
     * 构造函数
     *
     * @param capacity 数组的容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for(int i = 0; i < arr.length; i++){
            data[i] = arr[i];
        }
        this.size = arr.length;
    }

    /**
     * 默认构造函数
     */
    public Array() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 获取数组的元素个数
     *
     * @return 数组的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return 数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     *
     * @return true: 空 false:不空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在index位置添加元素e,原来的元素通通往后移一位
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        //index必须在0-size之间
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Index is illegal.");

        //size已经到达最后了，扩充容量
        if (size == data.length) {
            resize(2 * data.length);
        }

        //将index之后的元素往后移动一位，空出index位置用于add
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;
        size ++;
    }

    /**
     * 向所有元素前添加元素e
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向所有元素后添加元素e
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取index处数组元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        //index必须在0-size之间
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");

        return data[index];
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改index处数组元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {//index必须在0-size之间
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");

        data[index] = e;
    }

    /**
     * 判断数组中是否存在元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * 返回元素在数组中的索引
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 删除index处的元素，返回该index对应的值
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        //index必须在0-size之间
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E cur = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];

        size --;
        data[size] = null;

        //如果size只有原数组的1/4，则缩容
        if(size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);

        return cur;
    }

    /**
     * 删除元素e
     *
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (-1 != index)
            remove(index);
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 交换索引i和j的值
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        if (i < 0 || i > size || j < 0 || j > size)
            throw new IllegalArgumentException("index is illegal.");

        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 数组扩容，默认扩充为原来的2倍
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newDate = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newDate[i] = data[i];

        data = newDate;
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);
    }

}
