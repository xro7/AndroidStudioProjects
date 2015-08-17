package com.chronoplay.lolscience;

/**
 * Created by Χρόνης on 17/8/2015.
 */
public class Masteries {

    private String masteryId;
    private int rank;
    private int offense,defence,utility;

    public Masteries(){}

    public int getDefence() {
        return defence;
    }

    public int getOffense() {
        return offense;
    }

    public int getRank() {
        return rank;
    }

    public int getUtility() {
        return utility;
    }

    public String getMasteryId() {
        return masteryId;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setMasteryId(String masteryId) {
        this.masteryId = masteryId;
    }

    public void setOffense(int offense) {
        this.offense = offense;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setUtility(int utility) {
        this.utility = utility;
    }

}
