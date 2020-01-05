package com.navin.melalwallet.models;

import com.google.gson.annotations.SerializedName;

public class Category {


    @SerializedName("id")
    private String Id;

    @SerializedName("title")
    private String title;

    @SerializedName("icon")
    private String icon;

    @SerializedName("description")
    private String description;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
