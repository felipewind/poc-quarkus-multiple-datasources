package org.acme.repositories.users;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.acme.models.users.User;

@ApplicationScoped
public class UserRepository {

    @Inject
    EntityManager entityManager;

    public List<User> findAll() {
        return entityManager.createNamedQuery("Users.findAll", User.class).getResultList();
    }

}
