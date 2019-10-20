package com.xhh.construct.queue;

/**
 * 循环队列
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    //队首index,队尾index
    private int front, tail;
    //使用个数
    private int size;

    public LoopQueue(int capacity) {
        //循环队列会浪费一个空间，所以需要capacity + 1
        data = (E[]) new Object[capacity + 1];
        front = tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        //队列已满
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Dequeue Fail. Queue is empty.");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);

        return ret;
    }

    @Override
    public E getFront() {

        if (isEmpty())
            throw new IllegalArgumentException("Get Fail. Queue is empty.");

        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d, capacity = %d", size, getCapacity()));
        sb.append(" Front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(", ");
            }
        }
        sb.append("] Tail");
        return sb.toString();
    }

    private void resize(int newCapacity) {
        E[] newDate = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++)
            newDate[i] = data[(i + front) % data.length];

        data = newDate;
        front = 0;
        tail = size;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}
