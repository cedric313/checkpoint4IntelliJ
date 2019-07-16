package com.wildcodeschool.checkpoint4.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
}
