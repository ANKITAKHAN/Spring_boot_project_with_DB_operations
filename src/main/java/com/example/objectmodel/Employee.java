package com.example.objectmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Employee implements Serializable {

    private static final long getSerialVersionUID = 1L;

    @Id
    int id;

    @Column(nullable = false)
    String name;

    public Employee()
    {
        super();
    }

    public Employee(int id,String name)
    {
        super();
        this.id=id;
        this.name=name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


