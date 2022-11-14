package com.example.docktor_mobile.models;

import lombok.Data;

@Data
public class TopLink {
    private String name;
    private String description;
    private String url;

    @Override
    public String toString() {
        return "TopLink{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
