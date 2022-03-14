package org.acme.repositories.users;

import javax.enterprise.context.ApplicationScoped;

import org.acme.models.users.User;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

}
