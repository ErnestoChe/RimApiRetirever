package com.pm.course.domain;

import com.pm.course.domain.enums.Status;
import org.json.JSONObject;

public class CharacterRim {

    String name;
    String avatarUrl;
    String species;
    Status status;
    String gender;
    String location;
    String image;
    Long id;

    public CharacterRim(String name, String avatarUrl, String species, Status status, String gender, String location, Long id) {
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.species = species;
        this.status = status;
        this.gender = gender;
        this.location = location;
        this.id = id;
    }
    public CharacterRim(JSONObject json){
        this.gender = json.get("gender").toString();
        this.id = (Long.valueOf(json.get("id").toString()));
        this.image = (json.get("image").toString());
        this.name = (json.get("name").toString());
        this.species = (json.get("species").toString());
        this.status = (Status.valueOf(json.get("status").toString()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}



