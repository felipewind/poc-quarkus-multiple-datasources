package org.acme.repositories.orders;

import javax.enterprise.context.ApplicationScoped;

import org.acme.models.orders.Order;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<Order> {

}
