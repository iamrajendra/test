package com.iamrajendra.fermiq_machine_test.model;

import org.json.JSONObject;

public class Country {
private String name;
private String image;

    public Country(JSONObject object) {
        name = object.optString("title");
        image = object.optString("url");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
