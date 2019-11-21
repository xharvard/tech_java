package com.xhh.dp.delegate;

public class ExecutorA implements ITask{

    @Override
    public void doTask() {
        System.out.println("执行任务A");
    }

}
