package com.xhh.construct.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于java.util.List 实现栈
 *
 */
public class ListStack<E> implements Stack<E> {

    // 存放数据的动态列表
    private List<E> list;

    public ListStack(){
        list = new ArrayList<>();
    }

    public ListStack(int capacity){
        list = new ArrayList<>(capacity);
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.add(e);
    }

    @Override
    public E pop() {
        if(list.isEmpty())
            return null;
        return list.remove(list.size() - 1);
    }

    @Override
    public E peek() {
        if(list.isEmpty())
            return null;
        return list.get(list.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ");
        sb.append("[ ");
        for(int i = 0; i < list.size(); i ++){
            sb.append(list.get(i));
            if(i != list.size() - 1)
                sb.append(", ");
        }
        sb.append("] Top");
        return sb.toString();
    }

    public static void main(String[] args) {
        ListStack<Integer> stack = new ListStack<>();
        for (int i = 0; i < 5; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
