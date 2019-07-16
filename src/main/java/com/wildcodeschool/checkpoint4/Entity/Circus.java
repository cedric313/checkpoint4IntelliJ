package com.wildcodeschool.checkpoint4.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Circus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCircus;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String date;

    @NotNull
    @NotEmpty
    private String location;

    private String urlPhoto;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "circusRiders",
            joinColumns = {@JoinColumn(name = "idRider")},
            inverseJoinColumns = {@JoinColumn(name = "idCircus")})
    private List<Rider> riders = new ArrayList<>();

    public Circus() {
    }

    public Long getIdCircus() {
        return idCircus;
    }

    public void setIdCircus(Long idCircus) {
        this.idCircus = idCircus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public List<Rider> getRiders() {
        return riders;
    }

    public void setRiders(List<Rider> riders) {
        this.riders = riders;
    }
}
