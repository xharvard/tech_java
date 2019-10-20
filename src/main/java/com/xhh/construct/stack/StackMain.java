package com.xhh.construct.stack;

import java.util.Random;

public class StackMain {
    public static void main(String[] args) {
        int opCount = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);

        ListStack<Integer> listStack = new ListStack<>();
        double time3 = testStack(listStack, opCount);

        System.out.println("ArrayStack, time: " + time1 + "s");
        System.out.println("LinkedListStack, time: " + time2 + "s");
        System.out.println("ListStack, time: " + time3 + "s");
    }


    //测试栈性能（入/出栈opCount次所需时间）
    private static double testStack(Stack stack, int opCount) {
        long startTime = System.currentTimeMillis();

        Random random = new Random();
        for (int i = 0; i < opCount; i ++)
            stack.push(random.nextInt(Integer.MAX_VALUE));

        for (int i = 0; i < opCount; i ++)
            stack.pop();

        long endTime = System.currentTimeMillis();

        return (endTime - startTime) / 1000.0;
    }
}
