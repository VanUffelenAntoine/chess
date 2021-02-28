package be.thomasmore.chess.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Variant {
    @Id
    private int id;
    private String Name;
    private int idParentMove;
    private String move;

    public Variant(int id, String name, int idParentMove, String move) {
        this.id = id;
        Name = name;
        this.idParentMove = idParentMove;
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

    public int getIdParentMove() {
        return idParentMove;
    }

    public void setIdParentMove(int idOpening) {
        this.idParentMove = idOpening;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }
}
