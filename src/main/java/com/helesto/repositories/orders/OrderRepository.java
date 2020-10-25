package com.helesto.repositories.orders;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.helesto.models.orders.Order;

import io.quarkus.hibernate.orm.PersistenceUnit;

@ApplicationScoped
public class OrderRepository {

    @Inject
    @PersistenceUnit("orders") 
    EntityManager entityManager;

    public void insertOrder(Order order) {
        entityManager.persist(order);        
    }

    public List<Order> findAll() {
        return entityManager.createNamedQuery("Orders.findAll", Order.class).getResultList();
    }

}
