package org.acme.repositories.users;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.acme.models.users.User;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    @Override
    public List<User> listAll() {
        return listAll();
    }

}
