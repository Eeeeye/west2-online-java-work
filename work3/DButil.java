package com.Eeeeye.work3;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class DButil {
    public Connection getConnection() throws Exception {

        //1.导入
        //2.定义配置文件
        //3.加载配置文件(对象)
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        //4.获取连接池对象
        DruidDataSource dataSource = new DruidDataSource();
        //设置参数
        dataSource.setUrl("jdbc:mysql://localhost:3306/work3");
        dataSource.setUsername("root");
        dataSource.setPassword("13706029456Hh");
        //5.获取数据库连接
        Connection connection = dataSource.getConnection();
        return connection;
    }
}
