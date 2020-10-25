package com.helesto.repositories.users;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.helesto.models.users.User;

import io.quarkus.hibernate.orm.PersistenceUnit;

@ApplicationScoped
public class UserRepository {

    @Inject
    @PersistenceUnit("users") 
    EntityManager entityManager;

    public List<User> findAll() {
        return entityManager.createNamedQuery("Users.findAll", User.class).getResultList();
    }

}
