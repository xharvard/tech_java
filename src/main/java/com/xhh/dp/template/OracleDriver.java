package com.xhh.dp.template;

public class OracleDriver extends JDBCTemplate{

    @Override
    void register() {
        System.out.println("Oracle 注册");
    }

    @Override
    void createStatement() {
        System.out.println("Oracle 创建语句");
    }

    @Override
    void resultSet() {
        System.out.println("Oracle 处理结果集");
    }

}
