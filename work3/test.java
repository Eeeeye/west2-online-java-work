package com.Eeeeye.work3;

import com.sun.deploy.uitoolkit.impl.fx.AppletStageManager;

public class test {
    public static void main(String[] args) throws Exception {
        DataBase dataBase = new DataBase();

        //检测查询空表
        dataBase.selectOrders();
        dataBase.selectProducts();
        //检测订单是否可以在无对应商品时添加
        dataBase.addOrders(1,1,"14:00",3);
        //检测正常添加
        dataBase.addProducts(1,"1",3);
        dataBase.addOrders(1,1,"14:00",3);
        dataBase.addProducts(2,"2",2);
        dataBase.addOrders(2,2,"16:00",2);
        //检测是否可以输入非法价格
        dataBase.addProducts(3,"3",10);
        dataBase.addOrders(3,3,"12:00",1000000000);
        //重复输入检测异常是否正常抛出捕获
        dataBase.addProducts(1,"1",3);
        dataBase.addOrders(1,1,"14:00",3);
        //检测查询语句
        dataBase.selectOrders();
        dataBase.selectProducts();
        //检测修改语句以及对应异常
        dataBase.updateOrders(1,1,"18:00",3);
        //测试修改不存在的数据，此时输出false
        dataBase.updateOrders(10,1,"18:00",3);
        //修改数据与之前一致
        dataBase.updateProduct(1,"1",3);
        //测试删除功能
        dataBase.deleteOrders(1);
        dataBase.deleteProducts(1);
        //测试是否可以删除已存在订单中的商品
        //由于外键存在，返回输入有误
        dataBase.deleteProducts(2);
        //先删除订单，后删除商品
        dataBase.deleteOrders(2);
        dataBase.deleteProducts(2);
    }
}
