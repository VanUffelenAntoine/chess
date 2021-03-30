package be.thomasmore.chess.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Variant {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "variant_generator")
    @SequenceGenerator(name = "variant_generator", sequenceName = "variant_seq", allocationSize = 1)
    @Id
    private int id;
    @NotBlank
    private String Name;
    @NotBlank
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
