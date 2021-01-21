package com.example.pd_babahovgleb;

import java.util.Arrays;

public class Pokemon {
    private int id;
    private Name name;
    private String[] type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pokemon:" +
                "id=" + id +
                ", name=" + name +
                ", type=" + Arrays.toString(type);
    }
}
