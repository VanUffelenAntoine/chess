package be.thomasmore.chess.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


@Entity
public class Game {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_generator")
    @SequenceGenerator(name = "game_generator",sequenceName = "game_seq",allocationSize = 1)
    @Id
    int id;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Player player1;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Player player2;
    @NotNull
    @Column(length = 2500)
    private String moves;
    @ManyToOne(fetch = FetchType.LAZY)
    private Opening openingUsed;
    @ManyToOne(fetch = FetchType.LAZY)
    private Variant variantUsed;

    public Game(int id) {
        this.id = id;
    }

    public Game() {
    }

    public ArrayList<String> getMovesAsArrayList() {
        ArrayList<String> moves = new ArrayList<>(Arrays.asList(this.moves.split(",")));
        return moves;
    }

    public ArrayList<String> getMoveList() {
        ArrayList<String> moveList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int counter = 2;
        for (String s : processAlgebraicNotation()) {
            if (counter % 2 == 0) {
                sb.append(counter / 2).append(". ").append(s);
            } else {
                sb.append(" ").append(s);
                moveList.add(sb.toString());
                sb.delete(0, sb.length());
            }
            counter++;
        }
        return moveList;
    }

    public ArrayList<String> processAlgebraicNotation() {
        this.moves = this.moves.replaceAll("\\r|\\n"," ");
        String[] holding = this.moves.split("\\s*[0-9]+\\.\\s*");
        ArrayList<String> listMoves = new ArrayList<>();

        for (String move : holding) {
            listMoves.addAll(Arrays.asList(move.split(" ")));
        }
        listMoves.remove(0);
        return listMoves;
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
