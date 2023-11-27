package com.app.para.games;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MyGames")
public class GameUser {

    @Id
    private int id;
    private String title;
    private String description;

    private String imageUrl;
    private String price;
    public GameUser() {
        super();
        // TODO Auto-generated constructor stub
    }
    public GameUser(int id, String title, String description, String imageUrl, String price) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrice() {
        return price;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
