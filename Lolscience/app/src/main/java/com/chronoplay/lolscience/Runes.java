package com.chronoplay.lolscience;

/**
 * Created by Χρόνης on 17/8/2015.
 */
public class Runes {

    private String runeId;
    private String description;
    private int count;

    public Runes(){

    }

    public String getRuneId() {
        return runeId;
    }

    public int getCount() {
        return count;
    }

    public String getDescription() {
        return description;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRuneId(String runeId) {
        this.runeId = runeId;
    }
}
