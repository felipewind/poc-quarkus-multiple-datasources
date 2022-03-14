package org.acme.models.users;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "ID")
    public long id;

    @Column(name = "NAME", length = 100)
    public String name;

    @Column(name = "BIRTH_DATE")
    public LocalDate birthDate;

    @Override
    public String toString() {
        return "User [id=" + id + ", birthDate=" + birthDate + ", name=" + name + "]";
    }

}
