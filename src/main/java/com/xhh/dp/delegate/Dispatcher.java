package com.xhh.dp.delegate;

/**
 * 委派模式
 *
 */
public class Dispatcher implements ITask {

    private ITask executor;

    public Dispatcher(ITask executor) {
        this.executor = executor;
    }

    // 自己不做任务，委派给具体的执行者
    @Override
    public void doTask() {
        this.executor.doTask();
    }

}
