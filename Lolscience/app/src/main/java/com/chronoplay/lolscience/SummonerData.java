package com.chronoplay.lolscience;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Χρόνης on 17/8/2015.
 */
public class SummonerData {

    private String summonerName;
    private String championId;
    private String championName;
    private String summonerSpell1;
    private String summonerSpell2;
    private String summonerSpellId1;
    private String summonerSpellId2;
    private String summonerName1;
    private int teamId;
    List<Masteries> masteries = new ArrayList<Masteries>();
    List<Runes> runes = new ArrayList<Runes>();

    public SummonerData(){}

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public void setChampionId(String championId) {
        this.championId = championId;
    }

    public void setChampionName(String championName) {
        this.championName = championName;
    }

    public void setMasteries(List<Masteries> masteries) {
        this.masteries = masteries;
    }

    public void setRunes(List<Runes> runes) {
        this.runes = runes;
    }

    public void setSummonerSpellId1(String summonerId1) {
        this.summonerSpellId1 = summonerId1;
    }

    public void setSummonerSpellId2(String summonerId2) {
        this.summonerSpellId2 = summonerId2;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public void setSummonerName1(String summonerName1) {
        this.summonerName1 = summonerName1;
    }

    public List<Masteries> getMasteries() {
        return masteries;
    }

    public List<Runes> getRunes() {
        return runes;
    }

    public String getChampionId() {
        return championId;
    }

    public String getChampionName() {
        return championName;
    }

    public String getSummonerSpellId1() {
        return summonerSpellId1;
    }

    public String getSummonerSpellId2() {
        return summonerSpellId2;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public String getSummonerName1() {
        return summonerName1;
    }

    public int getTeamId() {
        return teamId;
    }

    public String getSummonerSpell1() {
        return summonerSpell1;
    }

    public void setSummonerSpell1(String summonerSpell1) {
        this.summonerSpell1 = summonerSpell1;
    }

    public String getSummonerSpell2() {
        return summonerSpell2;
    }

    public void setSummonerSpell2(String summonerSpell2) {
        this.summonerSpell2 = summonerSpell2;
    }
}
