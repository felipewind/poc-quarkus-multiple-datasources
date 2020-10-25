package com.helesto.models.users;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
@NamedNativeQuery(name = "Users.findAll", query = "SELECT * FROM USERS ORDER BY ID", resultClass = User.class)

public class User {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", birthDate=" + birthDate + ", name=" + name + "]";
    }

}
