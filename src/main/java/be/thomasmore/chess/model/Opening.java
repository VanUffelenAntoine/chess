package be.thomasmore.chess.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Opening{
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opening_generator")
    @SequenceGenerator(name = "opening_generator",sequenceName = "opening_seq",allocationSize = 1)
    @Id
    int id;
    private String openingName;
    private String move1;
    private String move2;
    private String type;
    private boolean gambit;
    private String linkMoreInfo;
    private String linkPhoto;
    @OneToMany (mappedBy = "parentOpening")
    List<Variant> variants;

    public Opening() {
    }

    public Opening(int id) {
        this.id = id;
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

    public Opening(int id, String openingName, String move1, String move2, String type, boolean gambit, String linkMoreInfo, String linkPhoto) {
        this.id = id;
        this.openingName = openingName;
        this.move1 = move1;
        this.move2 = move2;
        this.type = type;
        this.gambit = gambit;
        this.linkMoreInfo = linkMoreInfo;
        this.linkPhoto = linkPhoto;
    }
    public ArrayList<String> getMoveList(){
        ArrayList<String> moveList = new ArrayList<>();
        moveList.addAll(Arrays.asList(move1.split(" ")));
        if (move2 != null)
        moveList.addAll(Arrays.asList(move2.split(" ")));
        return moveList;
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

    public String getLinkPhoto() {
        return linkPhoto;
    }

    public void setLinkPhoto(String linkPhoto) {
        this.linkPhoto = linkPhoto;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }
}
