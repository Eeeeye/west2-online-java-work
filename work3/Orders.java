package com.Eeeeye.work3;

public class Orders {
    //使用Integer避免默认值产生影响
    private Integer order_id   ;
    private Integer product_id ;
    private String order_time ;
    private Integer order_price;

    public Orders() {
    }

    public Orders(Integer order_id, Integer product_id, String order_time, Integer order_price) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.order_time = order_time;
        this.order_price = order_price;
    }

    /**
     * 获取
     * @return order_id
     */
    public Integer getOrder_id() {
        return order_id;
    }

    /**
     * 设置
     * @param order_id
     */
    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    /**
     * 获取
     * @return product_id
     */
    public Integer getProduct_id() {
        return product_id;
    }

    /**
     * 设置
     * @param product_id
     */
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    /**
     * 获取
     * @return order_time
     */
    public String getOrder_time() {
        return order_time;
    }

    /**
     * 设置
     * @param order_time
     */
    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    /**
     * 获取
     * @return order_price
     */
    public Integer getOrder_price() {
        return order_price;
    }

    /**
     * 设置
     * @param order_price
     */
    public void setOrder_price(Integer order_price) {
        this.order_price = order_price;
    }

    public String toString() {
        return "Orders{order_id = " + order_id + ", product_id = " + product_id + ", order_time = " + order_time + ", order_price = " + order_price + "}";
    }
}


