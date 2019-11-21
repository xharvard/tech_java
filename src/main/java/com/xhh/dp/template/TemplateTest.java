package com.xhh.dp.template;

import org.junit.Test;

public class TemplateTest {

    @Test
    public void test1() {
        MySQLDriver mysql = new MySQLDriver();
        mysql.create();

        System.out.println("================");
        OracleDriver oracle = new OracleDriver();
        oracle.create();

    }
}
