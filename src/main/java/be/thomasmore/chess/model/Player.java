package be.thomasmore.chess.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Player {
    @Id
    private int id;
    private String name;
    private Integer rating;
    @Column(length = 1500)
    private String description;

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
