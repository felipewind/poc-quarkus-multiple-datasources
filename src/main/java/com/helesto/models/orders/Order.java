package com.helesto.models.orders;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
@NamedNativeQuery(name = "Orders.findAll", query = "SELECT * FROM ORDERS ORDER BY ID", resultClass = Order.class)

public class Order {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "PRODUCT_NAME", length = 100)
    private String productName;

    @Column(name = "ORDER_DATE")
    private LocalDate orderDate;

    @Column(name = "USER_ID")
    private long userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", orderDate=" + orderDate + ", productName=" + productName + ", userId=" + userId
                + "]";
    }

}
