package com.xhh.dp.template;

public abstract class JDBCTemplate {

    public final void create() {
        // 1,注册
        register();
        // 2,建立连接
        connection();
        // 3,创建语句集
        createStatement();
        // 4,执行语句
        execute();
        // 5,处理结果集
        resultSet();
    }

    abstract void register();

    private void connection() {
        System.out.println("建立连接");
    }

    abstract void createStatement();

    private void execute() {
        System.out.println("执行语句");
    }

    abstract void resultSet();
}
