package com.navin.melalwallet.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "basket")
public class Basket {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "productId")
    private int productId;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "icon")
    private String icon;


    public Basket(int productId, String title, String icon) {
        this.setIcon(icon);
        this.setProductId(productId);
        this.setTitle(title);
    }

    @Ignore
    public Basket(int id, int productId, String title, String icon) {
        this.setId(id);
        this.setIcon(icon);
        this.setProductId(productId);
        this.setTitle(title);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
}
