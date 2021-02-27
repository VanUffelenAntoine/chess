package be.thomasmore.chess.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Opening {
    @Id
    int id;
    private String openingName;
    private String move1;
    private String move2;
    private String type;
    private boolean gambit;
    private String linkMoreInfo;

    public Opening() {
    }

    public Opening(String openingName) {
        this.openingName = openingName;
    }

    public Opening(int id, String openingName, String move1, String move2, String type, boolean gambit, String linkMoreInfo) {
        this.id = id;
        this.openingName = openingName;
        this.move1 = move1;
        this.move2 = move2;
        this.type = type;
        this.gambit = gambit;
        this.linkMoreInfo = linkMoreInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpeningName() {
        return openingName;
    }

    public void setOpeningName(String openingNaam) {
        this.openingName = openingNaam;
    }

    public String getMove1() {
        return move1;
    }

    public void setMove1(String move1) {
        this.move1 = move1;
    }

    public String getMove2() {
        return move2;
    }

    public void setMove2(String move2) {
        this.move2 = move2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isGambit() {
        return gambit;
    }

    public void setGambit(boolean gambit) {
        this.gambit = gambit;
    }

    public String getLinkMoreInfo() {
        return linkMoreInfo;
    }

    public void setLinkMoreInfo(String linkMoreInfo) {
        this.linkMoreInfo = linkMoreInfo;
    }
}
