package org.csf.domain;

import javax.persistence.*;

/**
 * @author Andrew Boytsov
 * @date 25.03.2018
 */

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cassette_name")
    private String cassetteName;

    @Column(name = "description")
    private String description;

    public Request() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCassetteName() {
        return cassetteName;
    }

    public void setCassetteName(String cassetteName) {
        this.cassetteName = cassetteName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
