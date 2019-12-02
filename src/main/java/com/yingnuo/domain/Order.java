package com.yingnuo.domain;


import java.math.BigInteger;
import java.util.Date;

public class Order {
    private Long order_id;
    private String user_phone;
    private String actual_amount;
    private String pay_amount;
    private Date create_date;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getActual_amount() {
        return actual_amount;
    }

    public void setActual_amount(String actual_amount) {
        this.actual_amount = actual_amount;
    }

    public String getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(String pay_amount) {
        this.pay_amount = pay_amount;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", user_phone='" + user_phone + '\'' +
                ", actual_amount='" + actual_amount + '\'' +
                ", pay_amount='" + pay_amount + '\'' +
                ", create_date=" + create_date +
                '}';
    }
}