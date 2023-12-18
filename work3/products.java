package com.Eeeeye.work3;

public class products {
    Integer product_id   ;
    String product_name ;
    Integer product_price;

    public products() {
    }

    public products(Integer product_id, String product_name, Integer product_price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
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
     * @return product_name
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * 设置
     * @param product_name
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     * 获取
     * @return product_price
     */
    public Integer getProduct_price() {
        return product_price;
    }

    /**
     * 设置
     * @param product_price
     */
    public void setProduct_price(Integer product_price) {
        this.product_price = product_price;
    }

    public String toString() {
        return "products{product_id = " + product_id + ", product_name = " + product_name + ", product_price = " + product_price + "}";
    }
}
