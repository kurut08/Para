package com.para.games;
/*
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Game implements Serializable {
    @SequenceGenerator(
            name = "test_sequence_GAME",
            sequenceName = "test_sequence_GAME",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "test_sequence_GAME"
    )
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String title;
    private Double price;
    private String description;
    private Integer year;
    private String imageUrl;

    public Game(Integer id, String title, Double price, String description, Integer year, String imageUrl) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.year = year;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString(){
        return "Game{"+
                "id = "+id+'\''+
                "title = "+title+'\''+
                "price = "+price+'\''+
                "description = "+description+'\''+
                "year = "+year+'\''+
                "imageUrl = "+imageUrl+'\''+
                "}";
    }

}
*/