package org.acme.models.orders;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @Column(name = "ID")
    public long id;

    @Column(name = "PRODUCT_NAME", length = 100)
    public String productName;

    @Column(name = "ORDER_DATE")
    public LocalDate orderDate;

    @Column(name = "USER_ID")
    public long userId;

    @Override
    public String toString() {
        return "Order [id=" + id + ", orderDate=" + orderDate + ", productName=" + productName + ", userId=" + userId
                + "]";
    }

}
