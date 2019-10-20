package com.xhh.construct.queue;

import java.util.Random;

public class QueueMain {

    public static void main(String[] args) {
        int opCount = 100000;
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);

        Queue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);

        Queue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);

        System.out.println("ArrayQueue, time: " + time1 + "s");
        System.out.println("LoopQueue, time: " + time2 + "s");
        System.out.println("LinkedListQueue, time: " + time3 + "s");
    }


    //测试队列性能（入/出队opCount次所需时间）
    private static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.currentTimeMillis();

        Random random = new Random();
        for (int i = 0; i < opCount; i ++)
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));

        for (int i = 0; i < opCount; i ++)
            queue.dequeue();

        long endTime = System.currentTimeMillis();

        return (endTime - startTime) / 1000.0;
    }

}
