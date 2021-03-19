package be.thomasmore.chess.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Entity
public class Game {
    @Id
    int id;
    private String moves;

    public Game(int id) {
        this.id = id;
    }

    public Game() {
    }
    public ArrayList<String> getMovesAsArrayList(){
        ArrayList<String> moves = new ArrayList<>(Arrays.asList(this.moves.split(",")));
        return moves;
    }
    public String getMoves() {
        return moves;
    }

    public void setMoves(String moves) {
        this.moves = moves;
    }
}
