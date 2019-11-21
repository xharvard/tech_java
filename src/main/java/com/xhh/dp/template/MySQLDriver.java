package com.xhh.dp.template;

public class MySQLDriver extends JDBCTemplate{

    @Override
    void register() {
        System.out.println("MySQL 注册");
    }

    @Override
    void createStatement() {
        System.out.println("MySQL 创建语句");
    }

    @Override
    void resultSet() {
        System.out.println("MySQL 处理结果集");
    }

}
