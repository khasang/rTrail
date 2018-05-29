package io.khasang.rtrail.entity;

import javax.persistence.*;

@Entity
@Table(name = "cats")
public class Cat {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private long id;

    private String name;
    @Column(name = "descr")
    private String description;


}
