package com.wildcodeschool.checkpoint4.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rider implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRider;

    @NotNull
    private String name;

    @NotNull
    private String firstName;

    @NotNull
    private int age;

    @NotNull
    private String nationality;

    @NotNull
    private String urlPicRider;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "riders")
    @JsonIgnore
    private List<User> users = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "riders")
    @JsonIgnore
    private List<Circus> circuses = new ArrayList<>();


    public Rider() {
    }


    public Long getIdRider() {
        return idRider;
    }

    public void setIdRider(Long idRider) {
        this.idRider = idRider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getUrlPicRider() {
        return urlPicRider;
    }

    public void setUrlPicRider(String urlPicRider) {
        this.urlPicRider = urlPicRider;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Circus> getCircuses() {
        return circuses;
    }

    public void setCircuses(List<Circus> circuses) {
        this.circuses = circuses;
    }
}
