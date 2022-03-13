package org.acme.repositories.orders;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.acme.models.orders.Order;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<Order> {

    @Override
    public List<Order> listAll() {
        return listAll();
    }

}
