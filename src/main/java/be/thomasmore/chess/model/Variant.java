package be.thomasmore.chess.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Variant {
    @Id
    private int id;
    private String Name;
    private String move;
    @ManyToOne
    private Opening parentOpening;

    public Variant(int id, String name, String move) {
        this.id = id;
        Name = name;
        this.move = move;
    }

    public Variant() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public Opening getParentOpening() {
        return parentOpening;
    }

    public void setParentOpening(Opening parentOpening) {
        this.parentOpening = parentOpening;
    }
}
