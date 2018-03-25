package org.csf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Andrew Boytsov
 * @date 25.03.2018
 */

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
