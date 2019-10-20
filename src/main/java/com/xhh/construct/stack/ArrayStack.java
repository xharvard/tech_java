package com.xhh.construct.stack;

import com.xhh.construct.array.Array;

/**
 * 基于动态数组实现栈
 *
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

    // 存放数据的动态数组
    private Array<E> array;

    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayStack() {
        this.array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ");
        sb.append("[");
        for(int i = 0; i < array.getSize(); i++){
            sb.append(array.get(i));
            if(i != array.getSize() - 1){
                sb.append(", ");
            }
        }
        sb.append("] Top");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
