package io.ezbrains.springbootjpaexaple;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EmailGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToMany(mappedBy = "emailGroup")
    private List<Employee> member = new ArrayList<>();

    public int getId() {
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

    public List<Employee> getMember() {
        return member;
    }

    public void setMember(List<Employee> member) {
        this.member = member;
    }
    public void addMember(Employee employee) {
        this.member.add(employee);
    }
}
