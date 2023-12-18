package com.Eeeeye.work3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBase {

    /**
     * 查询商品
     * @param
     */
    public void selectProducts() throws Exception {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //获取connection对象
        DButil dButil = new DButil();
        connection = dButil.getConnection();
        //定义SQL
        String sql = "select  product_id,product_name,product_price from product;";
        //获取pstmt对象
        pstmt = connection.prepareStatement(sql);
        //执行SQL
        rs = pstmt.executeQuery();
        //结果装载入集合
        List<products> products1 = new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int productId = rs.getInt("product_id");
            String productName = rs.getString("product_name");
            int productPrice = rs.getInt("product_price");
            products product = new products(productId, productName, productPrice);
            products1.add(product);
        }
        System.out.println(products1);

        // 关闭连接、释放资源
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询订单
     * @param
     */
    public void selectOrders() throws Exception {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //获取connection对象
        DButil dButil = new DButil();
        connection = dButil.getConnection();
        //定义SQL
        String sql = "select order_id ,product_id ,order_time ,order_price from orders;";
        //获取pstmt对象
        pstmt = connection.prepareStatement(sql);
        //执行SQL
        rs = pstmt.executeQuery();
        //结果装载入集合
        List<Orders> orders1 = new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int orderId = rs.getInt("order_id");
            int productId = rs.getInt("product_id");
            String orderTime = rs.getString("order_time");
            int orderPrice = rs.getInt("order_price");
            Orders orders = new Orders(orderId, productId, orderTime, orderPrice);
            orders1.add(orders);
        }
        System.out.println(orders1);
        // 关闭连接、释放资源
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加订单
     */
    public void addOrders(int order_id, int product_id, String order_time, int order_price) throws Exception {

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //获取connection对象
        DButil dButil = new DButil();
        connection = dButil.getConnection();
        //通过外键以及数据库中字段值范围的设置，实现对商品是否存在，以及价格是否合法的检验
        try {
            //开启事务
            connection.setAutoCommit(false);
            //定义SQL（解决SQL注入问题）
            String sql = "INSERT INTO orders VALUES (?, ?, ?,?);";
            //获取pstmt对象
            pstmt = connection.prepareStatement(sql);
            //设置参数
            pstmt.setInt(1, order_id);
            pstmt.setInt(2, product_id);
            pstmt.setString(3, order_time);
            pstmt.setInt(4, order_price);
            //执行SQL
            int count = pstmt.executeUpdate();
            //提交事务
            connection.commit();
            //处理结果
            System.out.println(count > 0);
        } catch (SQLException e) {
            connection.rollback();
            System.out.println("输入有误");

        }
        // 关闭连接、释放资源
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /**
     * 添加商品
     */
    public void addProducts(int product_id, String product_name, int product_price) throws Exception {


        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //获取connection对象
        DButil dButil = new DButil();
        connection = dButil.getConnection();
        //通过外键以及数据库中字段值范围的设置，实现对商品是否存在，以及价格是否合法的检验
        try {
            //开启事务
            connection.setAutoCommit(false);
            //定义SQL（解决SQL注入）
            String sql = "INSERT INTO product VALUES (?, ?, ?);";
            //获取pstmt对象
            pstmt = connection.prepareStatement(sql);
            //设置参数
            pstmt.setInt(1, product_id);
            pstmt.setString(2, product_name);
            pstmt.setInt(3, product_price);
            //执行SQL
            int count = pstmt.executeUpdate();
            //提交事务
            connection.commit();
            //处理结果，判断是否运行成功
            System.out.println(count > 0);
        } catch (SQLException e) {
            connection.rollback();
            System.out.println("输入有误");

        }
        // 关闭连接、释放资源
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //实现修改功能
    /**
     * 修改订单
     */
    public void updateOrders(int order_id, int product_id, String order_time, int order_price) throws Exception {

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //获取connection对象
        DButil dButil = new DButil();
        connection = dButil.getConnection();
        //通过外键以及数据库中字段值范围的设置，实现对商品是否存在，以及价格是否合法的检验
        try {
            //开启事务
            connection.setAutoCommit(false);
            //定义SQL（解决SQL注入问题）
            String sql = "UPDATE orders SET product_id = ?,order_time = ?,order_price = ? WHERE order_id = ?;";
            //获取pstmt对象
            pstmt = connection.prepareStatement(sql);
            //设置参数
            pstmt.setInt(4, order_id);
            pstmt.setInt(1, product_id);
            pstmt.setString(2, order_time);
            pstmt.setInt(3, order_price);
            //执行SQL
            int count = pstmt.executeUpdate();
            //提交事务
            connection.commit();
            //处理结果
            System.out.println(count > 0);
        } catch (SQLException e) {
            connection.rollback();
            System.out.println("输入有误");

        }
        // 关闭连接、释放资源
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /**
     * 修改商品
     */
    public void updateProduct(int product_id, String product_name, int product_price) throws Exception {

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //获取connection对象
        DButil dButil = new DButil();
        connection = dButil.getConnection();
        //通过外键以及数据库中字段值范围的设置，实现对商品是否存在，以及价格是否合法的检验
        try {
            //开启事务
            connection.setAutoCommit(false);
            //定义SQL（解决SQL注入问题）
            String sql = "UPDATE product SET product_name = ?,product_price = ? WHERE product_id = ?;";
            //获取pstmt对象
            pstmt = connection.prepareStatement(sql);
            //设置参数
            pstmt.setInt(3,product_id);
            pstmt.setString(1,product_name);
            pstmt.setInt(2,product_price);
            //执行SQL
            int count = pstmt.executeUpdate();
            //提交事务
            connection.commit();
            //处理结果
            System.out.println(count > 0);
        } catch (SQLException e) {
            connection.rollback();
            System.out.println("输入有误");

        }
        // 关闭连接、释放资源
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /**
     * 删除订单
     */
    public void deleteOrders(int order_id) throws Exception {

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //获取connection对象
        DButil dButil = new DButil();
        connection = dButil.getConnection();
        //通过外键以及数据库中字段值范围的设置，实现对商品是否存在，以及价格是否合法的检验
        try {
            //开启事务
            connection.setAutoCommit(false);
            //定义SQL（解决SQL注入问题）
            String sql = "DELETE FROM orders WHERE order_id = ?;";
            //获取pstmt对象
            pstmt = connection.prepareStatement(sql);
            //设置参数
            pstmt.setInt(1, order_id);
            //执行SQL
            int count = pstmt.executeUpdate();
            //提交事务
            connection.commit();
            //处理结果
            System.out.println(count > 0);
        } catch (SQLException e) {
            connection.rollback();
            System.out.println("输入有误");

        }
        // 关闭连接、释放资源
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /**
     * 删除商品
     */
    public void deleteProducts(int product_id) throws Exception {

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //获取connection对象
        DButil dButil = new DButil();
        connection = dButil.getConnection();
        //通过外键以及数据库中字段值范围的设置，实现对商品是否存在，以及价格是否合法的检验
        try {
            //开启事务
            connection.setAutoCommit(false);
            //定义SQL（解决SQL注入问题）
            String sql = "DELETE FROM product WHERE product_id = ?;";
            //获取pstmt对象
            pstmt = connection.prepareStatement(sql);
            //设置参数
            pstmt.setInt(1, product_id);
            //执行SQL
            int count = pstmt.executeUpdate();
            //提交事务
            connection.commit();
            //处理结果
            System.out.println(count > 0);
        } catch (Exception e) {
            connection.rollback();
            System.out.println("输入有误");

        }
        // 关闭连接、释放资源
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
