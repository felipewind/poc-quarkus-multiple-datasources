package org.acme.models.orders;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "ORDERS")
@NamedNativeQuery(name = "Orders.findAll", query = "SELECT * FROM ORDERS ORDER BY ID", resultClass = Order.class)

public class Order extends PanacheEntityBase {

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
