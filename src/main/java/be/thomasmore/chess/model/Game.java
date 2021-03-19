package be.thomasmore.chess.model;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Entity
public class Game {
    @Id
    int id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Player player1;
    @ManyToOne(fetch = FetchType.LAZY)
    private Player player2;
    @Column(length = 1000)
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
    public ArrayList<String> getMoveList(){
        ArrayList<String> moveList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int counter = 2;
        for (String s : getMovesAsArrayList()){
            if (counter % 2 == 0){
                sb.append(counter/2).append(". ").append(s);
            } else {
                sb.append(" ").append(s);
                moveList.add(sb.toString());
                sb.delete(0, sb.length());
            }
            counter++;
        }
        return moveList;
    }

    public int getId() {
        return id;
    }

    public String getMoves() {
        return moves;
    }

    public void setMoves(String moves) {
        this.moves = moves;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
}
